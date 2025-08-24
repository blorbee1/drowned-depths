package com.blorbee.drowneddepths.item;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.item.custom.TestCustomItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item TEST_ITEM = register("test_item", Item::new, new Item.Settings());
    public static final Item TEST_CUSTOM_ITEM = register("test_custom_item", TestCustomItem::new, new Item.Settings().maxDamage(32));

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DrownedDepths.MOD_ID, name));
        return Items.register(key, factory, settings);
    }

    public static void registerModItems() {
        DrownedDepths.LOGGER.info("Registering mod items for " + DrownedDepths.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TEST_ITEM);
            entries.add(TEST_CUSTOM_ITEM);
        });
    }
}
