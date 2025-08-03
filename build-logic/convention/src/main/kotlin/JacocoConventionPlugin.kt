import com.android.build.api.artifact.ScopedArtifact
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.api.variant.ScopedArtifacts
import com.android.build.api.variant.SourceDirectories
import com.fediim.coverageExclusions
import com.fediim.libs
import com.fediim.toCapitalize
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

class JacocoConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("jacoco")
            }

            plugins.withId("com.android.application") {

                val androidExtension = extensions.getByType<ApplicationExtension>()

                androidExtension.buildTypes.configureEach {
                    enableAndroidTestCoverage = true
                    enableUnitTestCoverage = true
                }

                extensions.configure<ApplicationAndroidComponentsExtension> {
                    setupJacoco(this)
                }
            }

            plugins.withId("com.android.library") {
                val libraryExtension = extensions.getByType<LibraryExtension>()
                libraryExtension.buildTypes.configureEach {
                    enableAndroidTestCoverage = true
                    enableUnitTestCoverage = true
                }
                extensions.configure<LibraryAndroidComponentsExtension> {
                    setupJacoco(this)
                }
            }
        }
    }
}

fun Project.setupJacoco(
    androidComponentsExtension: AndroidComponentsExtension<*, *, *>
) {
    configure<JacocoPluginExtension> {
        toolVersion = libs.findVersion("jacoco").get().toString()
    }

    androidComponentsExtension.onVariants { variant ->
        val myObjFactory = project.objects
        val buildDir = layout.buildDirectory.get().asFile
        val allJars: ListProperty<RegularFile> = myObjFactory.listProperty(RegularFile::class.java)
        val allDirectories: ListProperty<Directory> =
            myObjFactory.listProperty(Directory::class.java)
        val variantName = variant.name
        val variantNameCap = variantName.toCapitalize()
        val unitTestTaskName = "test${variantNameCap}UnitTest"
        val jacocoTaskName = "create${variantNameCap}CombinedCoverageReport"
        val reportTask =
            tasks.register(
                jacocoTaskName,
                JacocoReport::class,
            ) {

                classDirectories.setFrom(
                    allJars,
                    allDirectories.map { dirs ->
                        dirs.map { dir ->
                            myObjFactory.fileTree().setDir(dir).exclude(coverageExclusions)
                        }
                    },
                )
                reports {
                    xml.required = true
                    html.required = true
                }

                fun SourceDirectories.Flat?.toFilePaths(): Provider<List<String>> = this
                    ?.all
                    ?.map { directories -> directories.map { it.asFile.path } }
                    ?: provider { emptyList() }
                sourceDirectories.setFrom(
                    files(
                        variant.sources.java.toFilePaths(),
                        variant.sources.kotlin.toFilePaths()
                    ),
                )

                executionData.setFrom(
                    project.fileTree("$buildDir/outputs/unit_test_code_coverage/${variant.name}UnitTest")
                        .matching { include("**/*.exec") },

                    project.fileTree("$buildDir/outputs/code_coverage/${variant.name}AndroidTest")
                        .matching { include("**/*.ec") },
                )
            }


        variant.artifacts.forScope(ScopedArtifacts.Scope.PROJECT)
            .use(reportTask)
            .toGet(
                ScopedArtifact.CLASSES,
                { _ -> allJars },
                { _ -> allDirectories },
            )

        afterEvaluate {
            tasks.findByName(unitTestTaskName)?.finalizedBy(jacocoTaskName)
        }
    }

    tasks.withType<Test>().configureEach {
        configure<JacocoTaskExtension> {
            isIncludeNoLocationClasses = true
            excludes = listOf("jdk.internal.*")
        }
    }
}
