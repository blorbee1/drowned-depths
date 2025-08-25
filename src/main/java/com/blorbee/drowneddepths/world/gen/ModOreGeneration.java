package com.blorbee.drowneddepths.world.gen;

import com.blorbee.drowneddepths.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generate() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.TEST_ORE_PLACED_KEY);
    }
}
