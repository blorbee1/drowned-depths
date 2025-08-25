package com.blorbee.drowneddepths.world;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> TEST_ORE_PLACED_KEY = registryKey("test_ore_placed");

    public static final RegistryKey<PlacedFeature> TEST_WOOD_PLACED_KEY = registryKey("test_wood_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // modifiersWithCount -> count is about how many veins per chunk
        register(context, TEST_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TEST_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        // VegetationPlacedFeatures.treeModifiersWithWouldSurvive() makes the generation of trees only spawn where the sapling can be placed
        // PlacedFeatures.createCountExtraModifier(), the extraChance must be an int when doing 1 / extraChance otherwise it will error
        register(context, TEST_WOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TEST_WOOD_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.TEST_SAPLING));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(DrownedDepths.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> config,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, config, List.of(modifiers));
    }
}
