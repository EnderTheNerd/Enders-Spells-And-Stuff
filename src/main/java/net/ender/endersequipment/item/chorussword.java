package net.ender.endersequipment.item;



import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.Rarity;


public class chorussword extends MagicSwordItem {

    public chorussword() {
        super(EEItemTier.CHORUSSWORD, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.CHORUSSWORD)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.MAGIC_ARROW_SPELL, 11))
        );
    }
}