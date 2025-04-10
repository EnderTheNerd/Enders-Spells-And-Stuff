package net.ender.endersequipment.effect;

import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.EffectCure;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class SoulBurnEffect extends MagicMobEffect {

    public SoulBurnEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);

    }
    public boolean applyEffectTick(LivingEntity p_296279_, int p_294798_) {
        p_296279_.hurt(p_296279_.damageSources().genericKill(), 999F);
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int p_295629_, int p_295734_) {
        int i = 40 >> p_295734_;
        return i == 0 || p_295629_ % i == 0;
    }


}

