package com.blorbee.drowneddepths.item;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DROWNED_DEPTHS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DrownedDepths.MOD_ID, "drowned_depths"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.TEST_ITEM))
                    .displayName(Text.translatable("itemgroup.drowneddepths.drowned_depths"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.TEST_ITEM);
                      entries.add(ModItems.TEST_FOOD);
                      entries.add(ModItems.TEST_CUSTOM_ITEM);
                      entries.add(ModItems.MANTIS_SPAWN_EGG);

                      entries.add(ModBlocks.TEST_BLOCK);
                      entries.add(ModBlocks.TEST_CUSTOM_BLOCK);
                      entries.add(ModBlocks.TEST_STAIRS);
                      entries.add(ModBlocks.TEST_SLAB);
                      entries.add(ModBlocks.TEST_PRESSURE_PLATE);
                      entries.add(ModBlocks.TEST_BUTTON);
                      entries.add(ModBlocks.TEST_FENCE);
                      entries.add(ModBlocks.TEST_FENCE_GATE);
                      entries.add(ModBlocks.TEST_WALL);
                      entries.add(ModBlocks.TEST_DOOR);
                      entries.add(ModBlocks.TEST_TRAPDOOR);
                      entries.add(ModBlocks.CHAIR);
                      entries.add(ModBlocks.PEDESTAL);

                      entries.add(ModItems.TEST_SWORD);
                      entries.add(ModItems.TEST_PICKAXE);
                      entries.add(ModItems.TEST_SHOVEL);
                      entries.add(ModItems.TEST_AXE);
                      entries.add(ModItems.TEST_HOE);
                      entries.add(ModItems.TEST_HAMMER);

                      entries.add(ModItems.TEST_HELMET);
                      entries.add(ModItems.TEST_CHESTPLATE);
                      entries.add(ModItems.TEST_LEGGINGS);
                      entries.add(ModItems.TEST_BOOTS);

                      entries.add(ModBlocks.TEST_LOG);
                      entries.add(ModBlocks.TEST_WOOD);
                      entries.add(ModBlocks.STRIPPED_TEST_LOG);
                      entries.add(ModBlocks.STRIPPED_TEST_WOOD);
                      entries.add(ModBlocks.TEST_LEAVES);
                      entries.add(ModBlocks.TEST_SAPLING);
                      entries.add(ModBlocks.TEST_PLANKS);
                    }).build());

    public static void register() {
        DrownedDepths.LOGGER.info("Registering item groups for " + DrownedDepths.MOD_ID);
    }
}
