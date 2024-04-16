pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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
    versionCatalogs {
        create("core") {
            from(files("version-catalog/core.toml"))
        }
        create("json") {
            from(files("version-catalog/json.toml"))
        }
        create("network") {
            from(files("version-catalog/network.toml"))
        }
        create("storage") {
            from(files("version-catalog/storage.toml"))
        }
        create("di") {
            from(files("version-catalog/di.toml"))
        }
    }

}

rootProject.name = "NTI"
include(":app")
 