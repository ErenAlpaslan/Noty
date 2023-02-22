plugins {
    id("noty.android.library")
    id("noty.koin")
    id("noty.android.library.compose")
}

dependencies {
    implementation(project(":core-navigation"))
    implementation(libs.core.ktx)
    implementation(libs.androidx.livedata)
}