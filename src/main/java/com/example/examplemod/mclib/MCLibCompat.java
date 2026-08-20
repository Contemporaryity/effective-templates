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
 *
 * MCLib 胶水代码。仅当 {@code enableUsingMCLib=true} 时参与编译：
 * 否则 build.gradle 会把整个包从源码集中排除，
 * 因此该 import 不会在无库环境下导致编译失败。
 * <p>
 * 由 {@link com.example.examplemod.MCLibHook} 在模组构建（construction）
 * 阶段反射调用，这正是 MCLib 官方 README 要求调用 {@code MCLib.init()}
 * 的时机。之后即可通过各自的 {@code *API} 类配置 UpdateCheck 等
 * 共享模块（详见 MCLib wiki）。
 */
public final class MCLibCompat {

    private MCLibCompat() {
        // Static utility class, never instantiated. 静态工具类，禁止实例化。
    }

    /**
     * Boots the embedded MCLib instance. Must run in the mod construction
     * phase, before any shared module API is used.
     * 启动内嵌的 MCLib 实例。必须在模组构建阶段执行，且先于任何共享模块 API 的使用。
     */
    public static void init() {
        MCLib.init();
    }
}
