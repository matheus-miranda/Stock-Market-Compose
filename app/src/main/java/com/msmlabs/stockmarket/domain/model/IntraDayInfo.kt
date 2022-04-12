package com.msmlabs.stockmarket.domain.model

import java.time.LocalDateTime

data class IntraDayInfo(
    val date: LocalDateTime,
    val close: Double
)
