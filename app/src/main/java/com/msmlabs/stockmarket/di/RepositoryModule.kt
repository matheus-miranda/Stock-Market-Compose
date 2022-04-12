package com.msmlabs.stockmarket.di

import com.msmlabs.stockmarket.data.csv.CompanyListingsParser
import com.msmlabs.stockmarket.data.csv.CsvParser
import com.msmlabs.stockmarket.data.repository.StockRepositoryImpl
import com.msmlabs.stockmarket.domain.model.CompanyListing
import com.msmlabs.stockmarket.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CsvParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}
