package net.ender.ironsweaponry.item;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.Rarity;


public class overchargedsword extends MagicSwordItem {

    public overchargedsword() {
        super(EEItemTier.OVERCHARGEDSWORD, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.OVERCHARGEDSWORD)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SHOCKWAVE_SPELL, 7))
        );
    }
}
