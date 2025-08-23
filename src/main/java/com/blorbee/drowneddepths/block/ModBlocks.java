package com.blorbee.drowneddepths.block;

import com.blorbee.drowneddepths.DrownedDepths;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block TEST_BLOCK = register("test_block", Block::new, AbstractBlock.Settings.create()
            .strength(4f)
            .requiresTool()
            .sounds(BlockSoundGroup.AMETHYST_BLOCK));

    private static void registerBlockItem(String name, Block block) {
        final RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DrownedDepths.MOD_ID, name));
        final Item.Settings settings = new Item.Settings()
                .useBlockPrefixedTranslationKey();
        Items.register(block, BlockItem::new, settings);
    }

    private static Block register(String name, Function<Block.Settings, Block> factory, Block.Settings settings) {
        final RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(DrownedDepths.MOD_ID, name));
        Block block = Blocks.register(key, factory, settings);
        registerBlockItem(name, block);
        return block;
    }

    public static void registerModBlocks() {
        DrownedDepths.LOGGER.info("Registering mod blocks for " + DrownedDepths.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(TEST_BLOCK);
        });
    }
}
