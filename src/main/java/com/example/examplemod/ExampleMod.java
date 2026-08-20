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
