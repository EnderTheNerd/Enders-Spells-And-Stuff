package net.ender.endersequipment.setup;

import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.EntityRegistry;
import net.minecraft.client.renderer.entity.RavagerRenderer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = endersequipment.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    @SubscribeEvent
    public static void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {

        event.registerEntityRenderer(EntityRegistry.SUMMONED_RAVAGER.get(), RavagerRenderer::new);


    }
}