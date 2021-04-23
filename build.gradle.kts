plugins {
    java
    kotlin("jvm") version "1.4.21"
    id("org.jetbrains.dokka") version "1.4.30"
    id("io.codearte.nexus-staging") version "0.30.0"
}

repositories {
    mavenCentral()
    jcenter()
    maven(url="https://dl.bintray.com/kotlin/dokka")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

// Maven publisher
val PUBLISH_GROUP_ID by extra("com.asamm")
val PUBLISH_ARTIFACT_ID by extra("logger")
val PUBLISH_VERSION by extra("1.1")
apply {
    from("${rootProject.projectDir}/gradle/publish-mavencentral.gradle")
}