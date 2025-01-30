package net.ender.endersequipment.entity.armor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.item.armor.AristocratArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class AristocratArmorModel   extends DefaultedItemGeoModel<AristocratArmorItem> {

    public AristocratArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, ""));
    }



    @Override
    public ResourceLocation getModelResource(AristocratArmorItem object) {
        return  ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "geo/aristocrat_set.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AristocratArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "textures/models/armor/aristocrat_set.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AristocratArmorItem WizardArmorItem) {
        return  ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }



}
