package net.ender.endersequipment.registries;

import net.ender.endersequipment.endersequipment;

import net.ender.endersequipment.entity.summoned_ravager.SummonedRavager;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
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





}