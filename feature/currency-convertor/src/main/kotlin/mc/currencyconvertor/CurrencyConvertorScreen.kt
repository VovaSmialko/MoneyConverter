package mc.currencyconvertor

import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mc.designsystem.components.MCBackgroundScreen
import com.mc.designssystem.R
import com.mc.designsystem.components.MCCard
import com.mc.designsystem.components.MCTextField
import com.mc.designsystem.components.MCTextMenu
import com.mc.designsystem.theme.MoneyConverterTheme
import kotlinx.coroutines.launch

@Composable
internal fun CurrencyConvertorRoute() {


}

@Composable
fun CurrencyConvertorScreen() {

    MCBackgroundScreen {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(id = R.string.currency_convertor),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.currency_convertor_description),
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color(0xff808080)
            )
            Spacer(modifier = Modifier.height(15.dp))
            CurrencyConvertorCard(
                allCurrencies = listOf(),
                fromCurrency = CurrencyUiModel("USD", ""),
                toCurrency = CurrencyUiModel("UAH", ""),
                onFromCurrencyUiModel = {},
                onToCurrencyUiModel = {},
                onSwap = {}
            )
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.indicative_exchane_rate),
                modifier = Modifier.padding(horizontal = 22.dp),
                style = MaterialTheme.typography.labelSmall
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Placeholder",
                modifier = Modifier.padding(horizontal = 22.dp),
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color.Black
                )
            )

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Composable
private fun CurrencyConvertorCard(
    modifier: Modifier = Modifier,
    allCurrencies: List<CurrencyUiModel>,
    fromCurrency: CurrencyUiModel,
    toCurrency: CurrencyUiModel,
    onFromCurrencyUiModel: (CurrencyUiModel) -> Unit,
    onToCurrencyUiModel: (CurrencyUiModel) -> Unit,
    onSwap: () -> Unit
) {

    MCCard(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    )
    {
        CurrencyInfoRow(
            label = stringResource(id = R.string.amount),
            selectedCurrency = fromCurrency,
            currencies = allCurrencies,
            onCurrencyChange = onFromCurrencyUiModel
        )
        Spacer(modifier = Modifier.height(20.dp))
        CurrenciesSwapper(onSwap = onSwap)
        Spacer(modifier = Modifier.height(10.dp))

        CurrencyInfoRow(
            label = stringResource(id = R.string.converted_amount),
            selectedCurrency = toCurrency,
            currencies = allCurrencies,
            onCurrencyChange = onToCurrencyUiModel
        )
    }
}

@Composable
private fun CurrencyInfoRow(
    modifier: Modifier = Modifier,
    label: String,
    selectedCurrency: CurrencyUiModel,
    currencies: List<CurrencyUiModel>,
    onCurrencyChange: (CurrencyUiModel) -> Unit
) {

    val currencyCodes = remember(currencies) {
        currencies.map { it.code }

    }

    Column(modifier = modifier) {
        Text(text = label, style = MaterialTheme.typography.labelSmall)

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedContent(
                targetState = selectedCurrency.code,
                modifier = Modifier.weight(1f), label = ""
            ) {
                MCTextMenu(
                    selectedOption = it,
                    options = currencyCodes,
                    onOptionSelected = { index ->
                        onCurrencyChange(currencies[index].copy(value = selectedCurrency.value))
                    }
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            MCTextField(
                value = selectedCurrency.value,
                onValueChange = { onCurrencyChange(selectedCurrency.copy(value = it)) },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }
    }
}

@Composable
fun CurrenciesSwapper(
    modifier: Modifier = Modifier,
    onSwap: () -> Unit
) {

    val animatable = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    val scope = rememberCoroutineScope()

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalDivider()
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .clickable {
                    if (animatable.isRunning)
                        return@clickable
                    scope.launch {
                        onSwap()
                        animatable.animateTo(
                            animatable.value + 180f,
                            tween(300)
                        )
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_swap),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    .rotate(animatable.value)
            )
        }
    }
}

@Preview
@Composable
private fun Screen() {
    MoneyConverterTheme {
        CurrencyConvertorScreen()
    }
}