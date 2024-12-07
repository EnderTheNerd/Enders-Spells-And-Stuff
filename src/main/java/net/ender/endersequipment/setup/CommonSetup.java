package net.ender.endersequipment.setup;

import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.summoned_knight.SummonedKnight;
import net.ender.endersequipment.entity.summoned_ravager.SummonedRavager;
import net.ender.endersequipment.registries.EntityRegistry;
import net.ender.endersequipment.registries.SpellRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = endersequipment.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CommonSetup {

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.SUMMONED_RAVAGER.get(), SummonedRavager.createAttributes().build());
        event.put(EntityRegistry.SUMMONED_KNIGHT.get(), SummonedKnight.createAttributes().build());
    }
}