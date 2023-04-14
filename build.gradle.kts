import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("jvm") version "1.8.0"
    `maven-publish`
    id("org.jetbrains.dokka") version "1.8.10"
}

group = "dev.lyzev.api"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // https://kotlinlang.org/docs/reflection.html
    compileOnly(kotlin("reflect"))
}

kotlin {
    jvmToolchain(17)
}

tasks.getByName<DokkaTask>("dokkaHtml") {
    outputDirectory.set(buildDir.resolve("dokkaHtmlOutput"))
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "17"
}

tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "17"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.lyzev.api"
            artifactId = "events"
            version = "1.0.1"
            from(components["java"])
        }
    }
}