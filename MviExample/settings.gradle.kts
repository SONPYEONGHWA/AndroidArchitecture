pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MviExample"
include(":app")
include(":feature:home")
include(":feature:friends")
include(":feature:mypage")
include(":core")
include(":common")
include(":feature:login")
