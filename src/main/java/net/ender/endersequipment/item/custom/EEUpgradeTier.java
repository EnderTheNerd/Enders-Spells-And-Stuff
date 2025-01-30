package net.ender.endersequipment.item.custom;

import io.redspace.ironsspellbooks.item.armor.UpgradeType;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.item.ModItems;
import net.ender.endersequipment.registries.EEAttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;

import java.util.Optional;

public enum EEUpgradeTier implements UpgradeType {
    SPELLBLADE_SPELL_POWER("spellblade_power", ModItems.SPELLBLADE_UPGRADE_ORB, EEAttributeRegistry.BLADE_SPELL_POWER, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.05F);

    final Holder<Attribute> attribute;
    final AttributeModifier.Operation operation;
    final float amountPerUpgrade;
    final ResourceLocation id;
    final Optional<Holder<Item>> containerItem;

    EEUpgradeTier(String key, Holder<Item> containerItem, Holder<Attribute> attribute, AttributeModifier.Operation operation, float amountPerUpgrade)
    {
        this(key, Optional.of(containerItem), attribute, operation, amountPerUpgrade);
    }

    EEUpgradeTier(String key, Optional<Holder<Item>> containerItem, Holder<Attribute> attribute, AttributeModifier.Operation operation, float amountPerUpgrade)
    {
        this.id = ResourceLocation.parse(endersequipment.MOD_ID);
        this.attribute = attribute;
        this.operation = operation;
        this.amountPerUpgrade = amountPerUpgrade;
        this.containerItem = containerItem;
        UpgradeType.registerUpgrade(this);
    }



    @Override
    public Holder<Attribute> getAttribute() {
        return attribute;
    }

    @Override
    public AttributeModifier.Operation getOperation() {
        return operation;
    }

    @Override
    public float getAmountPerUpgrade() {
        return amountPerUpgrade;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public Optional<Holder<Item>> getContainerItem() {
        return containerItem;
    }




}
