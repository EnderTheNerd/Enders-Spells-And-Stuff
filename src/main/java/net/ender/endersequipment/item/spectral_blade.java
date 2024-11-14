package net.ender.endersequipment.item;





import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.Rarity;


public class spectral_blade extends MagicSwordItem {

    public spectral_blade() {
        super(EEItemTier.SPECTRAL_BLADE, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.SPECTRAL_BLADE)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.GUST_SPELL, 11))
        );
    }
}