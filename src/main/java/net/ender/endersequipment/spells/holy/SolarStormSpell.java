package net.ender.endersequipment.spells.holy;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.*;
import io.redspace.ironsspellbooks.entity.spells.sunbeam.SunbeamEntity;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.spells.flurry.BigFlurryProjectile;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class SolarStormSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "solar_crash");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", getDamage(spellLevel, caster))

        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.RARE)
            .setSchoolResource(SchoolRegistry.HOLY_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(25)
            .build();

    public SolarStormSpell()
    {
        this.manaCostPerLevel = 22;
        this.baseSpellPower = 10;
        this.spellPowerPerLevel = 5;
        this.castTime = 0;
        this.baseManaCost = 100;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
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
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.SELF_CAST_ANIMATION;
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.SUNBEAM_IMPACT.get());
    }

    @Override
    public int getRecastCount(int spellLevel, @Nullable LivingEntity entity) {
        return 5;
    }



    @Override
    public boolean checkPreCastConditions(Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        boolean b = Utils.preCastTargetHelper(level, entity, playerMagicData, this, 64, 0.15F);
        if (b) {
            ICastData var7 = playerMagicData.getAdditionalCastData();
            if (var7 instanceof TargetEntityCastData targetEntityCastData) {
                PlayerRecasts recasts = playerMagicData.getPlayerRecasts();
                if (recasts.hasRecastForSpell(this.getSpellId())) {
                    RecastInstance instance = recasts.getRecastInstance(this.getSpellId());
                    if (instance != null) {
                        ICastDataSerializable var10 = instance.getCastData();
                        if (var10 instanceof MultiTargetEntityCastData targetingData) {
                            if (targetingData.getTargets().contains(targetEntityCastData.getTargetUUID())) return false;
                        }
                    }
                }
            }
        }
        return b;
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        ICastData var7 = playerMagicData.getAdditionalCastData();
        if (var7 instanceof TargetEntityCastData targetEntityCastData) {
            PlayerRecasts recasts = playerMagicData.getPlayerRecasts();
            if (!recasts.hasRecastForSpell(this.getSpellId())) {
                recasts.addRecast(new RecastInstance(this.getSpellId(), spellLevel, this.getRecastCount(spellLevel, entity), 80, castSource, new MultiTargetEntityCastData(targetEntityCastData.getTarget((ServerLevel)level))), playerMagicData);
            } else {
                RecastInstance instance = recasts.getRecastInstance(this.getSpellId());
                if (instance != null) {
                    ICastDataSerializable var10 = instance.getCastData();
                    if (var10 instanceof MultiTargetEntityCastData targetingData) {
                        targetingData.addTarget(targetEntityCastData.getTargetUUID());
                    }
                }
            }
        }

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    @Override
    public void onRecastFinished(ServerPlayer serverPlayer, RecastInstance recastInstance, RecastResult recastResult, ICastDataSerializable castDataSerializable) {
        super.onRecastFinished(serverPlayer, recastInstance, recastResult, castDataSerializable);
        Level level = serverPlayer.level();

        Vec3 origin = serverPlayer.getEyePosition().add(serverPlayer.getForward().normalize().scale(0.20000000298023224));
        level.playSound(null, origin.x, origin.y, origin.z, SoundRegistry.GUST_CAST, SoundSource.PLAYERS, 2.0F, 1.0F);
        if (castDataSerializable instanceof MultiTargetEntityCastData targetingData) {
            targetingData.getTargets().forEach((uuid) -> {
                LivingEntity target = (LivingEntity)((ServerLevel)serverPlayer.level()).getEntity(uuid);
                if (target != null) {
                    target.addDeltaMovement(new Vec3(0, 0.9d, 0));
                    SunbeamEntity sunbeam = new SunbeamEntity(level);

                    shootSolarBeam(target, level);
                }
            });
        }

    }

    private void shootSolarBeam(LivingEntity entity,  Level level)
    {
        Vec3 spawn = null;
        if (spawn == null) {
            HitResult raycast = Utils.raycastForEntity(level, entity, 48, true);
            if (raycast.getType() == HitResult.Type.ENTITY) {
                spawn = ((EntityHitResult) raycast).getEntity().position();
            } else {
                spawn = Utils.moveToRelativeGroundLevel(level, raycast.getLocation().subtract(entity.getForward().normalize()).add(0, 2, 0), 3, 18);
            }
        }

        int spellLevel = spellPowerPerLevel;
        SunbeamEntity sunbeam = new SunbeamEntity(level);
        sunbeam.setOwner(entity);
        sunbeam.moveTo(spawn);
        sunbeam.setDamage(getDamage(spellLevel, entity));
        level.addFreshEntity(sunbeam);
        level.playSound(null, sunbeam.blockPosition(), SoundRegistry.SUNBEAM_WINDUP.get(), SoundSource.NEUTRAL, 3.5f, 1);


    }
    private float getDamage(int spellLevel, LivingEntity caster)
    {
        return (float) ((getSpellPower(spellLevel, caster) * 0.6));
    }
}
