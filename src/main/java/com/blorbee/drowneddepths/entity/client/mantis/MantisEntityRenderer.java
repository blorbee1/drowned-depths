package com.blorbee.drowneddepths.entity.client.mantis;

import com.blorbee.drowneddepths.DrownedDepths;
import com.blorbee.drowneddepths.entity.custom.MantisEntity;
import com.blorbee.drowneddepths.entity.custom.MantisVariant;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class MantisEntityRenderer extends MobEntityRenderer<MantisEntity, MantisEntityRenderState, MantisEntityModel> {
    private static final Map<MantisVariant, Identifier> TEXTURES = Maps.newEnumMap(
            Map.of(
                MantisVariant.DEFAULT,
                Identifier.of(DrownedDepths.MOD_ID, "textures/entity/mantis/mantis.png"),
                MantisVariant.ORCHID,
                Identifier.of(DrownedDepths.MOD_ID, "textures/entity/mantis/mantis_orchid.png")
            ));

    // last parameter of super() is shadow radius
    public MantisEntityRenderer(EntityRendererFactory.Context context) {
        super(context,
                new MantisEntityModel(context.getPart(MantisEntityModel.MODEL_LAYER)), 0.75f);
    }

    @Override
    public Identifier getTexture(MantisEntityRenderState state) {
        return TEXTURES.get(state.variant);
    }

    @Override
    public MantisEntityRenderState createRenderState() {
        return new MantisEntityRenderState();
    }

    @Override
    public void updateRenderState(MantisEntity entity, MantisEntityRenderState state, float f) {
        super.updateRenderState(entity, state, f);
        state.variant = entity.getVariant();
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }

    @Override
    public void render(MantisEntityRenderState state, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (state.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(state, matrixStack, vertexConsumerProvider, i);
    }
}
