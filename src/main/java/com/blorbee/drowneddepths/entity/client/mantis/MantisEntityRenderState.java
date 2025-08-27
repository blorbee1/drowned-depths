package com.blorbee.drowneddepths.entity.client.mantis;

import com.blorbee.drowneddepths.entity.custom.MantisVariant;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class MantisEntityRenderState extends LivingEntityRenderState {
    public MantisVariant variant = MantisVariant.DEFAULT;
    public final AnimationState idleAnimationState = new AnimationState();
}
