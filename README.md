<h1 align="center">Events</h1>

<p align="center">Effortlessly manage events in your application with this lightweight and flexible event management library, designed to simplify the process of registering listeners and triggering events.</p>

<div align="center">
    <a href="https://lyzev.github.io/discord"><img src="https://img.shields.io/discord/610120595765723137?logo=discord" alt="Discord"/></a>
    <br><br>
    <img src="https://img.shields.io/github/last-commit/Lyzev/Events" alt="GitHub last commit"/>
    <img src="https://img.shields.io/github/commit-activity/w/Lyzev/Events" alt="GitHub commit activity"/>
    <br>
    <img src="https://img.shields.io/github/languages/code-size/Lyzev/Events" alt="GitHub code size in bytes"/>
    <img src="https://img.shields.io/github/contributors/Lyzev/Events" alt="GitHub contributors"/>
</div>

## Usage

[![](https://jitpack.io/v/Lyzev/Events.svg?label=Release)](https://jitpack.io/#Lyzev/Events)

### Import

Replace `${version}` with the current version!

<details>
        <summary>Gradle KTS</summary>

```kt
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Lyzev:Events:${version}")
}
```

</details>

<details>
        <summary>Gradle Groovy</summary>

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Lyzev:Events:${version}'
}
```

</details>

<details>
        <summary>Maven</summary>

```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Lyzev</groupId>
        <artifactId>Events</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
```

</details>

<details>
        <summary>Raw Jar</summary>

1. Go to the [release page](https://github.com/Lyzev/Events/releases).
2. Download Events-${version}.jar.
3. Add the jar to your classpath.

</details>

### Example

<details>
        <summary>EventListener</summary>

```kt
import dev.lyzev.api.events.EventListener
import dev.lyzev.api.events.on

class TestEventListener : EventListener {

    init {
        on<TestEvent> { event ->
            if (event.a == 5)
                event.isCancelled = true
            println("TestEvent: ${event.a}")
        }
    }

    override fun shouldHandleEvents(): Boolean = true
}
```

</details>

<details>
        <summary>Event</summary>

```kt
class TestEvent(val a: Int) : CancellableEvent()
```

</details>

## Documentation

You can find the documentation [here](https://lyzev.github.io/Events/dokka).

## Code Quality Monitoring

You can find the qodana report [here](https://lyzev.github.io/Events/qodana).

## Bugs and Suggestions

### Discord

For assistance with minor concerns, feel free to join our supportive community on
the [Discord server](https://lyzev.github.io/discord). Our friendly members and staff are ready to help you.

### GitHub

To ensure a prompt and effective resolution of bugs or to share your suggestions, please submit them through
the [issue tracker](https://github.com/Lyzev/Events/issues) of this repository. Kindly utilize the provided templates
and make sure to include all relevant details that would help us understand your issue better. Your cooperation is
greatly appreciated.
