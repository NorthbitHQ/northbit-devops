// ~/.gradle/init.d/global.gradle.kts
// Global repository configuration for all Gradle builds.
// Adds Northbit GitHub Packages repository for both plugins and dependencies
// when GITHUB_ACTOR and GITHUB_TOKEN are present.

val githubActor: String? = System.getenv("GITHUB_ACTOR")
val githubToken: String? = System.getenv("GITHUB_TOKEN")

// Configure plugin repositories once settings are available
gradle.settingsEvaluated {
    pluginManagement {
        repositories {
            mavenLocal()
            gradlePluginPortal()
            mavenCentral()
            maven { url = uri("https://repo.spring.io/milestone") }

            if (githubActor != null && githubToken != null) {
                maven {
                    name = "GitHubPackages-Northbit-Plugins"
                    url = uri("https://maven.pkg.github.com/NorthbitHQ/northbit-springboot-starters")
                    credentials {
                        username = githubActor
                        password = githubToken
                    }
                }
            }
        }
    }
}

// Configure dependency repositories for all projects
gradle.allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }

        if (githubActor != null && githubToken != null) {
            maven {
                name = "GitHubPackages-Northbit"
                url = uri("https://maven.pkg.github.com/NorthbitHQ/northbit-springboot-starters")
                credentials {
                    username = githubActor
                    password = githubToken
                }
            }
        }
    }
}
