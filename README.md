# Northbit DevOps Configuration

This repository contains shared DevOps and build configuration for Northbit projects.

## Structure

- `build-config/gradle/init.d/global.gradle.kts`: Global Gradle repository configuration for all projects.

## Usage

To apply the global Gradle configuration, reference or copy the `global.gradle.kts` file into your Gradle user home `init.d` directory, or include it in your project as needed.

---

- Ensure `GITHUB_ACTOR` and `GITHUB_TOKEN` environment variables are set for access to Northbit GitHub Packages.

## License

**Confidential (Proprietary)**

For more details, see: [https://northbit.ca/licenses/LICENSE.html](https://northbit.ca/licenses/LICENSE.html)
