package net.ender.endersequipment.effect;

import io.redspace.ironsspellbooks.player.ClientMagicData;
import net.ender.endersequipment.registries.SoundRegistry;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;


public class SoulLockEffect extends MobEffect {
    private int duration;

    public SoulLockEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull LivingEntity pLivingEntity, int pAmplifier) {

        if (pLivingEntity.level().isClientSide) {
            if (pLivingEntity instanceof Player player) {

                {
                    player.playSound(SoundRegistry.PALE_FLAME_CURSE.get(), 1, 0.85f);
                }
            }
        }
        return true;

    }
}
