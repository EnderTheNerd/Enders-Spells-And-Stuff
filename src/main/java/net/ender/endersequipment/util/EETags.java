package net.ender.endersequipment.util;

import net.ender.endersequipment.endersequipment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class EETags {

        public static final TagKey<Item> BLADE_FOCUS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "blade_focus"));

}
