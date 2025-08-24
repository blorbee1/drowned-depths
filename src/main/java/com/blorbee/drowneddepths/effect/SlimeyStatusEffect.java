package com.blorbee.drowneddepths.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class SlimeyStatusEffect extends StatusEffect {
    public SlimeyStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.horizontalCollision) {
            Vec3d initVec = entity.getVelocity();
            Vec3d climbVec = new Vec3d(initVec.x, 0.2D, initVec.z);

            entity.setVelocity(climbVec.multiply(0.96D));
            return true;
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
