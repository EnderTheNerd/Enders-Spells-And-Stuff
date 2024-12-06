package net.ender.endersequipment.registries;

import net.ender.endersequipment.endersequipment;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class EEDamageTypes {
    public static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, name));
    }


    public static final ResourceKey<DamageType> PRIMEVAL_MAGIC = register("primeval_magic");

    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(PRIMEVAL_MAGIC, new DamageType(PRIMEVAL_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0f));
    }

    public static final ResourceKey<DamageType> SOUL_BURN =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "soul_burn"));





}