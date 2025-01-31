import org.jetbrains.dokka.gradle.DokkaTask
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
        footerMessage.set("(c) Lyzev")
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
