package com.blorbee.drowneddepths.datagen;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.item.ModItems;
import com.blorbee.drowneddepths.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.TEST_ITEM)
                .add(Items.COAL)
                .add(Items.STICK);

        valueLookupBuilder(ModTags.Items.TEST_TOOL_MATERIALS)
                .add(ModItems.TEST_ITEM);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.TEST_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.TEST_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.TEST_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.TEST_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.TEST_HOE);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.TEST_HELMET)
                .add(ModItems.TEST_CHESTPLATE)
                .add(ModItems.TEST_LEGGINGS)
                .add(ModItems.TEST_BOOTS);

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.TEST_LOG.asItem())
                .add(ModBlocks.STRIPPED_TEST_LOG.asItem())
                .add(ModBlocks.TEST_WOOD.asItem())
                .add(ModBlocks.STRIPPED_TEST_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.TEST_PLANKS.asItem());
    }
}
