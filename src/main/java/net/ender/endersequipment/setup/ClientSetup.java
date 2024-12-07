package net.ender.endersequipment.setup;

import io.redspace.ironsspellbooks.entity.mobs.keeper.KeeperRenderer;
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
        event.registerEntityRenderer(EntityRegistry.SUMMONED_KNIGHT.get(), KeeperRenderer::new);

    }
}