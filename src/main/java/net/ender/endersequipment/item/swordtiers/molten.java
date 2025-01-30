package net.ender.endersequipment.item.swordtiers;



import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.ender.endersequipment.registries.SpellRegistry;
import net.minecraft.world.item.Rarity;


public class molten extends MagicSwordItem {

    public molten() {
        super(EEItemTier.MOLTEN, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.MOLTEN)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SEARING_SLAM, 1))
        );
    }
}