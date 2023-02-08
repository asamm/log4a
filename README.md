# Logger

[![](https://jitpack.io/v/asamm/logger-asamm.svg)](https://jitpack.io/#asamm/logger-asamm)

Logger for Asamm libraries and tools.

## Quick start

Add support for JitPack to project `build.gradle.kts`

```gradle
allprojects {
    repositories {
        ...
        maven(url = "https://jitpack.io")
    }
}
```

Add dependency to your `build.gradle.kts` module config

```gradle
dependencies {
     // get Logger
     implementation("com.github.asamm:logger-asamm:[latest]")
}
```

## Usage

1. Initialization

As soon as possible, register your own application into logger system with own `ILogger` interface implementation over

```
Logger.registerLogger(myLoggerImpl)
```

2. Usage

Use extension functions `logV`, `logD`, `logI`, `logW` and `logE`.

3. Categories (optional)

Define and use own `LogCategory` objects. They may be supplied with the call as

```
logD(LogCategory.INITIALIZE) {
    "My log message with tag-prefix and visible only when certain requirements are met."
}
```

`LogCategory`, among defined `tagPrefix` visibel with all tags, allows to define minPriority` value that specify, since which log priority logs will be visible. Value may be modified in the runtime, so it is easy to enable/disable bunch of logs. Because category is tested before the log is created, log messages has zero impact on performance when the category is disabled!
