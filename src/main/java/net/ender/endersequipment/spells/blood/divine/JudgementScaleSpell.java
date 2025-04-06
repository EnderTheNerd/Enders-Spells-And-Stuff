package net.ender.endersequipment.spells.blood.divine;

import com.gametechbc.spelllib.particle.CylinderParticleManager;
import com.gametechbc.spelllib.particle.ParticleDirection;
import com.gametechbc.spelllib.particle.SphereParticleManager;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.capabilities.magic.TargetEntityCastData;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.ender.endersequipment.registries.SoundRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.joml.Vector3f;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class JudgementScaleSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "judgement_scale");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)));

    }


    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundRegistry.JUDGEMENT_SPELL_CAST.get());
    }





    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(SchoolRegistry.BLOOD_RESOURCE)
            .setMaxLevel(1)
            .setCooldownSeconds(500)
            .build();

    public JudgementScaleSpell() {
        this.manaCostPerLevel = 30;
        this.baseSpellPower = 15;
        this.spellPowerPerLevel = 0;
        this.castTime = 25;
        this.baseManaCost = 250;
    }

    @Override
    public boolean checkPreCastConditions(Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        return Utils.preCastTargetHelper(level, entity, playerMagicData, this, 32, .35f);
    }


    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {

        if (entity.hasEffect(ModEffectRegistry.ANUBIS_DIVINITY)) {
            if (entity instanceof ServerPlayer serverPlayer) {
                serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("ui.endersequipment.divine_status", this.getDisplayName(serverPlayer)).withStyle(ChatFormatting.GOLD)));
                if (playerMagicData.getAdditionalCastData() instanceof TargetEntityCastData targetData) {
                    var targetEntity = targetData.getTarget((ServerLevel) level);
                    {
                        final float MAX_HEALTH = targetEntity.getMaxHealth();
                        float baseHealth = targetEntity.getHealth();
                        double percent = (baseHealth / MAX_HEALTH) * 100;

                        if (percent >= 50)
                        {
                            float radius = getRadius(spellLevel, entity);
                            float damage = getDamage(spellLevel, entity);
                            Vector3f edge = new Vector3f(.7f, 1f, 1f);
                            float explosionRadius = 3f * (1 + .5f * targetEntity.getHealth() / targetEntity.getMaxHealth());

                            var entities = level.getEntities(targetEntity, targetEntity.getBoundingBox().inflate(explosionRadius));

                            CylinderParticleManager.spawnParticles(level, targetEntity, 100 * spellLevel, ParticleTypes.SOUL, ParticleDirection.UPWARD, (double)radius, (double)(2 * spellLevel), -1.0D);



                            SphereParticleManager.spawnParticles(level, targetEntity, 80, ParticleTypes.SOUL_FIRE_FLAME, ParticleDirection.INWARD, 8.0D);
                            super.onServerCastTick(level, spellLevel, entity, playerMagicData);

                            double distanceSqr = targetEntity.distanceToSqr(targetEntity.position());
                            if (distanceSqr < explosionRadius * explosionRadius && Utils.hasLineOfSight(level, targetEntity.getBoundingBox().getCenter(), targetEntity.getBoundingBox().getCenter(), false)) {
                                float p = (float) (distanceSqr / (explosionRadius * explosionRadius));
                                p = 1 - p * p * p;

                                DamageSources.applyDamage(targetEntity, damage * p, getDamageSource(targetEntity, entity));

                            }
                            level.getEntities(entity, entity.getBoundingBox().inflate(radius, 4, radius), (target) -> !DamageSources.isFriendlyFireBetween(target, entity) && Utils.hasLineOfSight(level, entity, target, true)).forEach(target -> {
                                {
                                    if (target instanceof LivingEntity livingEntity && livingEntity.distanceToSqr(entity) < radius * radius) {




                                    }


                                }
                            });
                        }
                        else
                        {
                            float radius = getRadius(spellLevel, entity);
                            float damage = getDamage(spellLevel, entity);
                            float explosionRadius = 2f * (1 + .2f * targetEntity.getHealth() / targetEntity.getMaxHealth());


                            var entities = level.getEntities(targetEntity, targetEntity.getBoundingBox().inflate(explosionRadius));

                            double distanceSqr = targetEntity.distanceToSqr(targetEntity.position());
                            if (distanceSqr < explosionRadius * explosionRadius && Utils.hasLineOfSight(level, targetEntity.getBoundingBox().getCenter(), targetEntity.getBoundingBox().getCenter(), true)) {
                                float p = (float) (distanceSqr / (explosionRadius * explosionRadius));
                                p = 1 - p * p * p;

                                DamageSources.applyDamage(targetEntity, damage * p * .4F, getDamageSource(targetEntity, entity));

                            }
                            level.getEntities(entity, entity.getBoundingBox().inflate(radius, 4, radius), (target) -> !DamageSources.isFriendlyFireBetween(target, entity) && Utils.hasLineOfSight(level, entity, target, true)).forEach(target -> {
                                {
                                    if (target instanceof LivingEntity livingEntity && livingEntity.distanceToSqr(entity) < radius * radius) {



                                    }


                                }
                            });
                        }

                    }


                }

            }

        }
        else {
            if (entity instanceof ServerPlayer serverPlayer) {
                serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("ui.endersequipment.no_divine_status", this.getDisplayName(serverPlayer)).withStyle(ChatFormatting.RED)));
            }
        }
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

    public float getRadius(int spellLevel, LivingEntity caster) {
        return 5 + spellLevel * .5f;
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return getSpellPower(spellLevel, entity);
    }


    @Override
    public boolean canBeCraftedBy(Player player) {
        return false;
    }

    @Override
    public boolean allowCrafting() {
        return false;
    }

    @Override
    public boolean allowLooting() {
        return false;
    }
}
