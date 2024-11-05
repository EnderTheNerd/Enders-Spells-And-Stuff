package net.ender.ironsweaponry.item;

import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class bloodthirst extends MagicSwordItem {


    private static final Tier TOOL_TIER = new Tier() {


        @Override
        public int getUses() {
            return 2000;
        }

        @Override
        public float getSpeed() {
            return 0f;
        }

        @Override
        public float getAttackDamageBonus() {
            return 0;
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 10;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack((ItemLike) ModItems.BLOODSHARD));
        }
    };




    public bloodthirst() {
        super(TOOL_TIER,
                ItemPropertiesHelper.equipment()
                        .fireResistant()
                        .rarity(Rarity.RARE).attributes(SwordItem.createAttributes(TOOL_TIER, 7f, -2.6f)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.BLOOD_SLASH_SPELL, 7))
        );
    }
}




