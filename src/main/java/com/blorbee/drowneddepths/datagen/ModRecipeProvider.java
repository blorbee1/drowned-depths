package com.blorbee.drowneddepths.datagen;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                List<ItemConvertible> TEST_ITEM_SMELTABLES = List.of(ModItems.TEST_FOOD, Items.ANDESITE);

                offerSmelting(TEST_ITEM_SMELTABLES, RecipeCategory.MISC, ModItems.TEST_ITEM, 0.25f, 200, "test_item");
                offerBlasting(TEST_ITEM_SMELTABLES, RecipeCategory.MISC, ModItems.TEST_ITEM, 0.25f, 100, "test_item");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.TEST_ITEM, RecipeCategory.DECORATIONS, ModBlocks.TEST_BLOCK);

                createShaped(RecipeCategory.MISC, ModBlocks.TEST_CUSTOM_BLOCK)
                        .pattern("###")
                        .pattern("# #")
                        .pattern("###")
                        .input('#', ModItems.TEST_FOOD)
                        .criterion(hasItem(ModItems.TEST_FOOD), conditionsFromItem(ModItems.TEST_FOOD))
                        .offerTo(exporter);

                offerShapelessRecipe(ModItems.TEST_FOOD, ModBlocks.TEST_CUSTOM_BLOCK, "test_food_from_test_custom_block", 8);
            }
        };
    }

    @Override
    public String getName() {
        return "Drowned Depths Recipes";
    }
}
