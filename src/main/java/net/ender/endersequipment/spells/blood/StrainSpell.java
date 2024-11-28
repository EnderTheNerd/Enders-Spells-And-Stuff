package net.ender.endersequipment.spells.blood;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.effect.ChargeEffect;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.ender.endersequipment.effect.ModEffectRegistry;
import net.ender.endersequipment.effect.StrainedEffect;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.EESchoolRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import java.util.List;
@AutoSpellConfig
public class StrainSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "strain");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.effect_length", Utils.timeFromTicks(getSpellPower(spellLevel, caster) * 20, 1)));

    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(EESchoolRegistry.PRIMEVAL_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(200)
            .build();

    public StrainSpell() {
        this.manaCostPerLevel = 30;
        this.baseSpellPower = 35;
        this.spellPowerPerLevel = 4;
        this.castTime = 0;
        this.baseManaCost = 50;
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

        entity.addEffect(new MobEffectInstance(ModEffectRegistry.STRAINED, (int) (getSpellPower(spellLevel, entity) * 16), spellLevel - 1, false, false, true));

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }



    @Override
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.SELF_CAST_ANIMATION;
    }
}








