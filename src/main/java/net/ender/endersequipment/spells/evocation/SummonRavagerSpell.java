package net.ender.endersequipment.spells.evocation;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.events.SpellSummonEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.summoned_ravager.SummonedRavager;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class SummonRavagerSpell extends AbstractSpell {
    private final ResourceLocation spellId =  ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "summon_ravager");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.hp", getRavagerHealth(spellLevel, null)),
                Component.translatable("ui.irons_spellbooks.damage", getRavagerDamage(spellLevel, null))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.EVOCATION_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(280)
            .build();

    public SummonRavagerSpell() {
        this.manaCostPerLevel = 10;
        this.baseSpellPower = 4;
        this.spellPowerPerLevel = 1;
        this.castTime = 20;
        this.baseManaCost = 50;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
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
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundEvents.EVOKER_PREPARE_SUMMON);
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        int summonTime = 100;

        SummonedRavager ravager = new SummonedRavager(world, entity);
        ravager.setPos(entity.position());

        ravager.getAttributes().getInstance(Attributes.ATTACK_DAMAGE).setBaseValue(getRavagerDamage(spellLevel, entity));
        ravager.getAttributes().getInstance(Attributes.MAX_HEALTH).setBaseValue(getRavagerHealth(spellLevel, entity));
        ravager.setHealth(ravager.getMaxHealth());
        var event = NeoForge.EVENT_BUS.post(new SpellSummonEvent<SummonedRavager>(entity, ravager, this.spellId, spellLevel));
        world.addFreshEntity(event.getCreature());

        ravager.addEffect(new MobEffectInstance(ModEffectRegistry.SUMMONED_RAVAGER, summonTime, 0, false, false, false));
        int effectAmplifier = 0;
        if (entity.hasEffect(ModEffectRegistry.SUMMONED_RAVAGER))
            effectAmplifier += entity.getEffect(ModEffectRegistry.SUMMONED_RAVAGER).getAmplifier() + 1;
        entity.addEffect(new MobEffectInstance(ModEffectRegistry.SUMMONED_RAVAGER, summonTime, effectAmplifier, false, false, true));

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    private float getRavagerHealth(int spellLevel, LivingEntity caster) {
        return 50 + spellLevel * 4;
    }

    private float getRavagerDamage(int spellLevel, LivingEntity caster) {
        return getSpellPower(spellLevel, caster);
    }


}
