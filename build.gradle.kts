/*
 * This file is part of https://github.com/Lyzev/Events.
 *
 * Copyright (c) 2025. Lyzev
 *
 * Events is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License, or
 * (at your option) any later version.
 *
 * Events is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Events. If not, see <https://www.gnu.org/licenses/>.
 */

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.dokka)
    `maven-publish`
}

group = project.extra["maven_group"] as String
version = project.extra["maven_version"] as String

repositories {
    mavenCentral()
}

dependencies {
    // https://kotlinlang.org/docs/reflection.html
    implementation(libs.kotlin.reflect)
}

kotlin {
    jvmToolchain((project.extra["java_version"] as String).toInt())
}

dokka {
    moduleName.set("Events")
    dokkaSourceSets.main {
        sourceLink {
            localDirectory.set(file("src/main/kotlin"))
            remoteUrl("https://lyzev.dev/Events/dokka/")
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

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.extra["maven_group"] as String
            artifactId = project.extra["maven_artifact"] as String
            version = project.extra["maven_version"] as String
            from(components["java"])
        }
    }
}
