package net.ender.endersequipment.registries;

import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.util.EETags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Supplier;

public class EESchoolRegistry extends SchoolRegistry {
    private static final DeferredRegister<SchoolType> ENDER_SCHOOLS = DeferredRegister.create(SCHOOL_REGISTRY_KEY, endersequipment.MOD_ID);


    public static void register(IEventBus eventBus) {

        ENDER_SCHOOLS.register(eventBus);
    }

    private static Holder<SchoolType> registerSchool(SchoolType type) {
        return ENDER_SCHOOLS.register(type.getId().getPath(), () -> type);
    }


    public static final ResourceLocation PRIMEVAL_RESOURCE = ResourceLocation.fromNamespaceAndPath(endersequipment.MOD_ID, "primeval");




    public static final Supplier<SchoolType> PRIMEVAL = (Supplier<SchoolType>) registerSchool(new SchoolType(
            PRIMEVAL_RESOURCE,
            EETags.PRIMEVAL_FOCUS,
            Component.translatable("school.endersequipment.primeval").withStyle(ChatFormatting.RED),
            EEAttributeRegistry.PRIMEVAL_MAGIC_SPELL_POWER,
            EEAttributeRegistry.PRIMEVAL_MAGIC_RESIST,
            SoundRegistry.KEEPER_IDLE,
            EEDamageTypes.PRIMEVAL_MAGIC
    ));

    @Nullable
    public static SchoolType getSchoolFromFocus(ItemStack focusStack) {

        for (SchoolType school : REGISTRY) {
            if (school.isFocus(focusStack)) {
                return school;
            }
        }
        return null;
    }
}





