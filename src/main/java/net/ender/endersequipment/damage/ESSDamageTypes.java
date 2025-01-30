package net.ender.endersequipment.damage;

import net.ender.endersequipment.endersequipment;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class ESSDamageTypes {
    public static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, name));
    }

    public static final ResourceKey<DamageType> SPELLBLADE_MAGIC = register("spellblade_magic");


    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(SPELLBLADE_MAGIC, new DamageType(SPELLBLADE_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0f));

    }

}
