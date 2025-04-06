package net.ender.endersequipment.item;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.UpgradeOrbItem;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.ender.endersequipment.endersequipment;
import net.ender.endersequipment.item.armor.AristocratArmorItem;
import net.ender.endersequipment.item.curios.*;
import net.ender.endersequipment.item.swordtiers.*;
import net.ender.endersequipment.registries.EEAttributeRegistry;
import net.ender.endersequipment.registries.EEUpgradeOrbRegistry;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;

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

    public static final DeferredHolder<Item, Item> COMBAT_MANUAL = ITEMS.register("combat_manual", () -> new SpellBook(10)
            .withSpellbookAttributes(new AttributeContainer(EEAttributeRegistry.BLADE_SPELL_POWER, .08, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, 4, AttributeModifier.Operation.ADD_VALUE), new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE)));

    public static final DeferredItem<Item> SPELLBLADE_RUNE = ITEMS.register("spellblade_rune",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> SPELLBLADE_UPGRADE_ORB = ITEMS.register("spellblade_upgrade_orb",
            () -> new UpgradeOrbItem(ItemPropertiesHelper.material().rarity(Rarity.UNCOMMON).component(ComponentRegistry.UPGRADE_ORB_TYPE, EEUpgradeOrbRegistry.SPELLBLADE_SPELL_POWER)));

    public static final DeferredItem<Item> SPECTRAL_ESSENCE = ITEMS.register("spectral_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WROUGHTGOLD = ITEMS.register("wrought_gold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COUNTERSTEEL = ITEMS.register("countersteel",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DISPELLIUM = ITEMS.register("dispellium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COUNTERED_ESSENCE = ITEMS.register("countered_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ARCANE_CORE = ITEMS.register("arcane_core",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROTTEN_BONE = ITEMS.register("rotten_bone",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PUTRID_FLESH = ITEMS.register("putrid_flesh",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DREADSTEEL = ITEMS.register("dreadsteel",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DREAD_HANDLE = ITEMS.register("dread_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TRANSMUTED_STICK = ITEMS.register("transmuted_stick",
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

    public static final DeferredItem<Item> FAITH = ITEMS.register("faith", faith::new);

    public static final DeferredItem<Item> COUNTERSTEEL_DAGGER = ITEMS.register("countersteel_dagger", countersteeldagger::new);

    public static final DeferredItem<Item> COUNTERSTEEL_SWORD = ITEMS.register("countersteel_sword", countersteelsword::new);

    public static final DeferredItem<Item> BROKEN_PROMISE = ITEMS.register("broken_promise", brokenpromise::new);

    public static final DeferredItem<Item> SCYTHE_OF_ROTTED_DREAMS = ITEMS.register("scythe_of_rotted_dreams", scytheofrdreams::new);

    public static final DeferredItem<Item> HEARTBEAT = ITEMS.register("heartbeat", heartbeat::new);

    public static final DeferredItem<Item> FIRE_CLAYMORE = ITEMS.register("fire_claymore", claymorefire::new);


    public static final DeferredItem<ArmorItem> COUNTERSTEEL_HELMET = ITEMS.register("countersteel_helmet",
            () -> new CountersteelArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.HELMET.getDurability(68))));

    public static final DeferredItem<ArmorItem> COUNTERSTEEL_CHESTPLATE = ITEMS.register("countersteel_chestplate",
            () -> new CountersteelArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(68))));

    public static final DeferredItem<ArmorItem> COUNTERSTEEL_LEGGINGS = ITEMS.register("countersteel_leggings",
            () -> new CountersteelArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.LEGGINGS.getDurability(68))));

    public static final DeferredItem<ArmorItem> COUNTERSTEEL_BOOTS = ITEMS.register("countersteel_boots",
            () -> new CountersteelArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.BOOTS.getDurability(68))));

    public static final DeferredItem<ArmorItem> DISPELLIUM_HELMET = ITEMS.register("dispellium_helmet",
            () -> new DispelliumArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.HELMET.getDurability(70))));

    public static final DeferredItem<ArmorItem> DISPELLIUM_CHESTPLATE = ITEMS.register("dispellium_chestplate",
            () -> new DispelliumArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(70))));

    public static final DeferredItem<ArmorItem> DISPELLIUM_LEGGINGS = ITEMS.register("dispellium_leggings",
            () -> new DispelliumArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.LEGGINGS.getDurability(70))));

    public static final DeferredItem<ArmorItem> DISPELLIUM_BOOTS = ITEMS.register("dispellium_boots",
            () -> new DispelliumArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.BOOTS.getDurability(70))));

    public static final DeferredItem<Item> COUNTERSTEEL_GREATSWORD = ITEMS.register("countersteel_greatsword", countersteelgreatsword::new);

    public static final DeferredItem<CurioBaseItem> WARDINGCHARM = ITEMS.register("wardingcharm", WardingCharm::new);

    public static final DeferredItem<CurioBaseItem> WITHERWARD = ITEMS.register("witherward_ring", WitherwardRing::new);

    public static final DeferredItem<CurioBaseItem> GROW = ITEMS.register("growth_charm", GrowingCharm::new);

    public static final DeferredItem<CurioBaseItem> SHRINK = ITEMS.register("shrinking_charm", ShrinkingCharm::new);

    public static final DeferredItem<CurioBaseItem> ANUBIS_TOKEN = ITEMS.register("anubis_token", AnubisToken::new);




    public static final DeferredItem<Item> RUNIC_SWORD = ITEMS.register("runic_sword", runicblade::new);


    public static final DeferredHolder<Item, Item> ARISTOCRAT_HELMET = ITEMS.register("aristocrat_helmet", () -> new AristocratArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> ARISTOCRAT_CHESTPLATE = ITEMS.register("aristocrat_chestplate", () -> new AristocratArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> ARISTOCRAT_LEGGINGS = ITEMS.register("aristocrat_leggings", () -> new AristocratArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> ARISTOCRAT_BOOTS = ITEMS.register("aristocrat_boots", () -> new AristocratArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment(1).durability(ArmorItem.Type.BOOTS.getDurability(37))));





    public static Collection<DeferredHolder<Item, ? extends Item>> getItems() {
        return ITEMS.getEntries();
    }


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }





}






