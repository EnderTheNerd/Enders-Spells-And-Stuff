package net.ender.endersequipment.item.swordtiers;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.minecraft.world.item.Rarity;

public class runicblade extends ExtendedSwordItem {

    public runicblade() {
        super(EEItemTier.RUNIC_BLADE, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.RUNIC_BLADE))

        );
    }
}

