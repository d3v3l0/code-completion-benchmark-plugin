import org.jetbrains.intellij.tasks.RunIdeTask
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

group = "org.jetbrains.research.groups.ml_methods"
version = "0.1"

plugins {
    id("org.jetbrains.intellij") version "0.4.9" apply true
    kotlin("jvm") version "1.3.41" apply true
    java
}

repositories {
    mavenCentral()
    jcenter()
}

intellij {
    pluginName = "code-completion-benchmark-plugin"
    version = "2019.1.3"

    updateSinceUntilBuild = false
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}


tasks.withType<KotlinJvmCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<RunIdeTask> {
    jvmArgs("-Xmx1g")
}