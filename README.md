<div align="center">
    <img width="400" src=".idea/icon.png" alt="Icon of Piko">
    <br>
    <a href="https://github.com/SchizoidDevelopment/piko">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/available/github_vector.svg&w=64&h=64" alt="GitHub Repository">
    </a>
    <a href="https://central.sonatype.com/artifact/dev.lyzev.api/piko">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/available/maven-central_vector.svg&w=64&h=64" alt="Maven Central">
    </a>
    <a href="https://lyzev.dev/discord">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/social/discord-plural_vector.svg&w=64&h=64" alt="Discord">
    </a>
    <a href="https://schizoiddevelopment.github.io/piko/">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy-minimal/documentation/ghpages_vector.svg&w=64&h=64" alt="Documentation">
    </a>
    <a href="https://github.com/SchizoidDevelopment/piko/pulls">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/documentation/pull-requests_vector.svg&w=64&h=64" alt="Pull Requests">
    </a>
    <a href="https://github.com/SchizoidDevelopment/piko/issues">
        <img src="https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy-minimal/documentation/issues_vector.svg&w=64&h=64" alt="Issues">
    </a>
</div>

# Piko: Event Management for Kotlin

Effortlessly manage events in your Kotlin-based application with Piko, a lightweight and flexible event management library. Simplify the process of registering listeners and triggering events with ease.

> [!IMPORTANT] 
> Piko is specifically designed for Kotlin and works best when used with Kotlin’s coding style. It’s strongly recommended to use it exclusively with Kotlin.

## Key Features
- Provides a lightweight framework for managing events and listeners.  
- Offers an intuitive API that simplifies the process of registering and triggering events.  
- Designed to reduce boilerplate code by centralizing event management.  
- Supports clear organization of listeners to keep logic maintainable and easy to track.  

## Usage

[![Maven Central](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/available/maven-central_vector.svg)](https://central.sonatype.com/artifact/dev.lyzev.api/piko)

### Import

[![Maven Central Version](https://img.shields.io/maven-central/v/dev.lyzev.api/piko)](https://central.sonatype.com/artifact/dev.lyzev.api/piko)

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
    <summary>Gradle (Version Catalog)</summary>

```toml
[versions]
piko = "${version}"

[libraries]
piko = { module = "dev.lyzev.api:piko", version.ref = "piko" }
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

### Example

<details>
    <summary>EventListener</summary>

Below is a simple example demonstrating how to implement an event listener.

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
In this example:
1. We define a `TestEventListener` that implements `EventListener`.  
2. The `handle` variable determines whether the listener should process events.  
3. Changing `handle` allows enabling or disabling event handling.  
4. The `on<TestEvent>` function inside `init` registers the listener for `TestEvent`.  
5. `Event.Priority.HIGH` makes sure this listener runs before lower-priority ones.  
6. If `event.a == 5`, the event is canceled, preventing further processing.

</details>

<details>
    <summary>Event</summary>

Below is a simple example demonstrating how to create an event.

```kt
import dev.lyzev.api.event.CancellableEvent

class TestEvent(val a: Int) : CancellableEvent()
```

### In this example:  
1. We define a `TestEvent` class that extends `CancellableEvent`.  
2. The class has a single property, `a`, which stores an integer value.  
3. Since `TestEvent` extends `CancellableEvent`, it can be canceled by event listeners. 

</details>

> [!TIP]
> The library is quite intuitive, so it's a good idea to try it out. You'll quickly learn its capabilities.

## Documentation

> [!WARNING]
> This documentation is automatically generated by Dokka.

For documentation, check out the [Piko Documentation](https://schizoiddevelopment.github.io/piko/).

[![Documentation](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/documentation/ghpages_vector.svg)](https://schizoiddevelopment.github.io/piko/)

## Bugs and Suggestions

### GitHub Issues

For bugs or suggestions, please submit them via the [GitHub Issue Tracker](https://github.com/SchizoidDevelopment/piko/issues). Be sure to use the provided templates and include all relevant details to help us understand your issue and resolve it swiftly. Your cooperation is greatly appreciated!

[![GitHub Issues](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/documentation/issues_vector.svg)](https://github.com/SchizoidDevelopment/piko/issues)

### Discord Community

Need assistance or have **minor** questions? Join our welcoming community on the [Discord server](https://lyzev.dev/discord). Our members and staff are always ready to help!

[![Discord Server](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/social/discord-plural_vector.svg)](https://lyzev.dev/discord)

## Contribution Guidelines

We welcome contributions from the community! Please read our [Contribution Guidelines](CONTRIBUTING.md) to get started.

[![Pull Requests](https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/documentation/pull-requests_vector.svg)](https://github.com/SchizoidDevelopment/piko/pulls)

## Security Policy

Please review our [Security Policy](SECURITY.md) to understand how we handle security vulnerabilities.

> [!CAUTION]
> Please do not publicly disclose the vulnerability until it has been fixed.

## License

Copyright (C) 2025 Lyzev

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see https://www.gnu.org/licenses/agpl-3.0.en.html.

---
*Piko is developed and maintained by Schizoid Development. Thank you for using Piko!*
