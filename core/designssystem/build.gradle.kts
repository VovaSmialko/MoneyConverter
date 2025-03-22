import org.jetbrains.kotlin.cfg.pseudocode.and

plugins {
    alias(libs.plugins.moneyConvertor.android.library)
    alias(libs.plugins.moneyConvertor.android.compose)
}
android {
    namespace = "com.mc.designssystem"
}