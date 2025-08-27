package com.blorbee.drowneddepths;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.entity.ModEntities;
import com.blorbee.drowneddepths.entity.client.mantis.MantisEntityModel;
import com.blorbee.drowneddepths.entity.client.mantis.MantisEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;

public class DrownedDepthsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.TEST_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.TEST_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.TEST_SAPLING, BlockRenderLayer.CUTOUT);

        initializeEntities();
    }

    private void initializeEntities() {
        EntityModelLayerRegistry.registerModelLayer(MantisEntityModel.MODEL_LAYER, MantisEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisEntityRenderer::new);
    }
}
