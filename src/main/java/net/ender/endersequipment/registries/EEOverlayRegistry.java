package net.ender.endersequipment.registries;


import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.gui.overlays.ScreenEffectsOverlay;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

@EventBusSubscriber(modid = endersequipment.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)


public class EEOverlayRegistry {
    @SubscribeEvent
    public static void onRegisterOverlays(RegisterGuiLayersEvent event) {



        event.registerAboveAll(ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "screen_overlay"), ScreenEffectsOverlay.instance);
    }
    }

