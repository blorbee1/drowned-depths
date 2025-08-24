package com.blorbee.drowneddepths.util;

import com.blorbee.drowneddepths.DrownedDepths;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TEST_TOOL = createTag("needs_test_tool");
        public static final TagKey<Block> INCORRECT_FOR_TEST_TOOL = createTag("incorrect_for_test_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(DrownedDepths.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> TEST_TOOL_MATERIALS = createTag("test_tool_materials");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(DrownedDepths.MOD_ID, name));
        }
    }
}
