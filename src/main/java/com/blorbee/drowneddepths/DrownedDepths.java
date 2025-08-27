package com.blorbee.drowneddepths;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.block.entity.ModBlockEntities;
import com.blorbee.drowneddepths.component.ModDataComponentTypes;
import com.blorbee.drowneddepths.effect.ModStatusEffects;
import com.blorbee.drowneddepths.enchantment.ModEnchantmentEffects;
import com.blorbee.drowneddepths.entity.ModEntities;
import com.blorbee.drowneddepths.item.ModArmorMaterials;
import com.blorbee.drowneddepths.item.ModItemGroups;
import com.blorbee.drowneddepths.item.ModItems;
import com.blorbee.drowneddepths.item.ModToolMaterials;
import com.blorbee.drowneddepths.sound.ModSounds;
import com.blorbee.drowneddepths.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DrownedDepths implements ModInitializer {
	public static final String MOD_ID = "drowneddepths";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
	public void onInitialize() {
        LOGGER.info("Drowned Depths starting initialization.");

        ModItemGroups.register();
        ModItems.register();
        ModBlocks.register();
        ModSounds.register();
        ModDataComponentTypes.register();
        ModToolMaterials.register();
        ModArmorMaterials.register();
        ModStatusEffects.register();
        ModEnchantmentEffects.register();
        ModEntities.register();
        ModBlockEntities.register();

        ModWorldGeneration.generate();

        ModRegistries.registerEvents();
        ModRegistries.registerFlammables();
        ModRegistries.registerFuel();
        ModRegistries.registerStrippables();
        ModRegistries.registerEntityAttributes();

        LOGGER.info("Drowned Depths initialized.");
	}
}