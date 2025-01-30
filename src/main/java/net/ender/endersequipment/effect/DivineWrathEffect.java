package net.ender.endersequipment.effect;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import io.redspace.ironsspellbooks.entity.spells.sunbeam.SunbeamEntity;
import net.ender.endersequipment.registries.SpellRegistry;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nullable;

public class DivineWrathEffect extends MagicMobEffect {
    public DivineWrathEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return pDuration % 60 == 0;
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int pAmplifier) {
        var radiusSqr = 480; //20
        entity.level().getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(20, 12, 20),
                        livingEntity -> livingEntity != entity &&
                                horizontalDistanceSqr(livingEntity, entity) < radiusSqr &&
                                livingEntity.isPickable() &&
                                !livingEntity.isSpectator() &&
                                !Utils.shouldHealEntity(entity, livingEntity) &&
                                Utils.hasLineOfSight(entity.level(), entity, livingEntity, false)
                )
                .forEach(targetEntity -> {
                    SunbeamEntity sunbeam = new SunbeamEntity(entity.level());
                    sunbeam.setOwner(entity);

                    sunbeam.setPos(targetEntity.position());
                    entity.level().addFreshEntity(sunbeam);
                });
        return true;
    }

    private float horizontalDistanceSqr(LivingEntity livingEntity, LivingEntity entity2) {
        var dx = livingEntity.getX() - entity2.getX();
        var dz = livingEntity.getZ() - entity2.getZ();
        return (float) (dx * dx + dz * dz);
    }


    }



