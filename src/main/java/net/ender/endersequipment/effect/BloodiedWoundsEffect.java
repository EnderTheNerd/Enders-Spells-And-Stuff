package net.ender.endersequipment.effect;

import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BloodiedWoundsEffect extends MagicMobEffect {

    public BloodiedWoundsEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);

    }
    public boolean applyEffectTick(LivingEntity p_296279_, int p_294798_) {
        p_296279_.hurt(p_296279_.damageSources().generic(), 2.5F);
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int p_295629_, int p_295734_) {
        int i = 40 >> p_295734_;
        return i == 0 || p_295629_ % i == 0;
    }
}

