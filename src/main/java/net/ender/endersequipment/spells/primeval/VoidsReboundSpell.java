package net.ender.endersequipment.spells.primeval;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.effect.EchoingStrikesEffect;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.ender.endersequipment.AbstractPrimevalSpell;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.EESchoolRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.List;

@AutoSpellConfig
public class VoidsReboundSpell extends AbstractPrimevalSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "voids_rebound");


    @Override
        public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
            return List.of(
                    Component.translatable("ui.irons_spellbooks.percent_damage", Utils.stringTruncation(getPercentDamage(spellLevel, caster), 0)),
                    Component.translatable("ui.irons_spellbooks.radius", 6),
                    Component.translatable("ui.irons_spellbooks.effect_length", Utils.timeFromTicks(getSpellPower(spellLevel, caster) * 20, 1))
            );
        }

        private final DefaultConfig defaultConfig = new DefaultConfig()
                .setMinRarity(SpellRarity.LEGENDARY)
                .setSchoolResource(EESchoolRegistry.PRIMEVAL_RESOURCE)
                .setMaxLevel(1)
                .setCooldownSeconds(410)
                .build();

        public VoidsReboundSpell() {
            this.manaCostPerLevel = 0;
            this.baseSpellPower = 30;
            this.spellPowerPerLevel = 0;
            this.castTime = 0;
            this.baseManaCost = 510;
        }

        @Override
        public CastType getCastType() {
            return CastType.INSTANT;
        }

        @Override
        public DefaultConfig getDefaultConfig() {
            return defaultConfig;
        }

        @Override
        public ResourceLocation getSpellResource() {
            return spellId;
        }

        @Override
        public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
            entity.addEffect(new MobEffectInstance(MobEffectRegistry.ECHOING_STRIKES, (int) (getSpellPower(spellLevel, entity) * 40), getAmplifierForLevel(spellLevel, entity), false, false, true));
            super.onCast(level, spellLevel, entity, castSource, playerMagicData);
        }

        private float getPercentDamage(int spellLevel, LivingEntity entity) {
            return EchoingStrikesEffect.getDamageModifier(getAmplifierForLevel(spellLevel, entity), entity) * 300;
        }

        private int getAmplifierForLevel(int spellLevel, LivingEntity caster) {
            return 10 + (int) ((spellLevel + 1) * getEntityPowerMultiplier(caster));
        }

        @Override
        public AnimationHolder getCastStartAnimation() {
            return SpellAnimations.SELF_CAST_ANIMATION;
        }
    }








