# Effective Templates

A collections of templates that Starts from the old basic mdk template. For java 8.

## This template include:

- Kotlin (Support from [Forgelin](https://github.com/LegacyModdingMC/Forgelin))
- Mixin & ASM (Provided by [UniMixins](https://github.com/LegacyModdingMC/UniMixins))
- Scala (Origin Forge self contained)
- MCLib (**Disabled by default**, see below)

## MCLib (optional)

[MCLib](https://github.com/makamys/MCLib) is a shadeable library bundling `UpdateCheck`, `AssetDirector` and `SloppyDepLoader`. It is **disabled by default** and can be turned on in `gradle.properties`:

```properties
enableUsingMCLib=true
mclibVersion=0.3.7.8
```

When enabled, [mclib.gradle](mclib.gradle) does everything MCLib's README describes:

- Adds the `shade` dependency from JitPack (`codechicken` excluded)
- Repackages `makamys/mclib` under your own package via `srgExtra "PK: ..."`, so multiple mods can each embed their own copy
- Bundles the library classes into the mod jar
- Calls `MCLib.init()` in the mod construction phase ([MCLibCompat.java](src/main/java/com/example/examplemod/mclib/MCLibCompat.java), triggered via [MCLibHook.java](src/main/java/com/example/examplemod/MCLibHook.java))

While disabled, the MCLib compat sources are excluded from compilation and no MCLib dependency is downloaded.

# License

[MIT](LICENSE)

# Credits

- [anatawa12/ForgeGradle-1.2](https://github.com/anatawa12/ForgeGradle-1.2)
- [LegacyModdingMC](https://github.com/orgs/LegacyModdingMC)
- [makamys/MCLib](https://github.com/makamys/MCLib)