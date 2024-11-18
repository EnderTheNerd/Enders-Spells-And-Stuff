package net.ender.endersequipment.item.swordtiers;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.minecraft.world.item.Rarity;


public class countersteelgreatsword extends ExtendedSwordItem {

        public countersteelgreatsword() {
            super(EEItemTier.COUNTERSTEEL_GREATSWORD, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.COUNTERSTEEL_GREATSWORD))

            );
        }
    }


