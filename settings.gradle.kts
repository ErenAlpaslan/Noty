pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "Noty"
include(":notyAndroid")
include(":core-designsystem")
include(":shared")
include(":core-navigation")
include(":core-common")
include(":notyAndroid:feature-splash")
include(":notyAndroid:feature-home")
include(":notyAndroid:feature-category")
include(":notyAndroid:feature-premium")
include(":notyAndroid:feature-settings")
include(":notyAndroid:feature-note")
