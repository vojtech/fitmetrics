plugins {
    kotlin("jvm") apply false
    alias(libs.plugins.fediim.android.dokka)
}

dependencies {
    dokka(projects.core.api)
    dokka(projects.core.data)
    dokka(projects.core.datastore)
    dokka(projects.core.domain)
    dokkaHtmlPlugin(libs.dokka)
}

dokka {
    moduleName.set("FitBit Analyser")
}

val currentVersion = "1.0"
val previousVersionsDirectory: Directory = layout.projectDirectory.dir("versions")

dokka {
    pluginsConfiguration {
        versioning {
            version = currentVersion
            olderVersionsDir = previousVersionsDirectory
        }
    }
}
