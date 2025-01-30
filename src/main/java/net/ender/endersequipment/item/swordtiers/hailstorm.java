package net.ender.endersequipment.item.swordtiers;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.ender.endersequipment.registries.SpellRegistry;
import net.minecraft.world.item.Rarity;

public class hailstorm extends MagicSwordItem {

    public hailstorm() {
        super(EEItemTier.HAILSTORN, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.HAILSTORN)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.BELOW_ZERO, 1))
        );
    }
}