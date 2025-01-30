package net.ender.endersequipment.registries;

import net.ender.endersequipment.endersequipment;

import net.ender.endersequipment.entity.spells.holy_wave.HolyWaveProjectile;

import net.ender.endersequipment.entity.spells.madness_wave.MadnessWave;
import net.ender.endersequipment.entity.summoned_knight.SummonedKnight;
import net.ender.endersequipment.entity.summoned_ravager.SummonedRavager;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, endersequipment.MOD_ID);

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }


    public static final DeferredHolder<EntityType<?>, EntityType<SummonedRavager>> SUMMONED_RAVAGER =
            ENTITIES.register("summoned_ravager", () -> EntityType.Builder.<SummonedRavager>of(SummonedRavager::new, MobCategory.CREATURE)

                    .sized(1.4F, 1.4F)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "summoned_ravager").toString()));




    public static final DeferredHolder<EntityType<?>, EntityType<SummonedKnight>> SUMMONED_KNIGHT =
            ENTITIES.register("summoned_knight", () -> EntityType.Builder.<SummonedKnight>of(SummonedKnight::new, MobCategory.CREATURE)

                    .sized(1.4F, 1.4F)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "summoned_knight").toString()));


    public static final DeferredHolder<EntityType<?>, EntityType<HolyWaveProjectile>> HOLY_WAVE =
            ENTITIES.register("holy_wave", () -> EntityType.Builder.<HolyWaveProjectile>of(HolyWaveProjectile::new, MobCategory.MISC)
                    .sized(5f, 1f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "holy_wave").toString())
            );

    public static final DeferredHolder<EntityType<?>, EntityType<MadnessWave>> MAD_WAVE =
            ENTITIES.register("mad_wave", () -> EntityType.Builder.<MadnessWave>of(MadnessWave::new, MobCategory.MISC)
                    .sized(5f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "mad_wave").toString()));


}