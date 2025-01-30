package net.ender.endersequipment.item;


import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.ExtendedArmorItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CountersteelArmorItem extends ExtendedArmorItem {
    public CountersteelArmorItem(ArmorItem.Type slot, Properties settings) {
        super(ModArmorMaterials.COUNTERSTEEL_ARMOR_MATERIAL, slot, settings,
                new AttributeContainer(ALObjects.Attributes.DODGE_CHANCE, 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(ALObjects.Attributes.CRIT_CHANCE, 0.02, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                );
    }





    @Override
    public GeoArmorRenderer<?> supplyRenderer() {
        return null;
    }
}
