plugins {
    id("noty.android.library")
    id("noty.koin")
    id("noty.android.library.compose")
}

dependencies {
    implementation(libs.gson)
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.navigation.compose)
}