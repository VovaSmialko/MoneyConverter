package com.mc.data.repository

import com.mc.model.currency_convertor.ExchangeRates
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    suspend fun getExchangeRates(): ExchangeRates
}