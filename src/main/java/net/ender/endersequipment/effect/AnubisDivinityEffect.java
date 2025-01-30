package net.ender.endersequipment.effect;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.ender.endersequipment.registries.EEAttributeRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;



public class AnubisDivinityEffect extends MobEffect{

    protected AnubisDivinityEffect(MobEffectCategory category, int color, ParticleOptions particle) {
        super(category, color, particle);
    }

    public AnubisDivinityEffect() {
        super(MobEffectCategory.BENEFICIAL, 8030132);
        this.addAttributeModifier(AttributeRegistry.SUMMON_DAMAGE, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                .4, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(AttributeRegistry.BLOOD_SPELL_POWER, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                .5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(AttributeRegistry.HOLY_SPELL_POWER, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                -1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(AttributeRegistry.FIRE_SPELL_POWER, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                -1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(AttributeRegistry.ICE_SPELL_POWER, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                -1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(AttributeRegistry.ELDRITCH_SPELL_POWER, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                -1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(AttributeRegistry.NATURE_SPELL_POWER, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                -1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(AttributeRegistry.EVOCATION_SPELL_POWER, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                -1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(AttributeRegistry.ENDER_SPELL_POWER, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                -1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(EEAttributeRegistry.BLADE_SPELL_POWER, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
                -1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

    }

    }



