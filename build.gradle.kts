plugins {
    id("com.android.application") version Versions.gradle_version apply false
    id("com.android.library") version Versions.gradle_version apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
}

buildscript {
    dependencies {
        classpath(BuildDefine.hilt_plugin)
        classpath(kotlin("gradle-plugin", version = Versions.kotlin_version))
        classpath(kotlin("serialization", version = Versions.kotlin_version))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}