# Module Piko

<div align="center">
    <img width="400" src="https://github.com/SchizoidDevelopment/piko/blob/master/.idea/icon.png?raw=true" alt="Icon of Piko">
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

Effortlessly manage events in your Kotlin-based application with Piko, a lightweight and flexible event management
library. Simplify the process of registering listeners and triggering events with ease.

<br>

> Piko is specifically designed for Kotlin and works best when used with Kotlin’s coding style. It’s strongly
> recommended to use it exclusively with Kotlin.

## Key Features

- **Lightweight Framework**: Provides a streamlined framework for managing events and listeners.
- **Intuitive API**: Offers an easy-to-use API for registering and triggering events.
- **Reduced Boilerplate**: Minimizes boilerplate code by centralizing event management.
- **Maintainable Logic**: Organizes listeners clearly to keep logic maintainable and easy to track.

## Installation

[![Maven Central](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/available/maven-central_vector.svg)](https://central.sonatype.com/artifact/dev.lyzev.api/piko)

<br>

<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/dev.lyzev.api/piko">

Make sure to replace `${version}` with the latest version of Piko!

### Gradle (Kotlin DSL)

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.lyzev.api:piko:${version}")
}
```

### Gradle (Version Catalog)

```toml
[versions]
piko = "${version}"

[libraries]
piko = { module = "dev.lyzev.api:piko", version.ref = "piko" }
```

### Gradle (Groovy DSL)

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'dev.lyzev.api:piko:${version}'
}
```

### Maven

```xml

<dependencies>
    <dependency>
        <groupId>dev.lyzev.api</groupId>
        <artifactId>piko</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
```

### Raw JAR

1. Visit the [Maven Central Repository](https://search.maven.org/artifact/dev.lyzev.api/piko) and download the JAR file
   for the version you need.
2. Add the downloaded JAR to your project.

## Usage

### Event Listener Example

Below is a simple example demonstrating how to implement an event listener in Piko:

```kotlin
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

### Event Example

Below is an example demonstrating how to create an event in Piko:

```kotlin
import dev.lyzev.api.event.CancellableEvent

class TestEvent(val a: Int) : CancellableEvent()
```

## Bugs and Suggestions

### GitHub Issues

For bugs or suggestions, please submit them via
the [GitHub Issue Tracker](https://github.com/SchizoidDevelopment/piko/issues). Be sure to use the provided templates
and include all relevant details to help us understand your issue and resolve it swiftly. Your cooperation is greatly
appreciated!

[![GitHub Issues](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/documentation/issues_vector.svg)](https://github.com/SchizoidDevelopment/piko/issues)

### Discord Community

Need assistance or have **minor** questions? Join our welcoming community on
the [Discord server](https://lyzev.dev/discord). Our members and staff are always ready to help!

[![Discord Server](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/social/discord-plural_vector.svg)](https://lyzev.dev/discord)

## Contribution

We welcome contributions from the community! Please read
our [Contribution Guidelines](https://github.com/SchizoidDevelopment/piko/blob/master/CONTRIBUTING.md) to get started.

[![Pull Requests](https://wsrv.nl/?url=https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/documentation/pull-requests_vector.svg)](https://github.com/SchizoidDevelopment/piko/pulls)

## Security Policy

Please review our [Security Policy](https://github.com/SchizoidDevelopment/piko/blob/master/SECURITY.md) to understand how we handle security vulnerabilities.

<br>

> Please do not publicly disclose the vulnerability until it has been fixed.

## License

Copyright (C) 2025 Lyzev

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program. If not, see https://www.gnu.org/licenses/agpl-3.0.en.html.

# Package dev.lyzev.api.event

The `dev.lyzev.api.event` package is a core component of the Piko event management library. It provides the necessary
interfaces and classes to create, register, and manage events and event listeners.

## Usage Example

### Creating an Event

To create a custom event, extend the `CancellableEvent` class (or `Event` if it doesn't need to be cancellable).

```kotlin
class TestEvent(val a: Int) : CancellableEvent()
```

### Implementing an Event Listener

Implement the `EventListener` interface and register event handlers using the `on` function.

```kotlin
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

### Triggering an Event

Create an instance of the event and call the `fire` method to trigger it.

```kotlin
val event = TestEvent(5)
event.fire()
```

This will execute all registered listeners for the `TestEvent` class, respecting their priority and cancellation status.
