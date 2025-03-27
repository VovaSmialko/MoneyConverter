plugins {
    alias(libs.plugins.moneyConvertor.android.library)
    alias(libs.plugins.moneyConvertor.android.room)
    alias(libs.plugins.moneyConvertor.android.hilt)

}

android {
    namespace = "com.mc.database"
}

dependencies {
    implementation(project(":core:model"))
}