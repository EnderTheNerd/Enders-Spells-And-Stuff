package net.ender.ironsweaponry.item;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.ExtendedWeaponTier;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class EEItemTier implements Tier, IronsWeaponTier {

    public static ExtendedWeaponTier BLOODTHIRST_SWORD = new ExtendedWeaponTier(2000, 4f, -2f, 20,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.BLOODSHARD),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static ExtendedWeaponTier OVERCHARGEDSWORD = new ExtendedWeaponTier(2000, 9f, -2.5f, 30,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.THUNDEROUS_POWDER),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    int uses;
    float damage;
    float speed;
    int enchantmentValue;
    TagKey<Block> incorrectBlocksForDrops;
    Supplier<Ingredient> repairIngredient;
    AttributeContainer[] attributes;

    public void ExtendedWeaponTier(int uses, float damage, float speed, int enchantmentValue, TagKey<Block> incorrectBlocksForDrops, Supplier<Ingredient> repairIngredient, AttributeContainer... attributes) {
        this.uses = uses;
        this.damage = damage;
        this.speed = speed;
        this.enchantmentValue = enchantmentValue;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.repairIngredient = repairIngredient;
        this.attributes = attributes;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return this.attributes;
    }

}

