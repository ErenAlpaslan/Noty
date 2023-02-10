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
include(":core-preferences")
include(":notyAndroid:feature-splash")
include(":notyAndroid:feature-main:feature-home")
include(":notyAndroid:feature-main:feature-category")
include(":notyAndroid:feature-main:feature-premium")
include(":notyAndroid:feature-main:feature-settings")
