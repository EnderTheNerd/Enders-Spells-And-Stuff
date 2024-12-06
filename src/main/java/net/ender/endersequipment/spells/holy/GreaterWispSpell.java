package net.ender.endersequipment.spells.holy;


import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;

import io.redspace.ironsspellbooks.api.util.Utils;

import io.redspace.ironsspellbooks.capabilities.magic.TargetEntityCastData;
import io.redspace.ironsspellbooks.entity.spells.wisp.WispEntity;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.ender.endersequipment.endersequipment;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;


@AutoSpellConfig
public class GreaterWispSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "greater_wisp");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {

        return List.of(Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getSpellPower(spellLevel, caster), 2)));

    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.RARE)
            .setSchoolResource(SchoolRegistry.HOLY_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(130)
            .build();

    public GreaterWispSpell() {
        this.manaCostPerLevel = 30;
        this.baseSpellPower = 10;
        this.spellPowerPerLevel = 6;
        this.castTime = 50;
        this.baseManaCost = 80;
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
        return Optional.of(SoundEvents.ILLUSIONER_PREPARE_MIRROR);
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.HOLY_CAST.get());
    }

    public static SoundEvent getImpactSound() {
        return SoundRegistry.DARK_MAGIC_BUFF_03_CUSTOM_1.get();
    }

    @Override
    public boolean checkPreCastConditions(Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        return Utils.preCastTargetHelper(level, entity, playerMagicData, this, 20, .35f);
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (playerMagicData.getAdditionalCastData() instanceof TargetEntityCastData targetingData) {
            var targetEntity = targetingData.getTarget((ServerLevel) world);
            WispEntity wispEntity = new WispEntity(world, entity, getSpellPower(spellLevel, entity));
            wispEntity.setTarget(targetEntity);
            wispEntity.setPos(Utils.getPositionFromEntityLookDirection(entity, 3).subtract(0, .2, 0));
            world.addFreshEntity(wispEntity);
        }
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    @Nullable
    private LivingEntity findTarget(LivingEntity caster) {
        var target = Utils.raycastForEntity(caster.level(), caster, 200, true, 25f);
        if (target instanceof EntityHitResult entityHit && entityHit.getEntity() instanceof LivingEntity livingTarget) {
            return livingTarget;
        } else {
            return null;
        }
    }

    private float getDistance(int spellLevel, LivingEntity sourceEntity) {
        return getSpellPower(spellLevel, sourceEntity) * 5;
    }

    private float getDuration(int spellLevel, LivingEntity sourceEntity) {
        return ((getSpellPower(spellLevel, sourceEntity)) * 10);
    }
}




