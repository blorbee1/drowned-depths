package com.blorbee.drowneddepths;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.block.entity.ModBlockEntities;
import com.blorbee.drowneddepths.block.entity.renderer.PedestalBlockEntityRenderer;
import com.blorbee.drowneddepths.entity.ModEntities;
import com.blorbee.drowneddepths.entity.client.mantis.MantisEntityModel;
import com.blorbee.drowneddepths.entity.client.mantis.MantisEntityRenderer;
import com.blorbee.drowneddepths.screen.ModScreenHandlers;
import com.blorbee.drowneddepths.screen.custom.PedestalScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class DrownedDepthsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.TEST_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.TEST_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.TEST_SAPLING, BlockRenderLayer.CUTOUT);

        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL, PedestalBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.PEDESTAL, PedestalScreen::new);

        initializeEntities();
    }

    private void initializeEntities() {
        EntityModelLayerRegistry.registerModelLayer(MantisEntityModel.MODEL_LAYER, MantisEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisEntityRenderer::new);
    }
}
