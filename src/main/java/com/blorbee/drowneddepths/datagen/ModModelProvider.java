package com.blorbee.drowneddepths.datagen;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.item.ModArmorMaterials;
import com.blorbee.drowneddepths.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEST_CUSTOM_BLOCK);
        blockStateModelGenerator.registerDoor(ModBlocks.TEST_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TEST_TRAPDOOR);

        BlockStateModelGenerator.BlockTexturePool testPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TEST_BLOCK);
        testPool.stairs(ModBlocks.TEST_STAIRS);
        testPool.slab(ModBlocks.TEST_SLAB);
        testPool.button(ModBlocks.TEST_BUTTON);
        testPool.pressurePlate(ModBlocks.TEST_PRESSURE_PLATE);
        testPool.fence(ModBlocks.TEST_FENCE);
        testPool.fenceGate(ModBlocks.TEST_FENCE_GATE);
        testPool.wall(ModBlocks.TEST_WALL);

        BlockStateModelGenerator.LogTexturePool testLogPool = blockStateModelGenerator.createLogTexturePool(ModBlocks.TEST_LOG);
        testLogPool.log(ModBlocks.TEST_LOG);
        testLogPool.wood(ModBlocks.TEST_WOOD);

        BlockStateModelGenerator.LogTexturePool strippedTestLogPool = blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_TEST_LOG);
        strippedTestLogPool.log(ModBlocks.STRIPPED_TEST_LOG);
        strippedTestLogPool.wood(ModBlocks.STRIPPED_TEST_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEST_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.TEST_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.TEST_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TEST_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TEST_CUSTOM_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TEST_FOOD, Models.GENERATED);

        itemModelGenerator.register(ModItems.TEST_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TEST_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TEST_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TEST_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TEST_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TEST_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(ModBlocks.TEST_SAPLING.asItem(), Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.TEST_HELMET, ModArmorMaterials.TEST_ARMOR_MATERIAL_KEY, Identifier.of("minecraft:trims/items/helmet_trim"), false);
        itemModelGenerator.registerArmor(ModItems.TEST_CHESTPLATE, ModArmorMaterials.TEST_ARMOR_MATERIAL_KEY, Identifier.of("minecraft:trims/items/chestplate_trim"), false);
        itemModelGenerator.registerArmor(ModItems.TEST_LEGGINGS, ModArmorMaterials.TEST_ARMOR_MATERIAL_KEY, Identifier.of("minecraft:trims/items/leggings_trim"), false);
        itemModelGenerator.registerArmor(ModItems.TEST_BOOTS, ModArmorMaterials.TEST_ARMOR_MATERIAL_KEY, Identifier.of("minecraft:trims/items/boots_trim"), false);
    }
}
