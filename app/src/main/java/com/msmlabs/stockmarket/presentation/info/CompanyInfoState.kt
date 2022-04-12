package com.msmlabs.stockmarket.presentation.info

import com.msmlabs.stockmarket.domain.model.CompanyInfo
import com.msmlabs.stockmarket.domain.model.IntraDayInfo

data class CompanyInfoState(
    val stockInfoList: List<IntraDayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
