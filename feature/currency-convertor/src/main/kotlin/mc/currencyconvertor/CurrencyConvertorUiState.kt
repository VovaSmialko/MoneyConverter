package mc.currencyconvertor

data class CurrencyConvertorUiState(
    val isLoading: Boolean = true,
    val allCurrencies: List<CurrencyUiModel> = emptyList(),
    val fromCurrency: CurrencyUiModel = CurrencyUiModel("",""),
    val toCurrency: CurrencyUiModel = CurrencyUiModel("", ""),
    val indicativeExchangeRate: String = "",
    val lastUpdated: String = ""
) {
    companion object {
        val PreviewData = CurrencyConvertorUiState(
            fromCurrency = CurrencyUiModel(code = "USD", value = "1000.00"),
            toCurrency = CurrencyUiModel(code = "USD", value = "312.00"),
            indicativeExchangeRate = " 1 UDS = 1 UDS"
        )
    }
}
