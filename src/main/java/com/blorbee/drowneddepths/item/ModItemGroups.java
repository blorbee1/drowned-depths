package com.blorbee.drowneddepths.item;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DROWNED_DEPTHS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DrownedDepths.MOD_ID, "drowned_depths"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.TEST_ITEM))
                    .displayName(Text.translatable("itemgroup.drowneddepths.drowned_depths_group"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.TEST_ITEM);
                      entries.add(ModBlocks.TEST_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        DrownedDepths.LOGGER.info("Registering item groups for " + DrownedDepths.MOD_ID);
    }
}
