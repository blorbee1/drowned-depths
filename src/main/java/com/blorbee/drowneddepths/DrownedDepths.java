package com.blorbee.drowneddepths;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.item.ModItemGroups;
import com.blorbee.drowneddepths.item.ModItems;
import net.fabricmc.api.ModInitializer;

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

        LOGGER.info("Drowned Depths initialized.");
	}
}