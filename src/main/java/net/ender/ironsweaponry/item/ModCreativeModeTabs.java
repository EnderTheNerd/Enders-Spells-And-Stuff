package net.ender.ironsweaponry.item;

import net.ender.ironsweaponry.ironsweaponry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

     public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
             DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ironsweaponry.MOD_ID);


     public static void register(IEventBus eventBus){
         CREATIVE_MODE_TAB.register(eventBus);
     }

     public static final Supplier<CreativeModeTab> BLOODSHARD_ITEMS_TAB = CREATIVE_MODE_TAB.register("bloodshard_items_tab",
             () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLOODSHARD.get()))
                     .title(Component.translatable("creativetab.ironsweaponry.bloodshard_items"))
                     .displayItems((itemDisplayParameters, output) -> {

                         output.accept(ModItems.BLOODSHARD);

                         output.accept(ModItems.THUNDEROUS_POWDER);

                         output.accept(ModItems.BLOODTHIRST);

                         output.accept(ModItems.OVERCHARGEDCORE);

                         output.accept(ModItems.UNSTABLE_SCRAP);
                     })

                     .build()    );

}
