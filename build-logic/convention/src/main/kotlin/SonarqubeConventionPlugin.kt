import com.fediim.FindJacocoReportsTask
import com.fediim.coverageExclusions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.sonarqube.gradle.SonarExtension

class SonarqubeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.sonarqube")
            }

            extensions.configure<SonarExtension> {
                setAndroidVariant("debug")
                properties {
                    val jacocoReport =
                        file("${project.rootProject.projectDir.absolutePath}/build/jacoco/report_paths.txt")
                    property("sonar.projectKey", findProperty("fitmetricsSonarProjectKey", "fitmetrics"))
                    property("sonar.projectName", findProperty("fitmetricsSonarProjectName") ?: "fitmetrics")
                    property("sonar.organization", findProperty("sonarOrganization") ?: "")
                    property(
                        "sonar.host.url",
                        findProperty("sonarHostUrl") ?: System.getenv("SONAR_HOST_URL") ?: "http://localhost:9000"
                    )
                    (findProperty("sonarToken") ?: System.getenv("SONAR_TOKEN"))?.let { token ->
                        if ((token as String).isNotBlank()) property("sonar.token", token)
                    }
                    property("sonar.sourceEncoding", "UTF-8")
                    property("sonar.exclusions", coverageExclusions.joinToString(","))
                    property("sonar.kotlin.coveragePlugin", "jacoco")
                    property("sonar.coverage.jacoco.xmlReportPaths", jacocoReport.readText())
                }
            }

            val findReport = tasks.register<FindJacocoReportsTask>("findJacocoReports") {
                description = "Finds JaCoCo reports and saves the paths to a file."
                group = "verification"
                reportPathsFile.set(layout.buildDirectory.file("${rootProject.projectDir}/build/jacoco/report_paths.txt"))
            }

            tasks.named("sonar").configure {
                dependsOn(findReport)
            }
        }
    }

    private fun Project.findProperty(property: String, default: String): String {
        return providers.gradleProperty(property).getOrElse(default)
    }
}

