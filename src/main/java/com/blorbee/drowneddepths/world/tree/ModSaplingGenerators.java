package com.blorbee.drowneddepths.world.tree;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator TEST_WOOD = new SaplingGenerator(DrownedDepths.MOD_ID + ":test",
            Optional.empty(), Optional.of(ModConfiguredFeatures.TEST_WOOD_KEY), Optional.empty());
}
