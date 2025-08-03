# Fitbit Metrics

Status: WIP (Work in Progress)

Fitbit Metrics is an Android application focused on exploring, caching, and visualizing Fitbit data such as activity logs and user profile information. It integrates with the Fitbit Web API, leverages a local cache for offline access, and uses modern Android/Kotlin tooling with a layered architecture.

## Tech Stack

Languages and platform:
- Kotlin 2.2
- Java 21
- Android SDK target 36

Libraries and frameworks:
- Dependency Injection: Dagger Hilt
- Networking: Ktor Client (OkHttp engine)
- JSON: kotlinx.serialization
- Persistence: Room (Jetpack)
- Logging: Timber
- API client: OpenAPI-generated Ktor client for Fitbit endpoints
- Documentation: Dokka (multi-module), with Android Documentation Plugin (org.jetbrains.dokka:android-documentation-plugin:2.0.0)

Build tooling:
- Gradle with Kotlin DSL

## Project Status

- Early development. APIs, database schema, and UI/UX are subject to change.
- Expect breaking changes and incomplete features.

## Getting Started

Prerequisites:
- Android Studio (latest stable)
- Android SDK and tools for target 36
- JDK 21
- A Fitbit developer account with an OAuth 2.0 application (Client ID, Client Secret, Redirect URI)

1) Clone the repository

git clone <your-repo-url> cd fitbit-metrics


2) Configure Fitbit OAuth 2.0
- Create a Fitbit app in the Fitbit Developer Portal.
- Set an OAuth 2.0 Redirect URI that your app will use.
- Provide the credentials to the app via your preferred secure method. Examples:
    - Local environment variables:
        - FITBIT_CLIENT_ID
        - FITBIT_CLIENT_SECRET
        - FITBIT_REDIRECT_URI
    - Or a secure local properties file that is excluded from VCS (do not commit secrets).

3) Build and run
- Open the project in Android Studio.
- Sync Gradle.
- Run the app on an emulator or device.

## Features (Planned / In Progress)

- OAuth 2.0 login for Fitbit
- Fetch and display user profile data
- Fetch and display activity logs
- Local caching of data for offline resilience
- Basic analytics/visualizations (roadmap)
- Error handling and retry logic (roadmap)
- Theming and accessibility passes (roadmap)

## Architecture Overview

- Presentation: Android UI consuming use cases from the domain layer.
- Domain: Use cases and interfaces (repositories) defining app behavior without framework dependencies.
- Data: Implementations of repositories using:
    - Ktor Client for remote calls
    - Room for local persistence
    - A cache strategy to combine local and remote sources

Dependency injection is provided via Dagger Hilt.

## API Client (OpenAPI)

- The app uses an OpenAPI-generated client for Fitbit endpoints, integrated with Ktor. This improves type safety and keeps API models in sync with the Fitbit specification.

## Documentation (Dokka)

- The project uses Dokka for Kotlin/Android documentation, including multi-module output and the Android documentation plugin.

Common tasks:

## Generate documentation for each module
./gradlew dokkaHtml
## Generate aggregated multi-module docs
./gradlew dokkaHtmlMultiModule


- Generated docs are placed under each module’s build/dokka directory (and at the root for the multi-module task).

## Development Notes

- Logging uses Timber; ensure logs are disabled or minimized for release builds.
- Serialization is configured to ignore unknown fields from the Fitbit API for forward compatibility.
- Network client uses Ktor with the OkHttp engine and JSON content negotiation.

## Roadmap

- Expand Fitbit endpoints coverage (sleep, heart rate, devices)
- Charts and insights for trends and comparisons
- Background sync and scheduled refresh
- Improved offline-first behaviors
- Test coverage (unit, instrumentation)
- CI/CD pipeline

## Contributing

Contributions are welcome while the project is WIP. Please:
- Open an issue to discuss proposed changes.
- Keep commits scoped and well-described.
- Avoid committing secrets or credentials.

## License

TBD (will be added before the first release).
