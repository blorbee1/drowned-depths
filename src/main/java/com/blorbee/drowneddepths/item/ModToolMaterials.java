package com.blorbee.drowneddepths.item;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.util.ModTags;
import net.minecraft.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial TEST = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_TEST_TOOL,
            1200, 5.0F, 4.0F, 22, ModTags.Items.TEST_TOOL_MATERIALS);

    public static void registerModToolMaterials() {
        DrownedDepths.LOGGER.info("Registering tool materials for " + DrownedDepths.MOD_ID);
    }
}
