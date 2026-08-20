package com.example.examplemod;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    /**
     * Mod construction phase. Boots the optional MCLib integration via
     * {@link MCLibHook}: MCLib's README requires {@code MCLib.init()} to run
     * in exactly this phase. The hook is a silent no-op while MCLib stays
     * disabled (enableUsingMCLib=false).
     *
     * 模组构建阶段。通过 {@link MCLibHook} 启动可选的 MCLib 集成：
     * MCLib 的 README 要求在构建阶段调用 {@code MCLib.init()}。
     * MCLib 禁用（enableUsingMCLib=false）时该钩子为空操作。
     */
    @EventHandler
    public void construction(FMLConstructionEvent event)
    {
        MCLibHook.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
