// Global repository configuration for all Gradle projects
// This automatically adds the Northbit GitHub Packages repository to all builds
// Requires GITHUB_ACTOR and GITHUB_TOKEN environment variables to be set

// Configure plugin repositories globally
settingsEvaluated {
    pluginManagement {
        repositories {
            mavenLocal()
            gradlePluginPortal()
            mavenCentral()
            maven {
                url = uri("https://repo.spring.io/milestone")
            }

            val githubActor: String? = System.getenv("GITHUB_ACTOR")
            val githubToken: String? = System.getenv("GITHUB_TOKEN")

            if (githubActor != null && githubToken != null) {
                maven {
                    name = "GitHubPackages-Northbit-Plugins"
                    url = uri("https://maven.pkg.github.com/NorthbitHQ/northbit-springboot-starters")
                    credentials {
                        username = githubActor
                        password = githubToken
                    }
                    content {
                        includeGroup("com.northbit")
                    }
                }
            }
        }
    }
}

// Configure dependency repositories globally
allprojects {
    repositories {
        // Standard repositories needed for most dependencies
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/milestone")
        }

        // GitHub Packages repository for Northbit dependencies
        // Only uses environment variables for security
        val githubActor: String? = System.getenv("GITHUB_ACTOR")
        val githubToken: String? = System.getenv("GITHUB_TOKEN")

        if (githubActor != null && githubToken != null) {
            maven {
                name = "GitHubPackages-Northbit"
                url = uri("https://maven.pkg.github.com/NorthbitHQ/northbit-springboot-starters")
                credentials {
                    username = githubActor
                    password = githubToken
                }
                content {
                    includeGroup("com.northbit")
                }
            }
        }
    }
}

