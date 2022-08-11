buildscript {
    dependencies {
        classpath(Dependencies.Plugins.HILT_PLUGIN)
        classpath(Dependencies.Plugins.SAFE_ARGS_PLUGIN)
    }
}

plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}