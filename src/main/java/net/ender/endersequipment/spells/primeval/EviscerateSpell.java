package net.ender.endersequipment.spells.primeval;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.TargetEntityCastData;
import io.redspace.ironsspellbooks.entity.spells.blood_needle.BloodNeedle;
import net.ender.endersequipment.AbstractPrimevalSpell;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.EESchoolRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

@AutoSpellConfig
public class EviscerateSpell extends AbstractPrimevalSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "eviscerate");




    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(EESchoolRegistry.PRIMEVAL_RESOURCE)
            .setMaxLevel(1)
            .setCooldownSeconds(300)
            .build();

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)),
                Component.translatable("ui.irons_spellbooks.projectile_count", getCount(spellLevel, caster)));
    }

    public EviscerateSpell() {
        this.manaCostPerLevel = 0;
        this.baseSpellPower = 5;
        this.spellPowerPerLevel = 0;
        this.castTime = 0;
        this.baseManaCost = 280;
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
    public boolean checkPreCastConditions(Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        return Utils.preCastTargetHelper(level, entity, playerMagicData, this, 32, 1.2f);
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (playerMagicData.getAdditionalCastData() instanceof TargetEntityCastData targetData) {
            var targetEntity = targetData.getTarget((ServerLevel) world);
            if (targetEntity != null) {
                int count = getCount(spellLevel, entity);
                float damage = getDamage(spellLevel, entity);
                Vec3 center = targetEntity.position().add(0, targetEntity.getEyeHeight() / 2, 0);
                float degreesPerNeedle = 360f / count;
                for (int i = 0; i < count; i++) {
                    Vec3 offset = new Vec3(0, Math.random(), .55).normalize().scale(targetEntity.getBbWidth() + 2.75f).yRot(degreesPerNeedle * i * Mth.DEG_TO_RAD);
                    Vec3 spawn = center.add(offset);
                    Vec3 motion = center.subtract(spawn).normalize();

                    BloodNeedle needle = new BloodNeedle(world, entity);
                    needle.moveTo(spawn);
                    needle.shoot(motion.scale(.5f));
                    needle.setDamage(damage);
                    needle.setScale(2f);
                    world.addFreshEntity(needle);
                }
            }
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


    private int getCount(int spellLevel, LivingEntity caster) {
        return (int) ((10 + spellLevel) * getSpellPower(spellLevel, caster));
    }

    private float getDamage(int spellLevel, LivingEntity caster) {
        return 2 + getSpellPower(spellLevel, caster);
    }



}
