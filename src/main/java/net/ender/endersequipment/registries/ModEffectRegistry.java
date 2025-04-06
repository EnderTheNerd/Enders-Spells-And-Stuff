package net.ender.endersequipment.registries;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.ender.endersequipment.effect.*;
import net.ender.endersequipment.endersequipment;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Mob;
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
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 8388627)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "strained"), -1,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.BLOOD_SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "strained"), .02,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ));

    public static final DeferredHolder<MobEffect, MobEffect> DARK_POWER = MOB_EFFECT_DEFERRED_REGISTER.register("dark_power",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 8388627)
                    .addAttributeModifier(AttributeRegistry.HOLY_SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "dark_power"), -.1,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.MANA_REGEN, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "dark_power"), .15,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ));



    public static final DeferredHolder<MobEffect, MobEffect> HEARTWRENCHED = MOB_EFFECT_DEFERRED_REGISTER.register("heartwrenched",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 8388627)
                    .addAttributeModifier(AttributeRegistry.MANA_REGEN, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "heartwrenched"), -.02,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ));


    public static final DeferredHolder<MobEffect, MobEffect> GIGANTISM = MOB_EFFECT_DEFERRED_REGISTER.register("gigantism",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 260409)
                    .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), .1,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), 4,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "gigantism"), -.08,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));




    public static final DeferredHolder<MobEffect, MobEffect> MINIMIZE = MOB_EFFECT_DEFERRED_REGISTER.register("minimize",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 260409)
                    .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), -.1,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), -4,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "minimize"), .08,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));




    public static final DeferredHolder<MobEffect, MobEffect> BLESSEDEFFECT = MOB_EFFECT_DEFERRED_REGISTER.register("blessed",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 16764201)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.MANA_REGEN, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.MAX_MANA, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .01,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .05,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.CAST_TIME_REDUCTION, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .05,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.COOLDOWN_REDUCTION, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blessed"), .01,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));




    public static final DeferredHolder<MobEffect, MobEffect> EBONY_ARMOR = MOB_EFFECT_DEFERRED_REGISTER.register("ebony_armor",
            EbonyArmorEffect::new

    );

    public static final DeferredHolder<MobEffect, MobEffect> ANUBIS_DIVINITY = MOB_EFFECT_DEFERRED_REGISTER.register("anubis_divinity",
            AnubisDivinityEffect::new

    );

    public static final DeferredHolder<MobEffect, MobEffect> PETAL_DANCER = MOB_EFFECT_DEFERRED_REGISTER.register("petal_dancer",
            PetalDancerEffect::new

    );

    public static final DeferredHolder<MobEffect, MobEffect> LORD_OF_DECAY = MOB_EFFECT_DEFERRED_REGISTER.register("lord_of_decay",
            LordOfDecayEffect::new

    );

    public static final DeferredHolder<MobEffect, MobEffect> BLOODIEDWOUNDSEFFECT = MOB_EFFECT_DEFERRED_REGISTER.register("bloodied_wounds",
            () -> new BloodiedWoundsEffect(MobEffectCategory.HARMFUL, 423647));

    public static final DeferredHolder<MobEffect, MobEffect> LIGHTPROTECTME = MOB_EFFECT_DEFERRED_REGISTER.register("light_protect_me",
            () -> new LightProtectMeEffect(MobEffectCategory.BENEFICIAL, 423647));

    public static final DeferredHolder<MobEffect, MobEffect> OVERCHARGED = MOB_EFFECT_DEFERRED_REGISTER.register("overcharged",
            () -> new OverchargedEffect(MobEffectCategory.BENEFICIAL, 312312));

    public static final DeferredHolder<MobEffect, MobEffect> WITHERING_TOUCH = MOB_EFFECT_DEFERRED_REGISTER.register("withering_touch",
            () -> new WitheringTouchEffect(MobEffectCategory.BENEFICIAL, 423647));

    public static final DeferredHolder<MobEffect, MobEffect> STARBURNEDSOUL = MOB_EFFECT_DEFERRED_REGISTER.register("star_burned_soul",
            () -> new SoulBurnEffect(MobEffectCategory.NEUTRAL, 423647));


    public static final DeferredHolder<MobEffect, MobEffect> SOUL_STOP = MOB_EFFECT_DEFERRED_REGISTER.register("soul_stop",
            () -> new SoulStopEffect(MobEffectCategory.BENEFICIAL, 423647));

    public static final DeferredHolder<MobEffect, MobEffect> SUMMONED_RAVAGER = MOB_EFFECT_DEFERRED_REGISTER.register("summoned_ravager",
            () -> new SummonedRavagerEffect(MobEffectCategory.BENEFICIAL, 1238137));

    public static final DeferredHolder<MobEffect, MobEffect> DIVINE_WRATH = MOB_EFFECT_DEFERRED_REGISTER.register("divine_wrath",
            () -> new DivineWrathEffect(MobEffectCategory.BENEFICIAL, 1238137));


    public static final DeferredHolder<MobEffect, MobEffect> SUMMONED_PHANTOM = MOB_EFFECT_DEFERRED_REGISTER.register("summoned_phantom",
            () -> new SummonedPhantomEffect(MobEffectCategory.BENEFICIAL, 1238137));

    public static final DeferredHolder<MobEffect, MobEffect> BLIZARDARMOR = MOB_EFFECT_DEFERRED_REGISTER.register("blizard_armor",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 260409)
                    .addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blizzard_armor"), .15,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blizzard_armor"), .15,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );


    public static final DeferredHolder<MobEffect, MobEffect> HOLYBLESSING = MOB_EFFECT_DEFERRED_REGISTER.register("holy_blessing",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 260409)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "holy_blessing"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "holy_blessing"), .05,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final DeferredHolder<MobEffect, MobEffect> OVERGROWN = MOB_EFFECT_DEFERRED_REGISTER.register("overgrown",
            () -> new MagicMobEffect(MobEffectCategory.BENEFICIAL, 93279)

                    .addAttributeModifier(AttributeRegistry.MANA_REGEN, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "overgrown"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.MAX_MANA, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "overgrown"), .02,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "overgrown"), .12,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.COOLDOWN_REDUCTION, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "overgrown"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "overgrown"), -.30,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static final DeferredHolder<MobEffect, MobEffect> WARDENCURSE = MOB_EFFECT_DEFERRED_REGISTER.register("warden_curse",
            () -> new MagicMobEffect(MobEffectCategory.NEUTRAL, 93279)

                    .addAttributeModifier(AttributeRegistry.MANA_REGEN, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "warden_curse"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.MAX_MANA, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "warden_curse"), .02,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_POWER, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "warden_curse"), .15,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.COOLDOWN_REDUCTION, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "warden_curse"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "warden_curse"), .2,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "warden_curse"), .2,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "warden_curse"), .2,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "warden_curse"), .1,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static final DeferredHolder<MobEffect, MobEffect> SOUL_LOCK = MOB_EFFECT_DEFERRED_REGISTER.register("soul_lock",
            () -> new SoulLockEffect(MobEffectCategory.HARMFUL, 423647));
}

