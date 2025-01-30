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


    public static final ResourceKey<DamageType> EVO_MAGIC = register("evo_magic");
    public static final ResourceKey<DamageType> SKILL_DAMAGE = register("skill_damage");




    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(EVO_MAGIC, new DamageType(EVO_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0f));
        context.register(SKILL_DAMAGE, new DamageType(SKILL_DAMAGE.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0f));
    }










}