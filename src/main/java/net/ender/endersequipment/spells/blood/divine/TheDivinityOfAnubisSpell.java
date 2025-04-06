package net.ender.endersequipment.spells.blood.divine;

import com.gametechbc.spelllib.particle.CylinderParticleManager;
import com.gametechbc.spelllib.particle.ParticleDirection;
import com.gametechbc.spelllib.particle.SphereParticleManager;
import com.google.errorprone.annotations.Var;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.registries.EEParticleRegistry;
import net.ender.endersequipment.registries.ModEffectRegistry;
import net.ender.endersequipment.registries.SoundRegistry;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.joml.Vector3f;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class TheDivinityOfAnubisSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "anubis");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.effect_length", Utils.timeFromTicks(getSpellPower(spellLevel, caster) * 30, 1)));

    }


    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(net.ender.endersequipment.registries.SoundRegistry.ANUBIS_SPELL_CAST.get());
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.ANUBIS_DIVINITY_SPELL_END.get());
    }
    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(SchoolRegistry.BLOOD_RESOURCE)
            .setMaxLevel(1)
            .setCooldownSeconds(1000)
            .build();

    public TheDivinityOfAnubisSpell() {
        this.manaCostPerLevel = 30;
        this.baseSpellPower = 18;
        this.spellPowerPerLevel = 4;
        this.castTime = 50;
        this.baseManaCost = 50;
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
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        Vector3f edge = new Vector3f(.7f, 1f, 1f);
       int radius = 3;
        entity.addEffect(new MobEffectInstance(ModEffectRegistry.ANUBIS_DIVINITY, (int) (getSpellPower(spellLevel, entity) * 30), spellLevel - 1, false, false, true));

        MagicManager.spawnParticles(level, EEParticleRegistry.ANUBIS_ANKH.get(), entity.getX(), entity.getY() + 1, entity.getZ(), 80, .25, .25, .25, 0.7f + radius * .1f, false);

        CylinderParticleManager.spawnParticles(level, entity, 100 * spellLevel, ParticleTypes.SCULK_SOUL, ParticleDirection.UPWARD, (double)radius, (double)(4 * spellLevel), -1.0D);

        MagicManager.spawnParticles(level, new BlastwaveParticleOptions(edge, radius * 1.02f), entity.getX(), entity.getY() + .15f, entity.getZ(), 1, 0, 0, 0, 0, true);



        
        super.onServerCastTick(level, spellLevel, entity, playerMagicData);
        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }



    @Override
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.CAST_KNEELING_PRAYER;
    }

    @Override
    public AnimationHolder getCastFinishAnimation() {
        return SpellAnimations.SELF_CAST_TWO_HANDS;
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
