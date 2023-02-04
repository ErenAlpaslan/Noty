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
