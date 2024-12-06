package net.ender.endersequipment.spells.primeval;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.CameraShakeData;
import io.redspace.ironsspellbooks.api.util.CameraShakeManager;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.capabilities.magic.TargetEntityCastData;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.mobs.IMagicSummon;
import io.redspace.ironsspellbooks.network.casting.SyncTargetingDataPacket;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.ender.endersequipment.AbstractPrimevalSpell;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.EESchoolRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class SanguineImplosionSpell extends AbstractPrimevalSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "sanguine_implosion");

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(EESchoolRegistry.PRIMEVAL_RESOURCE)
            .setMaxLevel(1)
            .setCooldownSeconds(80)
            .build();

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.base_damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)),
                Component.translatable("ui.irons_spellbooks.radius", 3)
        );
    }

    public SanguineImplosionSpell() {
        this.manaCostPerLevel = 0;
        this.baseSpellPower = 10;
        this.spellPowerPerLevel = 0;
        this.castTime = 0;
        this.baseManaCost = 200;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.empty();
    }

    @Override
    public boolean checkPreCastConditions(Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        float aimAssist = .30f;
        float range = 40f;
        Vec3 start = entity.getEyePosition();
        Vec3 end = entity.getLookAngle().normalize().scale(range).add(start);
        var target = Utils.raycastForEntity(entity.level(), entity, start, end, true, aimAssist, (e) -> e instanceof IMagicSummon summon && summon.getSummoner() == entity);
        if (target instanceof EntityHitResult entityHit && entityHit.getEntity() instanceof LivingEntity livingTarget) {
            playerMagicData.setAdditionalCastData(new TargetEntityCastData(livingTarget));
            if (entity instanceof ServerPlayer serverPlayer) {
                PacketDistributor.sendToPlayer(serverPlayer, new SyncTargetingDataPacket(livingTarget, this));
                serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("ui.irons_spellbooks.spell_target_success", livingTarget.getDisplayName().getString(), this.getDisplayName(serverPlayer)).withStyle(ChatFormatting.RED)));
            }
            return true;
        } else if (entity instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("ui.irons_spellbooks.sacrifice_target_failure").withStyle(ChatFormatting.DARK_RED)));
        }
        return false;
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (playerMagicData.getAdditionalCastData() instanceof TargetEntityCastData targetData) {
            var targetEntity = targetData.getTarget((ServerLevel) level);
            if (targetEntity instanceof IMagicSummon summon && summon.getSummoner().getUUID().equals(entity.getUUID())) {
                float damage = getDamage(spellLevel, entity) + targetEntity.getHealth() * 2f;
                float explosionRadius = 5f * (1 + .5f * targetEntity.getHealth() / targetEntity.getMaxHealth());
                MagicManager.spawnParticles(level, ParticleHelper.BLOOD, targetEntity.getX(), targetEntity.getY() + .25f, targetEntity.getZ(), 100, .03, .4, .03, .4, true);
                MagicManager.spawnParticles(level, ParticleHelper.BLOOD, targetEntity.getX(), targetEntity.getY() + .25f, targetEntity.getZ(), 100, .03, .4, .03, .4, false);
                MagicManager.spawnParticles(level, new BlastwaveParticleOptions(SchoolRegistry.BLOOD.get().getTargetingColor(), explosionRadius), targetEntity.getX(), targetEntity.getBoundingBox().getCenter().y, targetEntity.getZ(), 1, 0, 0, 0, 0, true);
                MagicManager.spawnParticles(level, new BlastwaveParticleOptions(SchoolRegistry.BLOOD.get().getTargetingColor(), explosionRadius), targetEntity.getX(), targetEntity.getBoundingBox().getCenter().y, targetEntity.getZ(), 1, 2, 2, 2, 2, true);
                var entities = level.getEntities(targetEntity, targetEntity.getBoundingBox().inflate(explosionRadius));
                for (Entity victim : entities) {
                    double distanceSqr = victim.distanceToSqr(targetEntity.position());
                    if (distanceSqr < explosionRadius * explosionRadius && Utils.hasLineOfSight(level, targetEntity.getBoundingBox().getCenter(), victim.getBoundingBox().getCenter(), false)) {
                        float p = (float) (distanceSqr / (explosionRadius * explosionRadius));
                        p = 1 - p * p * p;

                        DamageSources.applyDamage(victim, damage * p, getDamageSource(targetEntity, entity));
                    }
                }
                CameraShakeManager.addCameraShake(new CameraShakeData(10, targetEntity.position(), 50));
                targetEntity.remove(Entity.RemovalReason.KILLED);
                level.playSound(null, targetEntity.blockPosition(), SoundRegistry.BLOOD_EXPLOSION.get(), SoundSource.PLAYERS, 3, Utils.random.nextIntBetweenInclusive(8, 12) * .1f);
            }
        }

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private float getDamage(int spellLevel, LivingEntity caster) {
        return 80 + getSpellPower(spellLevel, caster);
    }


















}
