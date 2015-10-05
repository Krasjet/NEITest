/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowinnovation.neitest.api.recipe;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

/**
 * Created by Meow J on 8/30/2015.
 *
 * @author Meow J
 */
public class RecipeMeowMachine {
    private ItemStack output;
    private Object input;

    /**
     * The constructor of RecipeMeowMachine
     *
     * @param input  The input of the recipe. Supported Type: String, ItemStack, Item, Block
     * @param output The output of the recipe.
     */
    public RecipeMeowMachine(Object input, ItemStack output) {
        this.output = output;

        if (input instanceof String || input instanceof ItemStack)
            this.input = input;
        else if (input instanceof Block)
            this.input = new ItemStack((Block) input);
        else if (input instanceof Item)
            this.input = new ItemStack((Item) input);
        else throw new IllegalArgumentException("Invalid input");
    }

    public ItemStack getOutput() {
        return output;
    }

    public Object getInput() {
        return input;
    }

    public boolean matches(IInventory inventory) {
        if (inventory.getStackInSlot(0).isItemEqual(new ItemStack(Items.fishing_rod))) {
            if (input instanceof ItemStack)
                return inventory.getStackInSlot(1).isItemEqual((ItemStack) input);
            else if (input instanceof String)
                return isEqualOreDict(inventory.getStackInSlot(1), ((String) input));
        }
        return false;
    }

    public boolean isEqualOreDict(ItemStack itemStack, String entry) {
        if (itemStack == null || itemStack.getItem() == null)
            return false;

        List<ItemStack> ores = OreDictionary.getOres(entry);

        for (ItemStack ore : ores) {
            ItemStack copy = ore.copy();
            if (copy.getItemDamage() == Short.MAX_VALUE)
                copy.setItemDamage(itemStack.getItemDamage());

            if (itemStack.isItemEqual(copy))
                return true;
        }
        return false;
    }
}
