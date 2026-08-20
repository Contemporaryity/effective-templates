package com.example.examplemod.mixin;

import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 示例 Mixin / Example mixin.
 *
 * 通过 UniMixins（org.spongepowered.asm）注入客户端主菜单。
 * Mixes into the client main menu via UniMixins.
 */
@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu {

    @Inject(method = "initGui", at = @At("RETURN"))
    private void examplemod$onInitGui(CallbackInfo ci) {
        System.out.println(">>> [ExampleMod] Main menu initialized (via UniMixins)");
    }
}
