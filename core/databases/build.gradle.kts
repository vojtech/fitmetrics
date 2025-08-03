plugins {
    alias(libs.plugins.fediim.android.library)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.fediim.fitmetrics.databases"
}

dependencies {
    // Expose Room APIs transitively so dependents (e.g., :core:data) can access Room.databaseBuilder
    api(libs.room.runtime)
    api(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.kotlinx.coroutines.android)
}
