plugins {
    `kotlin-dsl`
}

group = "com.fediim.fitmetrics.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.dokka.gradlePlugin)
    compileOnly(libs.sonarqube.gradlePlugin)
    compileOnly(libs.openapi.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "fitmetrics.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "fitmetrics.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = "fitmetrics.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidCompose") {
            id = "fitmetrics.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("dokka") {
            id = "fitmetrics.dokka"
            implementationClass = "DokkaConventionPlugin"
        }
        register("jacocoPlugin") {
            id = "fitmetrics.jacoco"
            implementationClass = "JacocoConventionPlugin"
        }
        register("sonarqubePlugin") {
            id = "fitmetrics.sonarqube"
            implementationClass = "SonarqubeConventionPlugin"
        }
        register("openapiPlugin") {
            id = "fitmetrics.openapi"
            implementationClass = "OpenApiConventionPlugin"
        }
    }
}
