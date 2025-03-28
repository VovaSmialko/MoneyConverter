plugins {
    alias(libs.plugins.moneyConvertor.android.library)
    alias(libs.plugins.moneyConvertor.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.mc.network"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.retrofit.logger)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlin.serialization.json)

    implementation(project(":core:model"))
}