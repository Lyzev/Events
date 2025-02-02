/*
 * This file is part of https://github.com/SchizoidDevelopment/piko.
 *
 * Copyright (c) 2025. Lyzev
 *
 * Piko is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License, or
 * (at your option) any later version.
 *
 * Piko is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Piko. If not, see <https://www.gnu.org/licenses/>.
 */

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URI

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.dokka)
    `maven-publish`
    signing
}

group = project.extra["maven_group"] as String
version = project.extra["maven_version"] as String

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    ignoreFailures = true
}

kotlin {
    jvmToolchain((project.extra["java_version"] as String).toInt())
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
    from(tasks.javadoc)
}

dokka {
    moduleName.set("Piko")
    dokkaSourceSets.main {
        sourceLink {
            localDirectory.set(file("src/main/kotlin"))
            remoteUrl("https://github.com/SchizoidDevelopment/piko/tree/master/src/main/kotlin")
            remoteLineSuffix.set("#L")
        }
    }
    pluginsConfiguration.html {
        footerMessage.set("Copyright (c) 2023-2025. Lyzev")
    }
    dokkaPublications.html {
        outputDirectory.set(layout.buildDirectory.dir("dokkaHtmlOutput"))
    }
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.fromTarget(project.extra["java_version"] as String))
    }
}

tasks.register("publishToMavenCentral") {
    dependsOn("publishMavenPublicationToLocalRepository")

    doLast {
        exec {
            commandLine("sh", "-c", "cd build/repo && zip -r ../../build.zip ./*")
        }
        exec {
            commandLine("sh", "-c", "curl --request POST --verbose --header 'Authorization: Bearer ${System.getenv("MAVEN_USER_TOKEN")}' --form bundle=@build.zip https://central.sonatype.com/api/v1/publisher/upload")
        }
    }
}

signing {
    useGpgCmd()
}

publishing {
    repositories {
        maven {
            name = "Local"
            url = URI("file://${project.layout.buildDirectory.get()}/repo")
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = project.extra["maven_group"] as String
            artifactId = project.extra["maven_artifact"] as String
            version = project.extra["maven_version"] as String
            from(components["java"])
            artifact(sourcesJar.get())
            artifact(javadocJar.get())
            pom {
                name = "Piko"
                description = "Effortlessly manage events in your application with this lightweight and flexible event management library, designed to simplify the process of registering listeners and triggering events."
                url = "https://github.com/SchizoidDevelopment/piko"
                licenses {
                    license {
                        name = "GNU Affero General Public License v3.0"
                        url = "https://github.com/SchizoidDevelopment/piko/blob/master/LICENSE"
                    }
                }
                developers {
                    developer {
                        id = "Lyzev"
                    }
                }
                scm {
                    connection = "scm:git:git://github.com/SchizoidDevelopment/piko.git"
                    developerConnection = "scm:git:ssh://github.com/SchizoidDevelopment/piko.git"
                    url = "https://github.com/SchizoidDevelopment/piko.git"
                }
            }
            the<SigningExtension>().sign(this)
        }
    }
}
