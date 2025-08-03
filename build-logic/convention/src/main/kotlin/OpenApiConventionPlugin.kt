import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.openapitools.generator.gradle.plugin.extensions.OpenApiGeneratorGenerateExtension

class OpenApiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.openapi.generator")
            }

            val generatedApiDir = rootProject.layout.projectDirectory.dir("core/api/build/generated-api")
            val apiSrcDir = rootProject.layout.projectDirectory.dir("core/api/src")
            val apiModuleDir = rootProject.layout.projectDirectory.dir("core/api")

            extensions.configure<OpenApiGeneratorGenerateExtension> {
                generatorName.set("kotlin")
                inputSpec.set("$rootDir/open-api/fitbit-open-api.yaml")
                outputDir.set(generatedApiDir.asFile.absolutePath)
                packageName.set("com.fediim.fitmetrics.api")
                configOptions.put("serializableModel", "true")
                configOptions.put("serializationLibrary", "kotlinx_serialization")
                configOptions.put("library", "jvm-ktor")
            }

            val openApiGenerate = tasks.named("openApiGenerate")

            val copyOpenApiSources = tasks.register<Copy>("copyOpenApiSources") {
                group = "openapi tools"
                description = "Copy OpenAPI generated sources into src"
                from(generatedApiDir.dir("src"))
                into(apiSrcDir)
                include("**/*")
                includeEmptyDirs = false

                inputs.dir(generatedApiDir.dir("src"))
                outputs.dir(apiSrcDir)

                dependsOn(openApiGenerate)
            }

            val copyOpenApiDocs = tasks.register<Copy>("copyOpenApiDocs") {
                group = "openapi tools"
                description = "Copy OpenAPI generated docs (README, LICENSE, docs folder) into module root"

                from(generatedApiDir) {
                    include("README*")
                    exclude("src/**", "docs/**")
                }
                from(generatedApiDir.dir("docs")) {
                    into("docs")
                    include("**/*")
                }

                into(apiModuleDir)
                includeEmptyDirs = false

                inputs.files(generatedApiDir.file("README.md")).ignoreEmptyDirectories()
                inputs.dir(generatedApiDir.dir("docs"))
                outputs.dir(apiModuleDir)
                outputs.dir(apiModuleDir.dir("docs"))

                dependsOn(openApiGenerate)
            }

            copyOpenApiSources.configure { mustRunAfter(copyOpenApiDocs) }

            openApiGenerate.configure {
                finalizedBy(copyOpenApiSources, copyOpenApiDocs)
            }
        }
    }
}
