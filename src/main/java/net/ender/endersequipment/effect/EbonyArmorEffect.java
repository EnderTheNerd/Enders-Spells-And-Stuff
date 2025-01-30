package net.ender.endersequipment.effect;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.ender.endersequipment.endersequipment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EbonyArmorEffect extends MobEffect {
 public EbonyArmorEffect() {
     super (MobEffectCategory.NEUTRAL, 312312321);
     this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
             .2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
     this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
             .2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
     this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
             .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
     this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
             4, AttributeModifier.Operation.ADD_VALUE);
     this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.parse("8c58bcd9-516f-4cfb-b372-a811d08b3da3"),
             .2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
     this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "ebony_armor"), .05,
             AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
     this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "ebony_armor"), .04,
                     AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
     this.addAttributeModifier(AttributeRegistry.SPELL_RESIST, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "ebony_armor"), .05,
                     AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
 }
}
