package net.ender.endersequipment.item.swordtiers;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.minecraft.world.item.Rarity;

public class grovekeeper extends MagicSwordItem {

    public grovekeeper() {
        super(EEItemTier.GROVEKEEPER, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.GROVEKEEPER)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.EARTHQUAKE_SPELL, 10))
        );
    }
}