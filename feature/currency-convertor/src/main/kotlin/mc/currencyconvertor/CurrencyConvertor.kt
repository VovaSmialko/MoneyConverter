package mc.currencyconvertor

object CurrencyConvertor {

    /*
    BASE currency is UDS

   EUR to USD = 1,08
   USD to CAD = 0.70

   (0.70 / 1,08) * 10 =

     */

    fun convert(
        fromCurrencyRateVsBaseCurrencyRate: Double,
        toCurrencyRateVsBaseCurrencyRate: Double,
        amount: Double
    ): Double {
        return (toCurrencyRateVsBaseCurrencyRate / fromCurrencyRateVsBaseCurrencyRate) * amount
    }
}