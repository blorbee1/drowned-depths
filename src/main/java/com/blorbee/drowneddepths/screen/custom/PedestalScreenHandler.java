package com.blorbee.drowneddepths.screen.custom;

import com.blorbee.drowneddepths.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class PedestalScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public PedestalScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(pos));
    }

    public PedestalScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity entity) {
        super(ModScreenHandlers.PEDESTAL, syncId);
        this.inventory = ((Inventory) entity);

        addSlot(new Slot(inventory, 0, 80, 35) {
            @Override
            public int getMaxItemCount() {
                return 1;
            }
        }); // top left of the top slot (the slot that isnt the inventory)
        addPlayerInventory(playerInventory, 0, 0);
        addPlayerHotbar(playerInventory, 0, 0);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (invSlot < inventory.size()) {
                if (!insertItem(originalStack, inventory.size(), slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!insertItem(originalStack, 0, inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory, int xOffset, int yOffset) {
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 9; l++) {
                addSlot(new Slot(playerInventory, l + i * 9 + 9, (8 + l * 18) + xOffset, (84 + i * 18) + yOffset));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory, int xOffset, int yOffset) {
        for (int i = 0; i < 9; i++) {
            addSlot(new Slot(playerInventory, i, (8 + i * 18) + xOffset, 142 + yOffset));
        }
    }
}
