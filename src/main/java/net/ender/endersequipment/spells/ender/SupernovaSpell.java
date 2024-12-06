package net.ender.endersequipment.spells.ender;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.CameraShakeData;
import io.redspace.ironsspellbooks.api.util.CameraShakeManager;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.ender.endersequipment.endersequipment;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class SupernovaSpell extends AbstractSpell {

    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "supernova");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(SchoolRegistry.ENDER_RESOURCE)
            .setMaxLevel(1)
            .setCooldownSeconds(600)
            .build();

    public SupernovaSpell() {
        this.manaCostPerLevel = 100;
        this.baseSpellPower = 150;
        this.spellPowerPerLevel = 0;
        this.castTime = 200;
        this.baseManaCost = 500;
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
        return Optional.of(SoundRegistry.DEAD_KING_EXPLODE.get());
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.DEAD_KING_DEATH.get());
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        float radius = 16f;
        float range = 16f;
        Vector3f edge = new Vector3f(.7f, 1f, 1f);
        Vector3f center = new Vector3f(1, 1f, 1f);
        Vec3 smiteLocation = Utils.raycastForBlock(level, entity.getEyePosition(), entity.getEyePosition().add(entity.getForward().multiply(range, 0, range)), ClipContext.Fluid.NONE).getLocation();
        Vec3 particleLocation = level.clip(new ClipContext(smiteLocation, smiteLocation.add(0, -2, 0), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, CollisionContext.empty())).getLocation().add(0, 0.1, 0);
        MagicManager.spawnParticles(level, new BlastwaveParticleOptions(SchoolRegistry.ELDRITCH.get().getTargetingColor(), radius * 2),
                particleLocation.x, particleLocation.y, particleLocation.z, 1, 0, 0, 0, 0, true);
         Utils.raycastForBlock(level, entity.getEyePosition(), entity.getEyePosition().add(entity.getForward().multiply(range, 0, range)), ClipContext.Fluid.NONE).getLocation();
        MagicManager.spawnParticles(level, new BlastwaveParticleOptions(SchoolRegistry.ENDER.get().getTargetingColor(), radius * 6),
                particleLocation.x, particleLocation.y, particleLocation.z, 1, 0, 0, 0, 0, true);
         Utils.raycastForBlock(level, entity.getEyePosition(), entity.getEyePosition().add(entity.getForward().multiply(range, 0, range)), ClipContext.Fluid.NONE).getLocation();
        MagicManager.spawnParticles(level, new BlastwaveParticleOptions(SchoolRegistry.ENDER.get().getTargetingColor(), radius * 2),
                particleLocation.x, particleLocation.y, particleLocation.z, 1, 0, 0, 0, 0, true);
       Utils.raycastForBlock(level, entity.getEyePosition(), entity.getEyePosition().add(entity.getForward().multiply(range, 0, range)), ClipContext.Fluid.NONE).getLocation();
        MagicManager.spawnParticles(level, new BlastwaveParticleOptions(SchoolRegistry.ELDRITCH.get().getTargetingColor(), radius * 4),
                particleLocation.x, particleLocation.y, particleLocation.z, 1, 0, 0, 0, 0, true);
        MagicManager.spawnParticles(level, ParticleHelper.VOID_TENTACLE_FOG, entity.getX(), entity.getY() + 1, entity.getZ(), 80, .25, .25, .25, 0.7f + radius * 8f, false);
        MagicManager.spawnParticles(level, ParticleHelper.VOID_TENTACLE_FOG, entity.getX(), entity.getY() + 1, entity.getZ(), 80, .25, .25, .25, 0.7f + radius * 8f, false);
        MagicManager.spawnParticles(level, ParticleHelper.VOID_TENTACLE_FOG, entity.getX(), entity.getY() + 1, entity.getZ(), 80, .25, .25, .25, 0.7f + radius * 8f, false);
        MagicManager.spawnParticles(level, ParticleHelper.FOG_THUNDER_DARK, entity.getX(), entity.getY() + 1, entity.getZ(), 80, .25, .25, .25, 0.7f + radius * .1f, false);
        MagicManager.spawnParticles(level, ParticleTypes.DUST_PLUME, particleLocation.x, particleLocation.y, particleLocation.z, 50, 0, 0, 0, 1, false);
        MagicManager.spawnParticles(level, ParticleTypes.TOTEM_OF_UNDYING, particleLocation.x, particleLocation.y, particleLocation.z, 50, 0, 0, 0, 1, false);
        CameraShakeManager.addCameraShake(new CameraShakeData(50, particleLocation, 10));
        var entities = level.getEntities(entity, AABB.ofSize(smiteLocation, radius * 2, radius * 4, radius * 2));
        var damageSource = this.getDamageSource(entity);
        for (Entity targetEntity : entities) {
            if (targetEntity.isAlive() && targetEntity.isPickable() && Utils.hasLineOfSight(level, smiteLocation.add(0, 1, 0), targetEntity.getBoundingBox().getCenter(), true)) {
                if (DamageSources.applyDamage(targetEntity, getDamage(spellLevel, entity), damageSource));
                entity.addEffect(new MobEffectInstance(ModEffectRegistry.STARBURNEDSOUL, (int) (getSpellPower(spellLevel, entity) * 39), spellLevel + 20, false, false, true));
            }

            super.onCast(level, spellLevel, entity, castSource, playerMagicData);
        }

    }

    @Override
    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setFreezeTicks(60);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return getSpellPower(spellLevel, entity);




    }

    @Override
    public AnimationHolder getCastStartAnimation () {
        return SpellAnimations.CAST_KNEELING_PRAYER;
    }

    @Override
    public AnimationHolder getCastFinishAnimation () {
        return SpellAnimations.CAST_T_POSE;
    }
}