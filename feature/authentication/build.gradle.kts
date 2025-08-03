plugins {
    alias(libs.plugins.fediim.android.library)
    alias(libs.plugins.fediim.android.hilt)
    alias(libs.plugins.fediim.android.compose)
}

android {
    namespace = "com.fediim.fitmetrics.feature.authentication"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.designSystem)
    implementation(projects.core.localisation)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.browser)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
