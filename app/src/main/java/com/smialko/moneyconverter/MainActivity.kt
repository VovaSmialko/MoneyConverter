package com.smialko.moneyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.mc.database.db.CurrencyDatabase
import com.mc.database.model.ExchangeRatesEntity
import com.mc.designsystem.theme.MoneyConverterTheme
import com.mc.network.service.CurrencyService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import mc.currencyconvertor.CurrencyConvertorRoute
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var currencyDatabase: CurrencyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            currencyDatabase.currencyDao().upsertExchangeRates(
                ExchangeRatesEntity("USD", "1.0", mapOf())
            )
        }

        setContent {
            MoneyConverterTheme {
                CurrencyConvertorRoute()
            }
        }
    }
}