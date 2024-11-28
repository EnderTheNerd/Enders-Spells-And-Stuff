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
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 780606)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "strained"), -2,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.BLOOD_SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "strained"), .2,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ));


    public static final DeferredHolder<MobEffect, MobEffect> GIGANTISM = MOB_EFFECT_DEFERRED_REGISTER.register("gigantism",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 260409)
                    .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), .1,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), 4,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.COOLDOWN_REDUCTION, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), -.05,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.MANA_REGEN, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), -.05,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), -.08,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), 3,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), -.03,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static final DeferredHolder<MobEffect, MobEffect> MINIMIZE = MOB_EFFECT_DEFERRED_REGISTER.register("minimize",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 260409)
                    .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), -.1,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), -.1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), -4,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.COOLDOWN_REDUCTION, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), .05,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.MANA_REGEN, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), .05,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), .08,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), -3,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), .03,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static final DeferredHolder<MobEffect, MobEffect> BLESSEDEFFECT = MOB_EFFECT_DEFERRED_REGISTER.register("blessed",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 93279)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .12,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.MANA_REGEN, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .3,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .3,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .3,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.MAX_MANA, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .05,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .15,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.CAST_TIME_REDUCTION, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .03,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.COOLDOWN_REDUCTION, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .02,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static final DeferredHolder<MobEffect, MobEffect> BLOODIEDWOUNDSEFFECT = MOB_EFFECT_DEFERRED_REGISTER.register("bloodied_wounds",
            () -> new BloodiedWoundsEffect(MobEffectCategory.HARMFUL, 423647));





    public static final DeferredHolder<MobEffect, MobEffect> BLIZARDARMOR = MOB_EFFECT_DEFERRED_REGISTER.register("blizard_armor",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 260409)
                    .addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blizzard_armor"), .1,
                    AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blizzard_armor"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );







}


