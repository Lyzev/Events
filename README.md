<div align="center">
    <img height="400" src=".idea/icon.png" alt="Icon of Piko">
    <br>
    <a href="https://github.com/SchizoidDevelopment/piko">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/available/github_vector.svg&w=100&h=100" alt="GitHub Repository">
    </a>
    <a href="https://central.sonatype.com/artifact/dev.lyzev.api/piko">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/available/maven-central_vector.svg&w=100&h=100" alt="Maven Central">
    </a>
    <a href="https://lyzev.dev/discord">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/social/discord-plural_vector.svg&w=100&h=100" alt="Discord">
    </a>
    <a href="https://schizoiddevelopment.github.io/piko/">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/documentation/ghpages_vector.svg&w=100&h=100" alt="Documentation">
    </a>
    <a href="https://github.com/SchizoidDevelopment/piko/pulls">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/documentation/pull-requests_vector.svg&w=100&h=100" alt="Pull Requests">
    </a>
    <a href="https://github.com/SchizoidDevelopment/piko/issues">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/documentation/issues_vector.svg&w=100&h=100" alt="Issues">
    </a>
</div>

# Piko: Event Management for Kotlin

Effortlessly manage events in your Kotlin-based application with Piko, a lightweight and flexible event management library. Simplify the process of registering listeners and triggering events with ease.

> **Tip:**  
> Piko is specifically designed for Kotlin and works best when used with Kotlin’s coding style. It’s strongly recommended to use it exclusively with Kotlin.

## Usage

[![Maven Central Version](https://img.shields.io/maven-central/v/dev.lyzev.api/piko)](https://central.sonatype.com/artifact/dev.lyzev.api/piko)

### Import

Make sure to replace `${version}` with the latest version of Piko!

<details>
    <summary>Gradle (KTS)</summary>

```kt
repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.lyzev.api", "piko", "${version}")
}
```

</details>

<details>
    <summary>Gradle (Groovy)</summary>

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'dev.lyzev.api:piko:${version}'
}
```

</details>

<details>
    <summary>Maven</summary>

```xml
<dependencies>
    <dependency>
        <groupId>dev.lyzev.api</groupId>
        <artifactId>piko</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
```

</details>

<details>
    <summary>Raw Jar</summary>

1. Visit the [Maven Central Repository](https://search.maven.org/artifact/dev.lyzev.api/piko) and download the JAR file for the version you need.
2. Add the downloaded JAR to your project.
3. You're good to go!

</details>

### Example Usage

<details>
    <summary>EventListener</summary>

```kt
import dev.lyzev.api.event.Event
import dev.lyzev.api.event.EventListener
import dev.lyzev.api.event.on

class TestEventListener : EventListener {

    var handle = true

    init {
        on<TestEvent>(Event.Priority.HIGH) { event ->
            if (event.a == 5)
                event.isCancelled = true
            println("TestEvent: ${event.a}")
        }
    }

    override val shouldHandleEvents
        get() = handle
}
```

</details>

<details>
    <summary>Event</summary>

```kt
import dev.lyzev.api.event.CancellableEvent

class TestEvent(val a: Int) : CancellableEvent()
```

</details>

## Documentation

For detailed documentation, check out the full [Piko Documentation](https://schizoiddevelopment.github.io/piko/).

## Bugs and Suggestions

### Discord Community

Need assistance or have minor questions? Join our welcoming community on the [Discord server](https://lyzev.dev/discord). Our members and staff are always ready to help!

### GitHub Issues

For bugs or suggestions, please submit them via the [GitHub Issue Tracker](https://github.com/SchizoidDevelopment/piko/issues). Be sure to use the provided templates and include all relevant details to help us understand your issue and resolve it swiftly. Your cooperation is greatly appreciated!

---
*Piko is developed and maintained by Schizoid Development. Thank you for using Piko!*
