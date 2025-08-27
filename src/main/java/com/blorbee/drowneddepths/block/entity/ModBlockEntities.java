package com.blorbee.drowneddepths.block.entity;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.block.entity.custom.PedestalBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL = register("pedestal_be", PedestalBlockEntity::new, ModBlocks.PEDESTAL);

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<T> factory, Block block) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(DrownedDepths.MOD_ID, name),
                FabricBlockEntityTypeBuilder.create(factory, block).build());
    }

    public static void register() {
        DrownedDepths.LOGGER.info("Registering block entities for " + DrownedDepths.MOD_ID);
    }
}
