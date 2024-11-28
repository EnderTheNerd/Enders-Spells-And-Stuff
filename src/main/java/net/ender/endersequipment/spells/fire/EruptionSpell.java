package net.ender.endersequipment.spells.fire;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.entity.spells.fireball.MagicFireball;
import io.redspace.ironsspellbooks.entity.spells.fireball.SmallMagicFireball;
import io.redspace.ironsspellbooks.entity.spells.target_area.TargetedAreaEntity;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.spells.TargetAreaCastData;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.ender.endersequipment.endersequipment;
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
public class EruptionSpell extends AbstractSpell {
    private final ResourceLocation spellId =  ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "eruption");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)),
                Component.translatable("ui.irons_spellbooks.radius", Utils.stringTruncation(getRadius(caster), 1))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.UNCOMMON)
            .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(120)

            .build();

    public EruptionSpell() {
        this.manaCostPerLevel = 4;
        this.baseSpellPower = 8;
        this.spellPowerPerLevel = 2;
        this.castTime = 100;
        this.baseManaCost = 5;


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
        return Optional.of(SoundRegistry.FIRE_CAST.get());
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.empty();
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (!(playerMagicData.getAdditionalCastData() instanceof TargetAreaCastData)) {
            Vec3 targetArea = Utils.moveToRelativeGroundLevel(world, Utils.raycastForEntity(world, entity, 2, true).getLocation(), 12);
            playerMagicData.setAdditionalCastData(new TargetAreaCastData(targetArea, TargetedAreaEntity.createTargetAreaEntity(world, targetArea, getRadius(entity), 0)));
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
                    Vec3 spawn = center.add(new Vec3(5, 0, entity.getRandom().nextFloat() * radius).yRot(entity.getRandom().nextInt(360)));

                    spawn = raiseWithCollision(spawn, 12, level);
                    shootComet(level, spellLevel, entity, spawn);
                    MagicManager.spawnParticles(level, ParticleHelper.FIRE_EMITTER, spawn.x, spawn.y, spawn.z, 1, 1, 1, 1, 1, false);
                    MagicManager.spawnParticles(level, ParticleHelper.FIERY_SPARKS, spawn.x, spawn.y, spawn.z, 1, 1, 1, 1, 1, true);
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
        return getSpellPower(spellLevel, caster) * .5f;
    }

    private float getRadius(LivingEntity caster) {
        return 6;
    }

    public void shootComet(Level world, int spellLevel, LivingEntity entity, Vec3 spawn) {
        MagicFireball fireball = new MagicFireball(world, entity);
        fireball.setPos(spawn.add(-1, 0, 0));
        fireball.shoot(new Vec3(.1f, -.85f, 0));
        fireball.setDamage(getDamage(spellLevel, entity));
        fireball.setExplosionRadius(1f);
        world.addFreshEntity(fireball);
        world.playSound(null, spawn.x, spawn.y, spawn.z, SoundEvents.FIREWORK_ROCKET_BLAST, SoundSource.PLAYERS, 3.0f, 0.7f + Utils.random.nextFloat() * 2f);

    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.ANIMATION_CONTINUOUS_OVERHEAD;
    }

}