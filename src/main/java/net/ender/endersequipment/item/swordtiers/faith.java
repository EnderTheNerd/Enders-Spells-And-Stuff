package net.ender.endersequipment.item.swordtiers;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.ender.endersequipment.registries.SpellRegistry;
import net.minecraft.world.item.Rarity;

public class faith  extends MagicSwordItem {

    public faith() {
        super(EEItemTier.FAITH, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.FAITH)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SACRED, 7))
        );
    }
}

