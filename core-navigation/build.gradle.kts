plugins {
    id("noty.android.library")
    id("noty.hilt")
    id("noty.android.library.compose")
}

dependencies {
    implementation(libs.gson)
    implementation(libs.androidx.lifecycle.livedata)
}