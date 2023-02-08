// build-system dependencies
buildscript {
    repositories {
        mavenCentral()
        maven(url = "https://dl.bintray.com/kotlin/dokka")
    }
}

// setup modules
allprojects {
    repositories {
        mavenCentral()
    }
}
