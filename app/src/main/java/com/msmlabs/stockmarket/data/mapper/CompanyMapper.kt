package com.msmlabs.stockmarket.data.mapper

import com.msmlabs.stockmarket.data.local.CompanyListingEntity
import com.msmlabs.stockmarket.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing() = CompanyListing(
    symbol = this.symbol,
    name = this.name,
    exchange = this.exchange
)

fun CompanyListing.toCompanyListingEntity() = CompanyListingEntity(
    symbol = this.symbol,
    name = this.name,
    exchange = this.exchange
)
