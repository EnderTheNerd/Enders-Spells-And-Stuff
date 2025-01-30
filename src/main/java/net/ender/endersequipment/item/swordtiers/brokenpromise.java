package net.ender.endersequipment.item.swordtiers;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.ender.endersequipment.registries.SpellRegistry;
import net.minecraft.world.item.Rarity;

public class brokenpromise  extends MagicSwordItem {

    public brokenpromise() {
        super(EEItemTier.BROKEN_PROMISE, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.BROKEN_PROMISE)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.EBONY, 5))
        );
    }
}




