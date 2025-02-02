<h1 align="center">Piko</h1>

<p align="center">Effortlessly manage events in your application with this lightweight and flexible event management library, designed to simplify the process of registering listeners and triggering events.</p>

<div align="center">
    <a href="https://lyzev.github.io/discord"><img src="https://img.shields.io/discord/610120595765723137?logo=discord" alt="Discord"/></a>
    <br><br>
    <img src="https://img.shields.io/github/last-commit/SchizoidDevelopment/piko" alt="GitHub last commit"/>
    <img src="https://img.shields.io/github/commit-activity/w/SchizoidDevelopment/piko" alt="GitHub commit activity"/>
    <br>
    <img src="https://img.shields.io/github/languages/code-size/SchizoidDevelopment/piko" alt="GitHub code size in bytes"/>
    <img src="https://img.shields.io/github/contributors/SchizoidDevelopment/piko" alt="GitHub contributors"/>
</div>

## Usage

## Usage

[![Maven Central Version](https://img.shields.io/maven-central/v/dev.lyzev.api/piko)](https://central.sonatype.com/artifact/dev.lyzev.api/piko)

### Import

Replace `${version}` with the current version!

<details>
        <summary>Gradle KTS</summary>

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
        <summary>Gradle Groovy</summary>

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

1. Go to the [Maven Central Repository](https://search.maven.org/artifact/dev.lyzev.api/piko) and download the JAR file from the version you want.
2. Add the JAR file to your project.
3. Done!

</details>

### Example

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

You can find the documentation [here](https://schizoiddevelopment.github.io/piko/).

## Bugs and Suggestions

### Discord

For assistance with minor concerns, feel free to join our supportive community on
the [Discord server](https://lyzev.dev/discord). Our friendly members and staff are ready to help you.

### GitHub

To ensure a prompt and effective resolution of bugs or to share your suggestions, please submit them through
the [issue tracker](https://github.com/SchizoidDevelopment/piko/issues) of this repository. Kindly utilize the provided templates
and make sure to include all relevant details that would help us understand your issue better. Your cooperation is
greatly appreciated.
