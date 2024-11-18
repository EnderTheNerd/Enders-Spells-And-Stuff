package net.ender.endersequipment.item;

import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.item.swordtiers.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
public class ModItems {



    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(endersequipment.MOD_ID);


    public static final DeferredItem<Item> BLOODSHARD = ITEMS.register("bloodshard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> THUNDEROUS_POWDER = ITEMS.register("thunderous_powder",

            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNSTABLE_SCRAP = ITEMS.register("unstable_scrap",

            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PETRIFIED_OAK = ITEMS.register("petrified_oak",

            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MITHRIL_ROD = ITEMS.register("mithril_rod",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPECTRAL_ESSENCE = ITEMS.register("spectral_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WROUGHTGOLD = ITEMS.register("wrought_gold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COUNTERSTEEL = ITEMS.register("countersteel",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLOODTHIRST = ITEMS.register("bloodthirst", bloodthirst::new);

    public static final DeferredItem<Item> OVERCHARGEDCORE = ITEMS.register("overchargedcore", overchargedsword::new);

    public static final DeferredItem<Item> CHORUSSWORD = ITEMS.register("chorussword", chorussword::new);

    public static final DeferredItem<Item> GROVEKEEPER = ITEMS.register("grovekeeper", grovekeeper::new);

    public static final DeferredItem<Item> MITHRIL_SWORD = ITEMS.register("mithril_sword", mithrilsword::new);

    public static final DeferredItem<Item> THE_DARK = ITEMS.register("the_dark", thedark::new);

    public static final DeferredItem<Item> THE_LIGHT = ITEMS.register("the_light", thelight::new);

    public static final DeferredItem<Item> MOLTEN = ITEMS.register("molten", molten::new);

    public static final DeferredItem<Item> SPECTRAL_BLADE = ITEMS.register("spectral_blade", spectral_blade::new);

    public static final DeferredItem<Item> HAILSTORM = ITEMS.register("hailstorm", hailstorm::new);

    public static final DeferredItem<Item> JUDGEMENT = ITEMS.register("judgement", judgement::new);


    public static final DeferredItem<ArmorItem> COUNTERSTEEL_HELMET = ITEMS.register("countersteel_helmet",
            () -> new CountersteelArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.HELMET.getDurability(68))));

    public static final DeferredItem<ArmorItem> COUNTERSTEEL_CHESTPLATE = ITEMS.register("countersteel_chestplate",
            () -> new CountersteelArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.HELMET.getDurability(68))));

    public static final DeferredItem<ArmorItem> COUNTERSTEEL_LEGGINGS = ITEMS.register("countersteel_leggings",
            () -> new CountersteelArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.HELMET.getDurability(68))));

    public static final DeferredItem<ArmorItem> COUNTERSTEEL_BOOTS = ITEMS.register("countersteel_boots",
            () -> new CountersteelArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.HELMET.getDurability(68))));

    public static final DeferredItem<Item> COUNTERSTEEL_GREATSWORD = ITEMS.register("countersteel_greatsword", countersteelgreatsword::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }





}






