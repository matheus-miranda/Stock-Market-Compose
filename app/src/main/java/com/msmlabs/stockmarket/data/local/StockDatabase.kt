package com.msmlabs.stockmarket.data.local

import androidx.room.Database

@Database(
    entities = [CompanyListingEntity::class],
    version = 1,
    exportSchema = false
)
abstract class StockDatabase {
    abstract val dao: StockDao
}