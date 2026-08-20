package com.example.examplemod

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.FMLInitializationEvent
import net.minecraft.init.Blocks
import org.apache.logging.log4j.LogManager

/**
 * 模组主类（Kotlin）/ Main mod class written in Kotlin.
 *
 * Forgelin 提供 ILanguageAdapter，使 FML 能够加载 Kotlin `object` 类作为模组主类。
 * Forgelin provides the ILanguageAdapter that allows FML to load Kotlin
 * `object` classes as the main mod class.
 */
@Mod(modid = Tags.MODID, name = Tags.NAME, version = Tags.VERSION, useMetadata = true)
object ExampleMod {
    private val logger = LogManager.getLogger(Tags.NAME)

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.dirt.unlocalizedName)
    }
}
