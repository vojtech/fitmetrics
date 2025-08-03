plugins {
    alias(libs.plugins.fediim.android.library)
    alias(libs.plugins.fediim.android.hilt)
}

android {
    namespace = "com.fediim.fitmetrics.datastore"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.datastore.preferences)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
