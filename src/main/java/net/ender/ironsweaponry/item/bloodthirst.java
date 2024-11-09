package net.ender.ironsweaponry.item;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;

import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;

import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;

import net.minecraft.world.item.*;


import java.util.UUID;

public class bloodthirst extends MagicSwordItem {

    public bloodthirst() {
        super(EEItemTier.BLOODTHIRST_SWORD, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.BLOODTHIRST_SWORD)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.BLOOD_SLASH_SPELL, 7))
        );
    }
}




