package com.blorbee.drowneddepths.datagen.lang;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.effect.ModStatusEffects;
import com.blorbee.drowneddepths.item.ModItemGroups;
import com.blorbee.drowneddepths.item.ModItems;
import com.blorbee.drowneddepths.sound.ModSounds;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundEvent;

import java.util.concurrent.CompletableFuture;

public class ModLanguageENUSProvider extends FabricLanguageProvider {
    public ModLanguageENUSProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.TEST_ITEM, "Test Item");
        addItemWithTooltip(translationBuilder, ModItems.TEST_CUSTOM_ITEM, "Test Custom Item", "does some really cool stuff #2!");
        translationBuilder.add(ModItems.TEST_FOOD, "Test Food");

        addBlockWithTooltip(translationBuilder, ModBlocks.TEST_CUSTOM_BLOCK, "Test Custom Block", "does some really cool stuff!");
        translationBuilder.add(ModBlocks.TEST_BLOCK, "Test Block");

        translationBuilder.add(ModBlocks.TEST_STAIRS, "Test Stairs");
        translationBuilder.add(ModBlocks.TEST_SLAB, "Test Slab");
        translationBuilder.add(ModBlocks.TEST_PRESSURE_PLATE, "Test Pressure Plate");
        translationBuilder.add(ModBlocks.TEST_BUTTON, "Test Button");
        translationBuilder.add(ModBlocks.TEST_FENCE, "Test Fence");
        translationBuilder.add(ModBlocks.TEST_FENCE_GATE, "Test Fence Gate");
        translationBuilder.add(ModBlocks.TEST_WALL, "Test Wall");
        translationBuilder.add(ModBlocks.TEST_DOOR, "Test Door");
        translationBuilder.add(ModBlocks.TEST_TRAPDOOR, "Test Trapdoor");

        translationBuilder.add(ModItems.TEST_SWORD, "Test Sword");
        translationBuilder.add(ModItems.TEST_PICKAXE, "Test Pickaxe");
        translationBuilder.add(ModItems.TEST_SHOVEL, "Test Shovel");
        translationBuilder.add(ModItems.TEST_AXE, "Test Axe");
        translationBuilder.add(ModItems.TEST_HOE, "Test Hoe");
        translationBuilder.add(ModItems.TEST_HAMMER, "Test Hammer");

        translationBuilder.add(ModItems.TEST_HELMET, "Test Helmet");
        translationBuilder.add(ModItems.TEST_CHESTPLATE, "Test Chestplate");
        translationBuilder.add(ModItems.TEST_LEGGINGS, "Test Leggings");
        translationBuilder.add(ModItems.TEST_BOOTS, "Test Boots");

        addItemGroup(translationBuilder, ModItemGroups.DROWNED_DEPTHS_GROUP, "Drowned Depths");

        translationBuilder.add(ModSounds.TEST_SOUND, "Test Sound");

        translationBuilder.add(ModStatusEffects.SLIMEY.value(), "Slimey");
    }

    private void addItemGroup(TranslationBuilder translationBuilder, ItemGroup group, String translation) {
        String id = Registries.ITEM_GROUP.getId(group).getPath();
        translationBuilder.add("itemgroup." + DrownedDepths.MOD_ID + "." + id, translation);
    }
    private void addItemWithTooltip(TranslationBuilder translationBuilder, Item item, String itemTranslation, String tooltipTranslation) {
        translationBuilder.add(item, itemTranslation);
        String itemId = Registries.ITEM.getId(item).getPath();
        translationBuilder.add("item." + DrownedDepths.MOD_ID + "." + itemId + ".tooltip", tooltipTranslation);
    }
    private void addBlockWithTooltip(TranslationBuilder translationBuilder, Block block, String blockTranslation, String tooltipTranslation) {
        translationBuilder.add(block, blockTranslation);
        String blockId = Registries.BLOCK.getId(block).getPath();
        translationBuilder.add("block." + DrownedDepths.MOD_ID + "." + blockId + ".tooltip", tooltipTranslation);
    }
}
