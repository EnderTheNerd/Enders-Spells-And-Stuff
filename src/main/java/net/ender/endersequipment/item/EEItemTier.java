package net.ender.endersequipment.item;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.ExtendedWeaponTier;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class EEItemTier implements Tier, IronsWeaponTier {

    public static ExtendedWeaponTier BLOODTHIRST_SWORD = new ExtendedWeaponTier(2000, 6f, -1.8f, 20,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.BLOODSHARD),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier OVERCHARGEDSWORD = new ExtendedWeaponTier(2000, 9f, -2.5f, 30,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.THUNDEROUS_POWDER),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static ExtendedWeaponTier CHORUSSWORD = new ExtendedWeaponTier(2300, 8f, -2f, 30,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.UNSTABLE_SCRAP),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static ExtendedWeaponTier GROVEKEEPER = new ExtendedWeaponTier(1800, 7f, -2.1f, 30,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.UNSTABLE_SCRAP),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static ExtendedWeaponTier MITHRIL_SWORD = new ExtendedWeaponTier(2400, 8f, -2.7f, 30,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.MANA_REGEN,.1,AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static ExtendedWeaponTier THE_DARK = new ExtendedWeaponTier(900, 3f, -2.7f, 30,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_INGOT),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, -0.35, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .35, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.MANA_REGEN,-.35,AttributeModifier.Operation.ADD_MULTIPLIED_BASE));



    public static ExtendedWeaponTier THE_LIGHT = new ExtendedWeaponTier(900, 3f, -2.7f, 30,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(Items.PRISMARINE_CRYSTALS),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.35, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, -.35, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.MANA_REGEN,.35,AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier MOLTEN = new ExtendedWeaponTier(2300, 11f, -3f, 30,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(Items.OBSIDIAN),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


    public static ExtendedWeaponTier SPECTRAL_BLADE = new ExtendedWeaponTier(2300, 8f, -2.3f, 30,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(ModItems.SPECTRAL_ESSENCE),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier HAILSTORN = new ExtendedWeaponTier(2300, 10f, -3.1f, 30,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(Items.BLUE_ICE),
            new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier JUDGEMENT = new ExtendedWeaponTier(2300, 11f, -3.3f, 30,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(Items.GOLD_BLOCK),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier COUNTERSTEEL_GREATSWORD = new ExtendedWeaponTier(2300, 9f, -2.9f, 30,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(ModItems.COUNTERSTEEL),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, -.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier COUNTERSTEEL_DAGGER = new ExtendedWeaponTier(2000, 4f, -1.7f, 30,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(ModItems.COUNTERSTEEL),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, -.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier COUNTERSTEEL_SWORD = new ExtendedWeaponTier(2200, 7f, -2.2f, 30,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(ModItems.COUNTERSTEEL),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, -.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier BROKEN_PROMISE = new ExtendedWeaponTier(1000, 12f, -3.1f, 20,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.BLOODSHARD),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier SCYTHE_OF_R_DREAMS = new ExtendedWeaponTier(2000, 10f, -2.3f, 20,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.ROTTEN_BONE),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static ExtendedWeaponTier HEARTBEAT = new ExtendedWeaponTier(2000, 12f, -3.1f, 20,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.TRANSMUTED_STICK),
            new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));



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

