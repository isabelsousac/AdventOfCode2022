plugins {
    kotlin("jvm") version "1.8.0"
}

repositories {
    mavenCentral()
}

tasks {
    wrapper {
        gradleVersion = "7.6"
    }
    test {
        useJUnitPlatform()
    }
}

dependencies {
    testImplementation(kotlin("test"))
}

