package net.ender.endersequipment.spells.blood;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.events.SpellSummonEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.mobs.SummonedVex;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.summoned_knight.SummonedKnight;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class RaiseKnightsSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "raise_knights");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.summon_count", spellLevel)
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.BLOOD_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(150)
            .build();

    public RaiseKnightsSpell() {
        this.manaCostPerLevel = 10;
        this.baseSpellPower = 1;
        this.spellPowerPerLevel = 0;
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
        return Optional.of(SoundRegistry.KEEPER_SWING.get());
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundEvents.EVOKER_CAST_SPELL);
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        int summonTime = 20 * 60 * 10;

        for (int i = 0; i < spellLevel; i++) {
            SummonedKnight knight = new SummonedKnight(world, entity);
            knight.moveTo(entity.getEyePosition().add(new Vec3(Utils.getRandomScaled(2), 1, Utils.getRandomScaled(2))));
            knight.finalizeSpawn((ServerLevel) world, world.getCurrentDifficultyAt(knight.getOnPos()), MobSpawnType.MOB_SUMMONED, null);
            knight.addEffect(new MobEffectInstance(ModEffectRegistry.SUMMONED_PHANTOM, summonTime, 0, false, false, false));
            var event = NeoForge.EVENT_BUS.post(new SpellSummonEvent<SummonedKnight>(entity, knight, this.spellId, spellLevel));
            world.addFreshEntity(event.getCreature());
        }
        int effectAmplifier = spellLevel - 1;
        if (entity.hasEffect(ModEffectRegistry.SUMMONED_PHANTOM))
            effectAmplifier += entity.getEffect(ModEffectRegistry.SUMMONED_PHANTOM).getAmplifier() + 1;
        entity.addEffect(new MobEffectInstance(ModEffectRegistry.SUMMONED_PHANTOM, summonTime, effectAmplifier, false, false, true));
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }














}
