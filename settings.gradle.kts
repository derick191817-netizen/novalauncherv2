pluginManagement {
    repositories { google(); mavenCentral(); gradlePluginPortal() }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories { google(); mavenCentral() }
}
rootProject.name = "NovaLauncher"
include(
    ":app",
    ":core:ui", ":core:data", ":core:domain", ":core:common",
    ":feature:home", ":feature:drawer", ":feature:settings", ":feature:widgets", ":feature:gestures",
    ":benchmark",
)
