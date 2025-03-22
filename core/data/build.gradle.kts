plugins {
    alias(libs.plugins.moneyConvertor.android.library)
    alias(libs.plugins.moneyConvertor.android.hilt)
}

android {
    namespace = "com.mc.data"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:network"))
}