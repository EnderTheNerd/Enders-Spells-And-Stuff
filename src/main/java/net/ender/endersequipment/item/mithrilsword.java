package net.ender.endersequipment.item;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.Rarity;

public class mithrilsword extends ExtendedSwordItem {

    public mithrilsword() {
        super(EEItemTier.MITHRIL_SWORD, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.MITHRIL_SWORD))

        );
    }
}
