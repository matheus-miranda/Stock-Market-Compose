package com.msmlabs.stockmarket.data.mapper

import com.msmlabs.stockmarket.data.local.CompanyListingEntity
import com.msmlabs.stockmarket.data.remote.dto.CompanyInfoDto
import com.msmlabs.stockmarket.domain.model.CompanyInfo
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

fun CompanyInfoDto.toCompanyInfo() = CompanyInfo(
    symbol = this.symbol ?: "",
    description = this.description ?: "",
    name = this.name ?: "",
    country = this.country ?: "",
    industry = this.industry ?: ""
)