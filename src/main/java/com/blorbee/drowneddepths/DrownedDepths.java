package com.blorbee.drowneddepths;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.component.ModDataComponentTypes;
import com.blorbee.drowneddepths.effect.ModStatusEffects;
import com.blorbee.drowneddepths.enchantment.ModEnchantmentEffects;
import com.blorbee.drowneddepths.item.ModArmorMaterials;
import com.blorbee.drowneddepths.item.ModItemGroups;
import com.blorbee.drowneddepths.item.ModItems;
import com.blorbee.drowneddepths.item.ModToolMaterials;
import com.blorbee.drowneddepths.sound.ModSounds;
import com.blorbee.drowneddepths.util.HammerUsageEvent;
import com.blorbee.drowneddepths.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrownedDepths implements ModInitializer {
	public static final String MOD_ID = "drowneddepths";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final int BOOTS_INDEX = 36;
    public static final int LEGGINGS_INDEX = 37;
    public static final int CHESTPLATE_INDEX = 38;
    public static final int HELMET_INDEX = 39;

	@Override
	public void onInitialize() {
        LOGGER.info("Drowned Depths starting initialization.");

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModSounds.registerModSounds();
        ModDataComponentTypes.registerModDataComponentTypes();
        ModToolMaterials.registerModToolMaterials();
        ModArmorMaterials.registerModArmorMaterials();
        ModStatusEffects.registerStatusEffects();
        ModEnchantmentEffects.registerEnchantmentEffects();
        ModWorldGeneration.generateModWorldGen();

        StrippableBlockRegistry.register(ModBlocks.TEST_LOG, ModBlocks.STRIPPED_TEST_LOG);
        StrippableBlockRegistry.register(ModBlocks.TEST_WOOD, ModBlocks.STRIPPED_TEST_WOOD);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.TEST_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.TEST_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_TEST_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_TEST_WOOD, 5, 5);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.TEST_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.TEST_PLANKS, 5, 20);

        FuelRegistryEvents.BUILD.register(((builder, context) -> {
            builder.add(ModItems.TEST_FOOD, context.baseSmeltTime() / 4);
        }));

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

        LOGGER.info("Drowned Depths initialized.");
	}
}