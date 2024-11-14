package net.ender.endersequipment.item;



import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.Rarity;

public class judgement extends MagicSwordItem {

    public judgement() {
        super(EEItemTier.JUDGEMENT, ItemPropertiesHelper.equipment().rarity(Rarity.EPIC).attributes(ExtendedSwordItem.createAttributes(EEItemTier.JUDGEMENT)),
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.DIVINE_SMITE_SPELL, 6))
        );
    }
}