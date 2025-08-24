package com.blorbee.drowneddepths.item;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.item.custom.FullSetArmorItem;
import com.blorbee.drowneddepths.item.custom.HammerItem;
import com.blorbee.drowneddepths.item.custom.TestCustomItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item TEST_ITEM = register("test_item", Item::new, new Item.Settings());
    public static final Item TEST_CUSTOM_ITEM = register("test_custom_item", TestCustomItem::new, new Item.Settings().maxDamage(32));
    public static final Item TEST_FOOD = register("test_food", Item::new,
            new Item.Settings().food(ModFoodComponents.TEST_FOOD_COMPONENT, ModFoodComponents.TEST_CONSUMABLE_COMPONENT));

    public static final Item TEST_SWORD = register("test_sword", Item::new,
            new Item.Settings().sword(ModToolMaterials.TEST, 3, -2.4f));
    public static final Item TEST_PICKAXE = register("test_pickaxe", Item::new,
            new Item.Settings().pickaxe(ModToolMaterials.TEST, 1, -2.8f));
    public static final Item TEST_SHOVEL = register("test_shovel",
            settings -> new ShovelItem(ModToolMaterials.TEST, 1.5f, -3.0f, settings), new Item.Settings());
    public static final Item TEST_AXE = register("test_axe",
            settings -> new AxeItem(ModToolMaterials.TEST, 6, -3.2f, settings), new Item.Settings());
    public static final Item TEST_HOE = register("test_hoe",
            settings -> new HoeItem(ModToolMaterials.TEST, 0, -3f, settings), new Item.Settings());

    public static final Item TEST_HAMMER = register("test_hammer",
            settings -> new HammerItem(ModToolMaterials.TEST, 7, -3.7f, settings), new Item.Settings());

    public static final Item TEST_HELMET = register("test_helmet",
            settings -> new FullSetArmorItem(ModArmorMaterials.TEST_ARMOR, EquipmentType.HELMET, settings), new Item.Settings());
    public static final Item TEST_CHESTPLATE = register("test_chestplate",
            settings -> new FullSetArmorItem(ModArmorMaterials.TEST_ARMOR, EquipmentType.CHESTPLATE, settings), new Item.Settings());
    public static final Item TEST_LEGGINGS = register("test_leggings",
            settings -> new FullSetArmorItem(ModArmorMaterials.TEST_ARMOR, EquipmentType.LEGGINGS, settings), new Item.Settings());
    public static final Item TEST_BOOTS = register("test_boots",
            settings -> new FullSetArmorItem(ModArmorMaterials.TEST_ARMOR, EquipmentType.BOOTS, settings), new Item.Settings());

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DrownedDepths.MOD_ID, name));
        return Items.register(key, factory, settings);
    }

    public static void registerModItems() {
        DrownedDepths.LOGGER.info("Registering items for " + DrownedDepths.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TEST_ITEM);
            entries.add(TEST_CUSTOM_ITEM);
            entries.add(TEST_FOOD);
        });
    }
}
