package net.ender.endersequipment.spells.blood;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.CameraShakeData;
import io.redspace.ironsspellbooks.api.util.CameraShakeManager;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.capabilities.magic.TargetEntityCastData;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;
@AutoSpellConfig
public class HeartwrenchSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "heartwrench");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.effect_length", Utils.timeFromTicks(getSpellPower(spellLevel, caster) * 10, 1)),
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)));

    }


    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.UNCOMMON)
            .setSchoolResource(SchoolRegistry.BLOOD_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(85)
            .build();

    public HeartwrenchSpell() {
        this.manaCostPerLevel = 20;
        this.baseSpellPower = 5;
        this.spellPowerPerLevel = 6;
        this.castTime = 15;
        this.baseManaCost = 55;
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
        return Optional.of(SoundRegistry.HEARTSTOP_CAST.get());
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.DARK_MAGIC_BUFF_03_CUSTOM_1.get());
    }


    @Override
    public boolean checkPreCastConditions(Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        return Utils.preCastTargetHelper(level, entity, playerMagicData, this, 32, .35f);
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (playerMagicData.getAdditionalCastData() instanceof TargetEntityCastData targetData) {
            var targetEntity = targetData.getTarget((ServerLevel) level);
            {
                float radius = getRadius(spellLevel, entity);
                float damage = getDamage(spellLevel, entity);
                float explosionRadius = 3f * (1 + .5f * targetEntity.getHealth() / targetEntity.getMaxHealth());
                MagicManager.spawnParticles(level, ParticleHelper.BLOOD, targetEntity.getX(), targetEntity.getY() + .25f, targetEntity.getZ(), 100, .03, .4, .03, .4, true);
                MagicManager.spawnParticles(level, ParticleHelper.BLOOD, targetEntity.getX(), targetEntity.getY() + .25f, targetEntity.getZ(), 100, .03, .4, .03, .4, false);
                MagicManager.spawnParticles(level, new BlastwaveParticleOptions(SchoolRegistry.BLOOD.get().getTargetingColor(), explosionRadius), targetEntity.getX(), targetEntity.getBoundingBox().getCenter().y, targetEntity.getZ(), 1, 0, 0, 0, 0, true);
                var entities = level.getEntities(targetEntity, targetEntity.getBoundingBox().inflate(explosionRadius));

                    double distanceSqr = targetEntity.distanceToSqr(targetEntity.position());
                    if (distanceSqr < explosionRadius * explosionRadius && Utils.hasLineOfSight(level, targetEntity.getBoundingBox().getCenter(), targetEntity.getBoundingBox().getCenter(), true)) {
                        float p = (float) (distanceSqr / (explosionRadius * explosionRadius));
                        p = 1 - p * p * p;

                        DamageSources.applyDamage(targetEntity, damage * p, getDamageSource(targetEntity, entity));
                        targetEntity.addEffect(new MobEffectInstance(ModEffectRegistry.HEARTWRENCHED, (int) (getSpellPower(spellLevel, entity) * 10), 1, false, false, true));
                    }
                level.getEntities(entity, entity.getBoundingBox().inflate(radius, 4, radius), (target) -> !DamageSources.isFriendlyFireBetween(target, entity) && Utils.hasLineOfSight(level, entity, target, true)).forEach(target -> {
                            {
                                if (target instanceof LivingEntity livingEntity && livingEntity.distanceToSqr(entity) < radius * radius) {
                                    int i = getDuration(baseSpellPower, entity)/2;
                                    livingEntity.addEffect(new MobEffectInstance(ModEffectRegistry.HEARTWRENCHED, i, 1));

                                    MagicManager.spawnParticles(level, ParticleHelper.BLOOD_GROUND, livingEntity.getX(), livingEntity.getY() + livingEntity.getBbHeight() * .5f, livingEntity.getZ(), 50, livingEntity.getBbWidth() * .5f, livingEntity.getBbHeight() * .5f, livingEntity.getBbWidth() * .5f, .03, false);
                                }


                            }
                });
                CameraShakeManager.addCameraShake(new CameraShakeData(10, targetEntity.position(), 20));
            }


        }




    }
    private float getDamage(int spellLevel, LivingEntity caster) {
        return (2 + getSpellPower(spellLevel, caster)/3);
    }

    public int getDuration(int spellLevel, LivingEntity caster) {
        return (int) (getSpellPower(spellLevel, caster) * 8);
    }

    public float getRadius(int spellLevel, LivingEntity caster) {
        return 5 + spellLevel * .5f;
    }

    public int getWrenchAmplifier(int spellLevel, LivingEntity caster) {
        return  0;
    }

}




