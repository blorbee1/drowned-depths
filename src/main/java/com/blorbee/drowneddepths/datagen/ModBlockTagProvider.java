package com.blorbee.drowneddepths.datagen;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.TEST_BLOCK)
                .add(ModBlocks.TEST_CUSTOM_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TEST_BLOCK);

        valueLookupBuilder(BlockTags.FENCES)
                .add(ModBlocks.TEST_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.TEST_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.TEST_WALL);

        valueLookupBuilder(ModTags.Blocks.NEEDS_TEST_TOOL)
                .add(ModBlocks.TEST_CUSTOM_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        // prevents leaves from decaying when generating
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.TEST_LOG)
                .add(ModBlocks.STRIPPED_TEST_LOG)
                .add(ModBlocks.TEST_WOOD)
                .add(ModBlocks.STRIPPED_TEST_WOOD);
    }
}
