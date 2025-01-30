package net.ender.endersequipment.item.swordtiers;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;

import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;

import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;

import net.ender.endersequipment.item.EEItemTier;
import net.ender.endersequipment.registries.SpellRegistry;
import net.minecraft.world.item.*;

public class bloodthirst extends MagicSwordItem {

    public bloodthirst() {
        super(EEItemTier.BLOODTHIRST_SWORD, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.BLOODTHIRST_SWORD)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.DARK_RITUAL, 1))
        );
    }
}




