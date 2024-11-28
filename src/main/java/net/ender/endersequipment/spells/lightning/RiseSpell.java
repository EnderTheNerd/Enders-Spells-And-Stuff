package net.ender.endersequipment.spells.lightning;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.spells.target_area.TargetedAreaEntity;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.spells.TargetAreaCastData;
import net.ender.endersequipment.endersequipment;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class RiseSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "thunderous_leap");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(

                Component.translatable("ui.irons_spellbooks.radius", Utils.stringTruncation(radius, 1))
        );
    }

    public static final float radius = 8;

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.COMMON)
            .setSchoolResource(SchoolRegistry.LIGHTNING_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(35)
            .build();

    public RiseSpell() {
        this.manaCostPerLevel = 10;
        this.baseSpellPower = 6;
        this.spellPowerPerLevel = 1;
        this.castTime = 40;
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
        return Optional.of(SoundRegistry.ELDRITCH_BLAST.get());
    }

    @Override
    public void onServerPreCast(Level level, int spellLevel, LivingEntity entity, @Nullable MagicData playerMagicData) {
        super.onServerPreCast(level, spellLevel, entity, playerMagicData);
        if (playerMagicData == null)
            return;
        TargetedAreaEntity targetedAreaEntity = TargetedAreaEntity.createTargetAreaEntity(level, entity.position(), radius, 953553, entity);
        playerMagicData.setAdditionalCastData(new TargetAreaCastData(entity.position(), targetedAreaEntity));
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        level.getEntitiesOfClass(LivingEntity.class, new AABB(entity.position().subtract(radius, radius, radius), entity.position().add(radius, radius, radius))).forEach((target) -> {
            if (Utils.shouldHealEntity(entity, target) && entity.distanceTo(target) <= radius) {
                target.addEffect(new MobEffectInstance(MobEffectRegistry.ASCENSION, 2 * 2, (int) getSpellPower(spellLevel, entity) - 1, false, false, false));

            }
        });

    }
}





