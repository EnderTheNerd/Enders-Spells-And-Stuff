package net.ender.endersequipment.item.swordtiers;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.minecraft.world.item.Rarity;

public class scytheofrdreams  extends MagicSwordItem {

    public scytheofrdreams() {
        super(EEItemTier.SCYTHE_OF_R_DREAMS, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.SCYTHE_OF_R_DREAMS)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.RAISE_DEAD_SPELL, 8))
        );
    }
}

