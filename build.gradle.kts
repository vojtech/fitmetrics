buildscript {
    dependencies {
        classpath(libs.google.oss.licenses.plugin) {
            exclude(group = "com.google.protobuf")
        }
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.sonarqube) apply false
    alias(libs.plugins.openapi.generator) apply false
    alias(libs.plugins.fediim.android.dokka)
    alias(libs.plugins.fediim.android.jacoco)
    alias(libs.plugins.fediim.android.sonarqube)
    alias(libs.plugins.fediim.android.openapi)
}
