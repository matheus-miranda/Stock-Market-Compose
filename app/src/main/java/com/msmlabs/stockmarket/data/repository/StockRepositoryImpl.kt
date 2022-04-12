package com.msmlabs.stockmarket.data.repository

import com.msmlabs.stockmarket.BuildConfig
import com.msmlabs.stockmarket.data.csv.CsvParser
import com.msmlabs.stockmarket.data.local.StockDatabase
import com.msmlabs.stockmarket.data.mapper.toCompanyInfo
import com.msmlabs.stockmarket.data.mapper.toCompanyListing
import com.msmlabs.stockmarket.data.mapper.toCompanyListingEntity
import com.msmlabs.stockmarket.data.remote.StockApi
import com.msmlabs.stockmarket.domain.model.CompanyInfo
import com.msmlabs.stockmarket.domain.model.CompanyListing
import com.msmlabs.stockmarket.domain.model.IntraDayInfo
import com.msmlabs.stockmarket.domain.repository.StockRepository
import com.msmlabs.stockmarket.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api: StockApi,
    db: StockDatabase,
    private val companyListingParser: CsvParser<CompanyListing>,
    private val intraDayInfoParser: CsvParser<IntraDayInfo>
) : StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))

            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Success(data = localListings.map { it.toCompanyListing() }))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListings = try {
                val response = api.getListings(BuildConfig.API_KEY)
                companyListingParser.parse(response.byteStream())
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->
                dao.clearCompanyListings()
                dao.insertCompanyListings(
                    listings.map { it.toCompanyListingEntity() }
                )
                emit(Resource.Success(
                    data = dao
                        .searchCompanyListing("")
                        .map { it.toCompanyListing() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }

    override suspend fun getIntraDayInfo(symbol: String): Resource<List<IntraDayInfo>> {
        return try {
            val response = api.getIntraDayInfo(symbol)
            val results = intraDayInfoParser.parse(response.byteStream())
            Resource.Success(results)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error("Couldn't load IntraDayInfo")
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("Couldn't load IntraDayInfo")
        }
    }

    override suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo> {
        return try {
            val result = api.getCompanyInfo(symbol)
            Resource.Success(result.toCompanyInfo())
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error("Couldn't load company info")
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("Couldn't load company info")
        }
    }
}
