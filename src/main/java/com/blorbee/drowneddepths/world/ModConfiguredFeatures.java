package com.blorbee.drowneddepths.world;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> TEST_ORE_KEY = registryKey("test_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldTestOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.TEST_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.TEST_STAIRS.getDefaultState()));

        // size is the vein size
        register(context, TEST_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTestOres, 12));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(DrownedDepths.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
