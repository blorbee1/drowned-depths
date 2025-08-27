package com.blorbee.drowneddepths.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class NorthHorizontalRotationBlock extends HorizontalFacingBlock {
    public static final MapCodec<NorthHorizontalRotationBlock> CODEC = createCodec(NorthHorizontalRotationBlock::new);
    private VoxelShape SHAPE = Block.createCubeShape(1);

    public NorthHorizontalRotationBlock(Settings settings) {
        super(settings);
    }
    public NorthHorizontalRotationBlock(VoxelShape shape, Settings settings) {
        super(settings);
        SHAPE = shape;
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getPlayer().isSneaking())
            return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
