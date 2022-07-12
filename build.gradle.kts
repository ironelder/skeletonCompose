plugins {
    id("com.android.application") version Versions.gradle_version apply false
    id("com.android.library") version Versions.gradle_version apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
}

buildscript {
    dependencies {
        classpath(BuildDefine.hilt_plugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}