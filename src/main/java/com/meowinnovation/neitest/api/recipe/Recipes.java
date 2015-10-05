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

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meow J on 10/5/2015.
 *
 * @author Meow J
 */
public class Recipes {
    public static List<RecipeMeowMachine> meowMachineRecipes = new ArrayList<RecipeMeowMachine>();

    /**
     * Register a Meow Machine Recipe.
     *
     * @param input  The input of the Meow Machine Recipe. Supported Type: String, ItemStack, Item, Block
     * @param output The output of the recipe.
     * @return The recipe registered.
     */
    public static RecipeMeowMachine registerMeowMachineRecipe(Object input, ItemStack output) {
        RecipeMeowMachine recipe = new RecipeMeowMachine(input, output);
        meowMachineRecipes.add(recipe);
        return recipe;
    }
}
