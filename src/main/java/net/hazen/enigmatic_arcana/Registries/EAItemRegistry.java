package net.hazen.enigmatic_arcana.Registries;

import net.hazen.enigmatic_arcana.EnigmaticArcana;
import net.hazen.enigmatic_arcana.Items.Equipment.Weapons.Nihility;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EAItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EnigmaticArcana.MOD_ID);


    /*
    *** Materials
     */

    public static final DeferredItem<Item> AGROCONIC_ALLOY = ITEMS.register("agroconic_alloy",
            () -> new Item(new Item.Properties()
            ));

    /*
    *** Weapons
     */


    //Nihility
    public static final DeferredHolder<Item, Item> NIHILITY = ITEMS.register
            ("nihility", Nihility::new);


/*
    public static final DeferredHolder<Item, Item> CREAKIN_MASK = ITEMS.register("creaking_mask",
            () -> new ApothicCrusaderArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(19)
            )));
    public static final DeferredHolder<Item, Item> CREAKIN_CHESTPLATE = ITEMS.register("creaking_chestplate",
            () -> new ApothicCrusaderArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(19)
            )));
    public static final DeferredHolder<Item, Item> CREAKIN_LEGGINGS = ITEMS.register("creaking_leggings",
            () -> new ApothicCrusaderArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(19)
            )));
    public static final DeferredHolder<Item, Item> CREAKIN_BOOTS = ITEMS.register("creaking_boots",
            () -> new ApothicCrusaderArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(19)
            )));
 */

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}