package net.ender.endersequipment.spells.primeval;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.AutoSpellConfig;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.spells.ExtendedEvokerFang;
import net.ender.endersequipment.AbstractPrimevalSpell;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.EESchoolRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class SnarlingGroundSpell extends AbstractPrimevalSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "snarling_ground");


    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.ring_count", getRings(spellLevel, caster)),
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(EESchoolRegistry.PRIMEVAL_RESOURCE)
            .setMaxLevel(1)
            .setCooldownSeconds(220)
            .build();

    public SnarlingGroundSpell() {
        this.manaCostPerLevel = 0;
        this.baseSpellPower = 45;
        this.spellPowerPerLevel = 0;
        this.castTime = 20;
        this.baseManaCost = 250;
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
        return Optional.of(SoundEvents.EVOKER_CAST_SPELL);
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        int rings = getRings(spellLevel, entity);
        int count = 10;
        Vec3 center = entity.getEyePosition();

        for (int r = 0; r < rings; r++) {
            float fangs = count + r * r;
            for (int i = 0; i < fangs; i++) {
                Vec3 spawn = center.add(new Vec3(0, 0, 1.5 * (r + 1)).yRot(entity.getYRot() * Mth.DEG_TO_RAD + ((6.281f / fangs) * i)));
                spawn = Utils.moveToRelativeGroundLevel(world, spawn, 10);
                if (!world.getBlockState(BlockPos.containing(spawn).below()).isAir()) {
                    ExtendedEvokerFang fang = new ExtendedEvokerFang(world, spawn.x, spawn.y, spawn.z, get2DAngle(center, spawn), r, entity, getDamage(spellLevel, entity));
                    world.addFreshEntity(fang);
                }
            }
        }
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    private float get2DAngle(Vec3 a, Vec3 b) {
        return Utils.getAngle(new Vec2((float) a.x, (float) a.z), new Vec2((float) b.x, (float) b.z));
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return getSpellPower(spellLevel, entity);
    }

    private int getRings(int spellLevel, LivingEntity entity) {
        return 10 + (spellLevel + 1) / 3;
    }

    @Override
    public boolean shouldAIStopCasting(int spellLevel, Mob mob, LivingEntity target) {
        float d = 1.5f * (getRings(spellLevel, mob) + 1);
        return mob.distanceToSqr(target) > d * d * 1.2f;
    }












}
