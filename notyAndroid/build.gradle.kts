plugins {
    id("noty.android.application")
    id("noty.android.application.compose")
    id("noty.hilt")
    kotlin("android")
}

android {
    namespace = "com.easylife.noty.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.easylife.noty.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)

    //region Cores
    implementation(project(":core-designsystem"))
    implementation(project(":core-navigation"))
    implementation(project("feature-splash"))
    //implementation(project(":core-preferences"))

    //endregion

    //region Accompanist
    implementation(libs.accompanist.navigation.animation)
    //endregion

    //region Datastore
    implementation(libs.datastore.core)
    implementation(libs.datastore.preferences)
    //endregion
}