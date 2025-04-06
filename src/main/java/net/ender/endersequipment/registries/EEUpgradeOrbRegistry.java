package net.ender.endersequipment.registries;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import io.redspace.ironsspellbooks.registries.UpgradeOrbTypeRegistry;
import net.ender.endersequipment.endersequipment;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFixedCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class EEUpgradeOrbRegistry {
    public static ResourceKey<UpgradeOrbType> SPELLBLADE_SPELL_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "spellblade_spell_power"));
}

