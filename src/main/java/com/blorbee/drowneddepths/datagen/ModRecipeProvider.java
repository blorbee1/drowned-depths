package com.blorbee.drowneddepths.datagen;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
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

                offerToolSet(ModItems.TEST_SWORD, ModItems.TEST_PICKAXE, ModItems.TEST_SHOVEL, ModItems.TEST_AXE, ModItems.TEST_HOE, ModItems.TEST_ITEM, Items.STICK);
                offerArmorSet(ModItems.TEST_HELMET, ModItems.TEST_CHESTPLATE, ModItems.TEST_LEGGINGS, ModItems.TEST_BOOTS, ModItems.TEST_ITEM);
            }

            private void offerSword(Item result, Item input, Item handle) {
                createShaped(RecipeCategory.COMBAT, result)
                        .pattern("I")
                        .pattern("I")
                        .pattern("H")
                        .input('I', input)
                        .input('H', handle)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .criterion(hasItem(handle), conditionsFromItem(handle))
                        .offerTo(exporter);
            }
            private void offerPickaxe(Item result, Item input, Item handle) {
                createShaped(RecipeCategory.TOOLS, result)
                        .pattern("III")
                        .pattern(" H ")
                        .pattern(" H ")
                        .input('I', input)
                        .input('H', handle)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .criterion(hasItem(handle), conditionsFromItem(handle))
                        .offerTo(exporter);
            }
            private void offerShovel(Item result, Item input, Item handle) {
                createShaped(RecipeCategory.TOOLS, result)
                        .pattern("I")
                        .pattern("H")
                        .pattern("H")
                        .input('I', input)
                        .input('H', handle)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .criterion(hasItem(handle), conditionsFromItem(handle))
                        .offerTo(exporter);
            }
            private void offerAxe(Item result, Item input, Item handle) {
                createShaped(RecipeCategory.TOOLS, result)
                        .pattern("II")
                        .pattern("IH")
                        .pattern(" H")
                        .input('I', input)
                        .input('H', handle)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .criterion(hasItem(handle), conditionsFromItem(handle))
                        .offerTo(exporter);
            }
            private void offerHoe(Item result, Item input, Item handle) {
                createShaped(RecipeCategory.TOOLS, result)
                        .pattern("II")
                        .pattern(" H")
                        .pattern(" H")
                        .input('I', input)
                        .input('H', handle)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .criterion(hasItem(handle), conditionsFromItem(handle))
                        .offerTo(exporter);
            }
            private void offerToolSet(Item sword, Item pickaxe, Item shovel, Item axe, Item hoe, Item input, Item handle) {
                offerSword(sword, input, handle);
                offerPickaxe(pickaxe, input, handle);
                offerShovel(shovel, input, handle);
                offerAxe(axe, input, handle);
                offerHoe(hoe, input, handle);
            }

            private void offerHelmet(Item result, Item input) {
                createShaped(RecipeCategory.COMBAT, result)
                        .pattern("###")
                        .pattern("# #")
                        .input('#', input)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .offerTo(exporter);
            }
            private void offerChestplate(Item result, Item input) {
                createShaped(RecipeCategory.COMBAT, result)
                        .pattern("# #")
                        .pattern("###")
                        .pattern("###")
                        .input('#', input)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .offerTo(exporter);
            }
            private void offerLeggings(Item result, Item input) {
                createShaped(RecipeCategory.COMBAT, result)
                        .pattern("###")
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', input)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .offerTo(exporter);
            }
            private void offerBoots(Item result, Item input) {
                createShaped(RecipeCategory.COMBAT, result)
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', input)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .offerTo(exporter);
            }
            private void offerArmorSet(Item helmet, Item chestplate, Item leggings, Item boots, Item input) {
                offerHelmet(helmet, input);
                offerChestplate(chestplate, input);
                offerLeggings(leggings, input);
                offerBoots(boots, input);
            }
        };
    }

    @Override
    public String getName() {
        return "Drowned Depths Recipes";
    }
}
