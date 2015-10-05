/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowinnovation.neitest.common.block.container;

import com.meowinnovation.neitest.common.block.tile.TileMeowMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Meow J on 8/30/2015.
 *
 * @author Meow J
 */
public class ContainerMeowMachine extends Container {
    private TileMeowMachine tileEntity;

    public ContainerMeowMachine(InventoryPlayer inventoryPlayer, TileMeowMachine tileEntity) {
        this.tileEntity = tileEntity;

        this.addSlotToContainer(new Slot(tileEntity, 0, 28, 38) {
            @Override
            public boolean isItemValid(ItemStack itemStack) {
                return itemStack.getItem() == Items.fishing_rod;
            }
        });
        this.addSlotToContainer(new Slot(tileEntity, 1, 63, 38));
        this.addSlotToContainer(new Slot(tileEntity, 2, 121, 38) {
            @Override
            public boolean isItemValid(ItemStack itemStack) {
                return false;
            }
        });

        // Player inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    public TileMeowMachine getTileEntity() {
        return tileEntity;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemStack = null;
        Slot slotObject = (Slot) inventorySlots.get(index);

        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            itemStack = stackInSlot.copy();

            if (index < tileEntity.getSizeInventory()) {
                if (!this.mergeItemStack(stackInSlot, tileEntity.getSizeInventory(), this.inventorySlots.size(), true))
                    return null;
            } else if (!this.mergeItemStack(stackInSlot, 0, tileEntity.getSizeInventory(), false))
                return null;


            if (stackInSlot.stackSize == 0)
                slotObject.putStack(null);
            else
                slotObject.onSlotChanged();

            if (stackInSlot.stackSize == itemStack.stackSize)
                return null;

            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return itemStack;
    }
}
