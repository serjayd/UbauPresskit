# Fix missing Android Gradle Plugin error

The user is encountering an error where AGP version `8.9.3` cannot be found. This version is likely incorrect or not available in the configured repositories. According to Android documentation, targeting API 36.1 requires AGP version `8.13.0` or higher.

## Proposed Changes

### [Component Name] Gradle Configuration

#### [MODIFY] [libs.versions.toml](file:///C:/Users/serhi/AndroidStudioProjects/UbauPresskit/gradle/libs.versions.toml)
Update the `agp` version to `8.13.0`, which is the minimum required version for API 36.1 as per the official documentation.

#### [MODIFY] [settings.gradle.kts](file:///C:/Users/serhi/AndroidStudioProjects/UbauPresskit/settings.gradle.kts)
Simplify the `google()` repository definition in `pluginManagement` by removing the `content` filters, ensuring that all necessary artifacts can be resolved without regex restrictions.

## Verification Plan

### Automated Tests
- Run `./gradlew help` to verify that the build script can resolve the plugin.
- Run `./gradlew :app:assembleDebug` (if possible) to ensure the build proceeds.

### Manual Verification
- Verify that the IDE syncs successfully after the changes.
