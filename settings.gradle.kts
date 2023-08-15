pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PassMan"
include(":app")
include(":uikit")
include(":passwords:api")
include(":passwords:impl")
include(":common:api")
include(":common:impl")
include(":codes:api")
include(":codes:impl")
include(":auth:impl")
include(":auth:api")
