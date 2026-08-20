package com.example.examplemod.mclib;

import makamys.mclib.core.MCLib;

/**
 * MCLib glue code. Only compiled when {@code enableUsingMCLib=true}:
 * build.gradle excludes this whole package from the source set otherwise,
 * so the MCLib import never breaks a build without the library.
 * <p>
 * Invoked reflectively by {@link com.example.examplemod.MCLibHook} during
 * the mod construction phase, which is exactly when MCLib's own README
 * requires {@code MCLib.init()} to be called. Shared modules such as
 * UpdateCheck can then be configured afterwards via their respective
 * {@code *API} classes (see the MCLib wiki).
 */
public final class MCLibCompat {

    private MCLibCompat() {
        // Static utility class, never instantiated.
    }

    /**
     * Boots the embedded MCLib instance. Must run in the mod construction
     * phase, before any shared module API is used.
     */
    public static void init() {
        MCLib.init();
    }
}
