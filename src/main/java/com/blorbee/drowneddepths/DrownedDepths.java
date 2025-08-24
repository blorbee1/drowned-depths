package com.blorbee.drowneddepths;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.component.ModDataComponentTypes;
import com.blorbee.drowneddepths.item.ModItemGroups;
import com.blorbee.drowneddepths.item.ModItems;
import com.blorbee.drowneddepths.item.ModToolMaterials;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrownedDepths implements ModInitializer {
	public static final String MOD_ID = "drowneddepths";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        LOGGER.info("Drowned Depths starting initialization.");

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModDataComponentTypes.registerModDataComponentTypes();
        ModToolMaterials.registerModToolMaterials();

        FuelRegistryEvents.BUILD.register(((builder, context) -> {
            builder.add(ModItems.TEST_FOOD, context.baseSmeltTime() / 4);
        }));

        LOGGER.info("Drowned Depths initialized.");
	}
}