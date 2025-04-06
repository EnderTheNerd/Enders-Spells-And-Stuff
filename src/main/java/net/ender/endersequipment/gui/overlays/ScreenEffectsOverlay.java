package net.ender.endersequipment.gui.overlays;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class ScreenEffectsOverlay implements LayeredDraw.Layer {
    public static final ScreenEffectsOverlay instance = new ScreenEffectsOverlay();

    public final static ResourceLocation SOUL_LOCK_TEXTURE = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "textures/gui/overlays/soul_lock_overlay.png");

    public void render(GuiGraphics guiHelper, DeltaTracker deltaTracker) {
        if (Minecraft.getInstance().options.hideGui || Minecraft.getInstance().player.isSpectator()) {
            return;
        }
        var screenWidth = guiHelper.guiWidth();
        var screenHeight = guiHelper.guiHeight();


        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }
        if (player.hasEffect(ModEffectRegistry.SOUL_LOCK)) {
            renderOverlay(guiHelper, 0.25f, 0, 0, .25f, screenWidth, screenHeight);
        }


    }



    private static void renderOverlay(GuiGraphics gui, float r, float g, float b, float a, int screenWidth, int screenHeight) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(
                GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE
        );
        gui.setColor(r, g, b, a);
        gui.blit(ScreenEffectsOverlay.SOUL_LOCK_TEXTURE, 0, 0, -90, 0.0F, 0.0F, screenWidth, screenHeight, screenWidth, screenHeight);
        gui.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
    }
}


