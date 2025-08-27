package com.blorbee.drowneddepths.entity.custom;

import com.blorbee.drowneddepths.entity.ModEntities;
import com.blorbee.drowneddepths.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class MantisEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    private static final TrackedData<Integer> VARIANT =
            DataTracker.registerData(MantisEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public MantisEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItem(ModItems.TEST_FOOD), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return AnimalEntity.createAnimalAttributes()
                .add(EntityAttributes.MAX_HEALTH, 18)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.35D)
                .add(EntityAttributes.ATTACK_DAMAGE, 1)
                .add(EntityAttributes.FOLLOW_RANGE, 20);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = 40; // idle animation is 2 seconds long which is 40 ticks
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (getWorld().isClient) {
            setupAnimationStates();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.TEST_FOOD);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        MantisEntity baby = ModEntities.MANTIS.create(world, SpawnReason.BREEDING);
        if (baby != null) {
            MantisEntity otherParent = ((MantisEntity) entity);
            int i = this.random.nextInt(9);

            MantisVariant babyVariant;
            if (i < 4) {
                babyVariant = getVariant();
            } else if (i < 8) {
                babyVariant = otherParent.getVariant();
            } else {
                babyVariant = Util.getRandom(MantisVariant.values(), random);
            }
            baby.setVariant(babyVariant);
        }

        return baby;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(VARIANT, 0);
    }

    public MantisVariant getVariant() {
        return MantisVariant.byId(getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return dataTracker.get(VARIANT);
    }

    private void setVariant(MantisVariant variant) {
        dataTracker.set(VARIANT, variant.getId() & 255);
    }

    @Override
    protected void writeCustomData(WriteView view) {
        super.writeCustomData(view);
        view.putInt("Variant", getTypeVariant());
    }

    @Override
    protected void readCustomData(ReadView view) {
        super.readCustomData(view);
        setVariant(MantisVariant.byId(view.getInt("Variant", 0)));
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        MantisVariant variant = Util.getRandom(MantisVariant.values(), random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }
}
