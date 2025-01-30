package net.ender.endersequipment.spells.blade;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.magic.SpellSelectionManager;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.capabilities.magic.RecastInstance;
import io.redspace.ironsspellbooks.capabilities.magic.RecastResult;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.entity.spells.flurry.BigFlurryProjectile;
import net.ender.endersequipment.entity.spells.flurry.SmallFlurryProjectile;
import net.ender.endersequipment.registries.EESchoolRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;

@AutoSpellConfig
public class FinalBreathSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "final_breath");



    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
    }








    @Override
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.SELF_CAST_TWO_HANDS;
    }

    @Override
    public AnimationHolder getCastFinishAnimation() {
        return AnimationHolder.pass();
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundRegistry.DEAD_KING_SLAM.get());
    }


    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(EESchoolRegistry.BLADE_RESOURCE)
            .setMaxLevel(1)
            .setCooldownSeconds(90)
            .build();


    public FinalBreathSpell() {
        this.manaCostPerLevel = 100;
        this.baseSpellPower = 8;
        this.spellPowerPerLevel = 2;
        this.castTime = 5;
        this.baseManaCost = 85;
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        final float MAX_HEALTH = entity.getMaxHealth();
        float baseHealth = entity.getHealth();
        double percent = (baseHealth / MAX_HEALTH) * 100;


        if (percent <= 40)
        {
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int) (getSpellPower(spellLevel, entity) * 40), 1, false, false, true));
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) (getSpellPower(spellLevel, entity) * 40), 4, false, false, true));
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int) (getSpellPower(spellLevel, entity) * 40), 2, false, false, true));
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) (getSpellPower(spellLevel, entity) * 40), 0, false, false, true));
        }
        else
        {
            if (entity instanceof ServerPlayer serverPlayer) {
                serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("ui.endersequipment.final_breath_failed", this.getDisplayName(serverPlayer)).withStyle(ChatFormatting.RED)));
            }
        }

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);

    }








    }


























