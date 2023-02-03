pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Noty"
include(":notyAndroid")
include(":shared")
include(":build-logic")
include(":build-logic:convention")
