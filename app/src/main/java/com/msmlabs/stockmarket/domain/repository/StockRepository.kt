package com.msmlabs.stockmarket.domain.repository

import com.msmlabs.stockmarket.domain.model.CompanyListing
import com.msmlabs.stockmarket.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    suspend fun getCompanyListings(
        fetchFromRemote: Boolean, query: String
    ): Flow<Resource<List<CompanyListing>>>
}
