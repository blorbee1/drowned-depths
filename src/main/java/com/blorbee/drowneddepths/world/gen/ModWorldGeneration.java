package com.blorbee.drowneddepths.world.gen;

public class ModWorldGeneration {
    public static void generate() {
        // order of the generate() calls is important, ores come before trees
        // check the generation step order (it goes top to bottom, use ctrl + click on GenerationStep)
        ModOreGeneration.generate();
        ModTreeGeneration.generate();
    }
}
