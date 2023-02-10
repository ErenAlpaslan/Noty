plugins {
    id("noty.android.library")
    id("noty.android.library.compose")
    id("noty.android.feature")
    id("noty.hilt")
}
dependencies {
    implementation(project("feature-home"))
    implementation(project("feature-category"))
    implementation(project("feature-premium"))
    implementation(project("feature-settings"))

}