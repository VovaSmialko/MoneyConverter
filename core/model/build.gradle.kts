plugins {
    alias(libs.plugins.moneyConvertor.jvm)
    id("kotlinx-serialization")
}

dependencies {
    implementation(libs.kotlin.serialization.json)
}
