package com.smialko.moneyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mc.designsystem.theme.MoneyConverterTheme
import com.mc.network.service.CurrencyService
import dagger.hilt.android.AndroidEntryPoint
import mc.currencyconvertor.CurrencyConvertorScreen
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var service: CurrencyService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyConverterTheme {
                CurrencyConvertorScreen()
            }
        }
    }
}