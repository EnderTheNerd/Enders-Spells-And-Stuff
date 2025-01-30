package net.ender.endersequipment.setup;

import io.redspace.ironsspellbooks.entity.mobs.keeper.KeeperRenderer;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.spells.flurry.BigFlurryRenderer;
import net.ender.endersequipment.entity.spells.flurry.SmallFlurryRenderer;
import net.ender.endersequipment.entity.spells.holy_wave.HolyWaveRenderer;
import net.ender.endersequipment.entity.spells.madness_wave.MadnessWaveRenderer;
import net.ender.endersequipment.entity.spells.overhwhelming.OverwhelmingStrikeRenderer;
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
        event.registerEntityRenderer(EntityRegistry.HOLY_WAVE.get(), HolyWaveRenderer::new);
        event.registerEntityRenderer(EntityRegistry.MAD_WAVE.get(), MadnessWaveRenderer::new);
        event.registerEntityRenderer(EntityRegistry.SMALL_FLURRY_WAVE.get(), SmallFlurryRenderer::new);
        event.registerEntityRenderer(EntityRegistry.BIG_FLURRY_WAVE.get(), BigFlurryRenderer::new);
        event.registerEntityRenderer(EntityRegistry.OVERWHELMING_STRIKE.get(), OverwhelmingStrikeRenderer::new);

    }
}