plugins {
    alias(libs.plugins.moneyConvertor.android.feature)
    alias(libs.plugins.moneyConvertor.android.compose)
}

android {
    namespace = "com.mc.currencyconvertor"
}


dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))
}