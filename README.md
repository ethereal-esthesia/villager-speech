# VillagerSpeech

Paper plugin that gives villagers a small set of short lines when players
right-click them.

## Build

```bash
./scripts/build-release.sh
```

The release jar is named:

```text
build/libs/VillagerSpeech-<pluginVersion>-paper-<paperApiVersion>.jar
```

## Release Pinning

Release metadata is pinned in `gradle.properties`.

The `Release for Paper Version` GitHub workflow accepts a Paper version and full
Paper API dependency version, updates the pin, bumps the plugin patch version
when the Paper pin changes, commits that change to `main`, and creates a GitHub
release with the built jar.
