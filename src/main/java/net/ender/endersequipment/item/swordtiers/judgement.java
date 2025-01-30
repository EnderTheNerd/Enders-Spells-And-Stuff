package net.ender.endersequipment.item.swordtiers;



import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.item.EEItemTier;
import net.ender.endersequipment.registries.SpellRegistry;
import net.minecraft.world.item.Rarity;

public class judgement extends MagicSwordItem {

    public judgement() {
        super(EEItemTier.JUDGEMENT, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.JUDGEMENT)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.SANCTUARY, 1))
        );
    }
}