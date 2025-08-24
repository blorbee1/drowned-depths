package com.blorbee.drowneddepths.block;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.block.custom.TestCustomBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
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

    public static final Block TEST_CUSTOM_BLOCK = register("test_custom_block", TestCustomBlock::new, AbstractBlock.Settings.create()
            .strength(1f)
            .requiresTool());

    public static final Block TEST_STAIRS = register("test_stairs",
            settings -> new StairsBlock(ModBlocks.TEST_BLOCK.getDefaultState(), settings), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool());
    public static final Block TEST_SLAB = register("test_slab", SlabBlock::new, AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool());

    public static final Block TEST_BUTTON = register("test_button",
            settings -> new ButtonBlock(BlockSetType.IRON, 2, settings), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .noCollision());
    public static final Block TEST_PRESSURE_PLATE = register("test_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.IRON, settings), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool());

    public static final Block TEST_FENCE = register("test_fence", FenceBlock::new, AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool());
    public static final Block TEST_FENCE_GATE = register("test_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool());
    public static final Block TEST_WALL = register("test_wall", WallBlock::new, AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool());

    public static final Block TEST_DOOR = register("test_door",
            settings -> new DoorBlock(BlockSetType.IRON, settings), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .nonOpaque());
    public static final Block TEST_TRAPDOOR = register("test_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.IRON, settings), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .nonOpaque());

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
            entries.add(TEST_CUSTOM_BLOCK);
        });
    }
}
