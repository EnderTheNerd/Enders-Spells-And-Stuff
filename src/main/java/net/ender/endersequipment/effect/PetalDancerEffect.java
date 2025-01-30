package net.ender.endersequipment.effect;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.ender.endersequipment.endersequipment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class PetalDancerEffect extends MagicMobEffect {
    public PetalDancerEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public PetalDancerEffect() {
        super (MobEffectCategory.BENEFICIAL, 16697273);

        this.addAttributeModifier(AttributeRegistry.CAST_TIME_REDUCTION, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "petal_dancer"), .05,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE);

        this.addAttributeModifier(AttributeRegistry.CASTING_MOVESPEED, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "petal_dancer"), .05,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
    }

}
