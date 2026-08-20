package com.example.examplemod;

/**
 * Optional-feature hook used to trigger MCLib integration without a
 * compile-time dependency on the library.
 * <p>
 * The actual MCLib glue lives in {@code <modPackage>/mclib/MCLibCompat.java}
 * and is only compiled when {@code enableUsingMCLib=true} (see mclib.gradle).
 * This hook looks that class up reflectively at runtime: when MCLib is
 * disabled the class simply does not exist and {@link #init()} becomes a
 * silent no-op, so this file compiles and runs in both states.
 * <p>
 * Reflection targets our OWN class ({@code MCLibCompat}), whose package is
 * never touched by the MCLib repackage (srgExtra "PK: makamys/mclib ..."),
 * so the lookup works identically in the dev environment and in the
 * reobfuscated release jar.
 */
public final class MCLibHook {

    /** Fully qualified name of the MCLib glue class. */
    private static final String MCLIB_COMPAT_CLASS = "com.example.examplemod.mclib.MCLibCompat";

    private MCLibHook() {
        // Static utility class, never instantiated.
    }

    /**
     * Initializes the optional MCLib integration. Safe to call
     * unconditionally: it is a no-op when MCLib is disabled.
     */
    public static void init() {
        try {
            Class.forName(MCLIB_COMPAT_CLASS).getMethod("init").invoke(null);
        } catch (ClassNotFoundException e) {
            // MCLib disabled (enableUsingMCLib=false): the compat class is
            // excluded from the build, so there is nothing to initialize.
        } catch (Throwable t) {
            // MCLib is present but initialization failed - surface the error.
            System.err.println("[MCLibHook] MCLib initialization failed:");
            t.printStackTrace();
        }
    }
}
