package net.ender.endersequipment.spells.primeval;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.entity.spells.comet.Comet;
import io.redspace.ironsspellbooks.entity.spells.target_area.TargetedAreaEntity;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.spells.TargetAreaCastData;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.ender.endersequipment.AbstractPrimevalSpell;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.EESchoolRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class ExtinctionSpell extends AbstractPrimevalSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "extinction");



    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)),
                Component.translatable("ui.irons_spellbooks.radius", Utils.stringTruncation(getRadius(caster), 1))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(EESchoolRegistry.PRIMEVAL_RESOURCE)
            .setMaxLevel(1)
            .setCooldownSeconds(210)
            .build();

    public ExtinctionSpell() {
        this.manaCostPerLevel = 0;
        this.baseSpellPower = 8;
        this.spellPowerPerLevel = 5;
        this.castTime = 180;
        this.baseManaCost = 80;

    }


    @Override
    public CastType getCastType() {
        return CastType.CONTINUOUS;
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
        return Optional.of(SoundRegistry.KEEPER_IDLE.get());
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.empty();
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (!(playerMagicData.getAdditionalCastData() instanceof TargetAreaCastData)) {
            Vec3 targetArea = Utils.moveToRelativeGroundLevel(world, Utils.raycastForEntity(world, entity, 60, true).getLocation(), 12);
            playerMagicData.setAdditionalCastData(new TargetAreaCastData(targetArea, TargetedAreaEntity.createTargetAreaEntity(world, targetArea, getRadius(entity), 0x60008c)));
        }
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    @Override
    public void onServerCastTick(Level level, int spellLevel, LivingEntity entity, @Nullable MagicData playerMagicData) {
        if (playerMagicData != null && (playerMagicData.getCastDurationRemaining() + 1) % 4 == 0)
            if (playerMagicData.getAdditionalCastData() instanceof TargetAreaCastData targetAreaCastData) {
                for (int i = 0; i < 2; i++) {
                    Vec3 center = targetAreaCastData.getCenter();
                    float radius = getRadius(entity);
                    Vec3 spawn = center.add(new Vec3(0, 0, entity.getRandom().nextFloat() * radius).yRot(entity.getRandom().nextInt(360)));
                    //TODO: not this
                    spawn = raiseWithCollision(spawn, 12, level);
                    shootComet(level, spellLevel, entity, spawn);
                    MagicManager.spawnParticles(level, ParticleHelper.COMET_FOG, spawn.x, spawn.y, spawn.z, 1, 1, 1, 1, 1, false);
                    MagicManager.spawnParticles(level, ParticleHelper.COMET_FOG, spawn.x, spawn.y, spawn.z, 1, 1, 1, 1, 1, true);
                    MagicManager.spawnParticles(level, ParticleHelper.FOG_THUNDER_DARK, spawn.x, spawn.y, spawn.z, 1, 1, 1, 1, 1, true);
                }
            }
    }

    private Vec3 raiseWithCollision(Vec3 start, int blocks, Level level) {
        for (int i = 0; i < blocks; i++) {
            Vec3 raised = start.add(0, 1, 0);
            if (level.getBlockState(BlockPos.containing(raised)).isAir())
                start = raised;
            else
                break;
        }
        return start;
    }

    private float getDamage(int spellLevel, LivingEntity caster) {
        return getSpellPower(spellLevel, caster) * 8f;
    }

    private float getRadius(LivingEntity caster) {
        return 16;
    }

    public void shootComet(Level world, int spellLevel, LivingEntity entity, Vec3 spawn) {
        Comet fireball = new Comet(world, entity);
        fireball.setPos(spawn.add(-5, 0, 0));
        fireball.shoot(new Vec3(.15f, -.85f, 0), .07f);
        fireball.setDamage(getDamage(spellLevel, entity));
        fireball.setExplosionRadius(10f);
        world.addFreshEntity(fireball);
        world.playSound(null, spawn.x, spawn.y, spawn.z, SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundSource.PLAYERS, 3.0f, 0.7f + Utils.random.nextFloat() * .3f);

    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.ANIMATION_CONTINUOUS_OVERHEAD;
    }


















}
