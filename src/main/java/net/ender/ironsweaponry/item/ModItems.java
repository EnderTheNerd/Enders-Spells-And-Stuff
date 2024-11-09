package net.ender.ironsweaponry.item;

import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.item.weapons.ExtendedWeaponTier;
import net.ender.ironsweaponry.ironsweaponry;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
public class ModItems {



    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ironsweaponry.MOD_ID);


    public static final DeferredItem<Item> BLOODSHARD = ITEMS.register("bloodshard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> THUNDEROUS_POWDER = ITEMS.register("thunderous_powder",

            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNSTABLE_SCRAP = ITEMS.register("unstable_scrap",

            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLOODTHIRST = ITEMS.register("bloodthirst", bloodthirst::new);

    public static final DeferredItem<Item> OVERCHARGEDCORE = ITEMS.register("overchargedcore", overchargedsword::new);
//Hi Gametech this is a new screenshot i promise

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }





}






