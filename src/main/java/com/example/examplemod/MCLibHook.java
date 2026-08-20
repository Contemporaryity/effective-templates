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
 *
 * 可选功能钩子：在不产生编译期依赖的前提下触发 MCLib 集成。
 * <p>
 * 真正的 MCLib 胶水代码位于 {@code <模组包>/mclib/MCLibCompat.java}，
 * 仅当 {@code enableUsingMCLib=true} 时参与编译（见 mclib.gradle）。
 * 本钩子在运行时反射查找该类：MCLib 被禁用时该类不存在，
 * {@link #init()} 静默跳过，因此本文件在两种状态下均可编译运行。
 * <p>
 * 反射目标是模组自身的类（{@code MCLibCompat}），其包路径不受 MCLib
 * 重打包（srgExtra "PK: makamys/mclib ..."）影响，因此在开发环境与
 * reobf 后的发布 jar 中查找行为完全一致。
 */
public final class MCLibHook {

    /** Fully qualified name of the MCLib glue class. MCLib 胶水类的全限定名。 */
    private static final String MCLIB_COMPAT_CLASS = "com.example.examplemod.mclib.MCLibCompat";

    private MCLibHook() {
        // Static utility class, never instantiated. 静态工具类，禁止实例化。
    }

    /**
     * Initializes the optional MCLib integration. Safe to call
     * unconditionally: it is a no-op when MCLib is disabled.
     * 初始化可选的 MCLib 集成。可无条件调用：MCLib 禁用时为空操作。
     */
    public static void init() {
        try {
            Class.forName(MCLIB_COMPAT_CLASS).getMethod("init").invoke(null);
        } catch (ClassNotFoundException e) {
            // MCLib disabled (enableUsingMCLib=false): the compat class is
            // excluded from the build, so there is nothing to initialize.
            // MCLib 已禁用（enableUsingMCLib=false）：兼容类未参与构建，无需初始化。
        } catch (Throwable t) {
            // MCLib is present but initialization failed - surface the error.
            // MCLib 已启用但初始化失败，打印错误便于排查。
            System.err.println("[MCLibHook] MCLib initialization failed:");
            t.printStackTrace();
        }
    }
}
