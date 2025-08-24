package com.blorbee.drowneddepths.datagen;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TEST_BLOCK);
        addDrop(ModBlocks.TEST_STAIRS);
        addDrop(ModBlocks.TEST_BUTTON);
        addDrop(ModBlocks.TEST_PRESSURE_PLATE);
        addDrop(ModBlocks.TEST_FENCE);
        addDrop(ModBlocks.TEST_FENCE_GATE);
        addDrop(ModBlocks.TEST_WALL);
        addDrop(ModBlocks.TEST_TRAPDOOR);

        addDrop(ModBlocks.TEST_SLAB, slabDrops(ModBlocks.TEST_SLAB));
        addDrop(ModBlocks.TEST_DOOR, doorDrops(ModBlocks.TEST_DOOR));

        multipleOreDrops(ModBlocks.TEST_CUSTOM_BLOCK, ModItems.TEST_ITEM, 2, 5);
    }

    public void multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        addDrop(drop, block -> oreDrops(block, item)
                .apply(SetCountLootFunction.builder(
                        UniformLootNumberProvider.create(minDrops, maxDrops)
                )));
    }
}
