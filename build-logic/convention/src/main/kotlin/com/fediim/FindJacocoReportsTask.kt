package com.fediim

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import javax.inject.Inject
import java.io.ByteArrayOutputStream

abstract class FindJacocoReportsTask @Inject constructor(
    private val execOps: ExecOperations
) : DefaultTask() {

    @get:Input
    @get:Optional
    abstract val jacocoVariants: Property<String>

    @get:OutputFile
    abstract val reportPathsFile: RegularFileProperty

    @TaskAction
    fun findReports() {
        val output = ByteArrayOutputStream()

        execOps.exec {
            commandLine(
                "python3",
                "${project.rootProject.projectDir.absolutePath}/scripts/find_jacoco_reports.py",
               "${project.rootProject.projectDir.absolutePath}/"
            )

            if (jacocoVariants.isPresent) {
                args("--variants", *jacocoVariants.get().split(",").toTypedArray())
            }
            standardOutput = output
        }

        val reportPaths = output.toString().lines().filter { it.endsWith(".xml") }.joinToString(",")
        reportPathsFile.get().asFile.writeText(reportPaths)
    }
}

