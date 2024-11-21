package net.ender.endersequipment.effect;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.ender.endersequipment.endersequipment;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffectRegistry {
    public static final DeferredRegister<MobEffect> MOB_EFFECT_DEFERRED_REGISTER = DeferredRegister.create(Registries.MOB_EFFECT, endersequipment.MOD_ID);

    public static void register(IEventBus eventBus) {
        MOB_EFFECT_DEFERRED_REGISTER.register(eventBus);
    }


public static final DeferredHolder<MobEffect, MobEffect> STRAINED = MOB_EFFECT_DEFERRED_REGISTER.register("strained",
        () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 260409)
                .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "strained"), -.25,
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                .addAttributeModifier(AttributeRegistry.BLOOD_SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "strained"), .15,
                        AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        ));
}
