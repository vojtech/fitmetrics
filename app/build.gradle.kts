plugins {
    alias(libs.plugins.fediim.android.application)
    alias(libs.plugins.fediim.android.hilt)
    alias(libs.plugins.fediim.android.compose)
}

val debugKeystorePass: String by project
val debugKeystoreAlias: String by project
val debugKeystoreKeyPass: String by project
val releaseKeystorePass: String by project
val releaseKeystoreAlias: String by project
val releaseKeystoreKeyPass: String by project

val fitbitClientId: String by project
val fitbitClientSecret: String by project
val fitbitRedirectUrl: String by project

android {
    namespace = "com.fediim.fitmetrics"
    compileSdk = 36

    signingConfigs {
        getByName("debug") {
            storeFile = file("./../debug-keystore.jks")
            storePassword = debugKeystorePass
            keyAlias = debugKeystoreAlias
            keyPassword = debugKeystoreKeyPass
        }
        create("release") {
            storeFile = file("./../release-keystore.jks")
            storePassword = releaseKeystorePass
            keyAlias = releaseKeystoreAlias
            keyPassword = releaseKeystoreKeyPass
        }
    }

    defaultConfig {
        applicationId = "com.fediim.fitmetrics"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "FITBIT_CLIENT_ID", "\"$fitbitClientId\"")
        buildConfigField("String", "FITBIT_CLIENT_SECRET", "\"$fitbitClientSecret\"")
        buildConfigField("String", "FITBIT_REDIRECT_URI", "\"$fitbitRedirectUrl\"")
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
        }
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.datastore)
    implementation(projects.feature.authentication)
    implementation(projects.feature.activityLog)
    implementation(projects.feature.profile)
    implementation(projects.core.designSystem)
    implementation(projects.core.localisation)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
