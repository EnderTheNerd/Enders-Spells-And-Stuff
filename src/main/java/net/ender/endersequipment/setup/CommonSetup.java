package net.ender.endersequipment.setup;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.magic.SpellSelectionManager;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.mobs.keeper.KeeperEntity;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.spells.madness_wave.MadnessWave;
import net.ender.endersequipment.entity.spells.pale_flame.PaleFlame;
import net.ender.endersequipment.entity.summoned_knight.SummonedKnight;
import net.ender.endersequipment.entity.summoned_ravager.SummonedRavager;
import net.ender.endersequipment.registries.EntityRegistry;
import net.ender.endersequipment.registries.SpellRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
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
        // You can technically do KeeperEntity.prepareAttributes().build() to get the attributes of the OG entity as an option
        event.put(EntityRegistry.SUMMONED_KNIGHT.get(), SummonedKnight.createAttributes().build());
    }
}


