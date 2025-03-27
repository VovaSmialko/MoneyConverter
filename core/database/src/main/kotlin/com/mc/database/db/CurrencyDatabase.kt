package com.mc.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mc.database.convertor.CurrencyRatesConvertor
import com.mc.database.dao.CurrencyDao
import com.mc.database.model.ExchangeRatesEntity


@Database(
    entities = [ExchangeRatesEntity::class],
    version = 1,
)
@TypeConverters(CurrencyRatesConvertor::class)
abstract class CurrencyDatabase: RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao

    companion object {

        const val DATABASE_NAME = "currency_db"
    }
}