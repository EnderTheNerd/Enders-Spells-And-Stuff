package net.ender.endersequipment.item.curios;

import com.gametechbc.spelllib.item.AdvancedRandomImbuingCurio;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.curios.SimpleDescriptiveCurio;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.compat.Curios;
import net.ender.endersequipment.registries.SpellRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.Map;

public class AnubisToken extends ImbuableCurio {
    public AnubisToken() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).fireResistant(), Curios.TOKEN_SLOT,
                SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.ANUBIS, 1)));

    }



}
