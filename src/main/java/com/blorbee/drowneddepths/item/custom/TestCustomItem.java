package com.blorbee.drowneddepths.item.custom;

import com.blorbee.drowneddepths.block.ModBlocks;
import com.blorbee.drowneddepths.component.ModDataComponentTypes;
import com.blorbee.drowneddepths.item.ModItems;
import com.blorbee.drowneddepths.sound.ModSounds;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class TestCustomItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.OAK_LOG, ModBlocks.TEST_BLOCK,
                    Blocks.DIAMOND_BLOCK, Blocks.MUD
            );

    public TestCustomItem(Settings settings) {
        super(settings);

        ItemTooltipCallback.EVENT.register(((itemStack, tooltipContext, tooltipType, list) -> {
            if (!itemStack.isOf(ModItems.TEST_CUSTOM_ITEM.asItem()))
                return;
            list.add(Text.translatable("item.drowneddepths.test_custom_item.tooltip"));

            if (itemStack.get(ModDataComponentTypes.COORDINATES) != null) {
                list.add(Text.literal("Last Block Changed at " + itemStack.get(ModDataComponentTypes.COORDINATES)));
            }
        }));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_MAP.containsKey(block) && !world.isClient) {
            world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(block).getDefaultState());
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            world.playSound(null, context.getBlockPos(), ModSounds.TEST_SOUND, SoundCategory.BLOCKS, 1f, 1f);

            context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
        }

        return ActionResult.SUCCESS;
    }
}
