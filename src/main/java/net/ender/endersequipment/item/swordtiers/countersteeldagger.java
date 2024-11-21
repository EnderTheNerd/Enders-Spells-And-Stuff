package net.ender.endersequipment.item.swordtiers;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.minecraft.world.item.Rarity;

public class countersteeldagger extends ExtendedSwordItem {

    public countersteeldagger() {
        super(EEItemTier.COUNTERSTEEL_DAGGER, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.COUNTERSTEEL_DAGGER))

        );
    }




}
