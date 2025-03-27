plugins {
    alias(libs.plugins.moneyConvertor.android.library)
    alias(libs.plugins.moneyConvertor.android.hilt)
    alias(libs.plugins.moneyConvertor.android.room)
}

android {
    namespace = "com.mc.data"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:network"))
    implementation(project(":core:common"))
    implementation(project(":core:database"))

    implementation(libs.androidx.work)
    implementation(libs.hilt.ext.work)
}