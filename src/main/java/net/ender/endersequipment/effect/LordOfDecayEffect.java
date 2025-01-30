package net.ender.endersequipment.effect;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

import java.util.Objects;


public class LordOfDecayEffect extends MobEffect {

    public LordOfDecayEffect(MobEffectCategory category, int color, ParticleOptions particle) {
        super(category, color, particle);
    }

    public LordOfDecayEffect() {
        super(MobEffectCategory.BENEFICIAL, 8030132);
        this.addAttributeModifier(AttributeRegistry.SUMMON_DAMAGE, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
    }



}


