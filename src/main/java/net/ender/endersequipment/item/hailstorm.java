package net.ender.endersequipment.item;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.Rarity;

public class hailstorm extends MagicSwordItem {

    public hailstorm() {
        super(EEItemTier.HAILSTORN, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.HAILSTORN)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.ICE_SPIKES_SPELL, 11))
        );
    }
}