package com.blorbee.drowneddepths;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.component.ModDataComponentTypes;
import com.blorbee.drowneddepths.effect.ModStatusEffects;
import com.blorbee.drowneddepths.item.ModArmorMaterials;
import com.blorbee.drowneddepths.item.ModItemGroups;
import com.blorbee.drowneddepths.item.ModItems;
import com.blorbee.drowneddepths.item.ModToolMaterials;
import com.blorbee.drowneddepths.sound.ModSounds;
import com.blorbee.drowneddepths.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
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
        ModSounds.registerSounds();
        ModDataComponentTypes.registerModDataComponentTypes();
        ModToolMaterials.registerModToolMaterials();
        ModArmorMaterials.registerModArmorMaterials();
        ModStatusEffects.registerStatusEffects();

        FuelRegistryEvents.BUILD.register(((builder, context) -> {
            builder.add(ModItems.TEST_FOOD, context.baseSmeltTime() / 4);
        }));

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

        LOGGER.info("Drowned Depths initialized.");
	}
}