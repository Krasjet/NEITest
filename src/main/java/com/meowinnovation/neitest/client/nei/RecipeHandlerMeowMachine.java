/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowinnovation.neitest.client.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import com.meowinnovation.neitest.api.recipe.RecipeMeowMachine;
import com.meowinnovation.neitest.api.recipe.Recipes;
import com.meowinnovation.neitest.client.gui.GuiMeowMachine;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meow J on 10/5/2015.
 *
 * @author Meow J
 */
public class RecipeHandlerMeowMachine extends TemplateRecipeHandler {
    public static final String OUTPUT_ID = "meowmachine";

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiMeowMachine.class;
    }

    @Override
    public String getGuiTexture() {
        return "neitest:textures/gui/guiMeowMachine.png";
    }

    @Override
    public String getRecipeName() {
        return StatCollector.translateToLocal("tile.meow_machine.name");
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(95, 40, 10, 10), OUTPUT_ID));
    }

    @Override
    public int recipiesPerPage() {
        return 1;
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals(OUTPUT_ID)) {
            for (RecipeMeowMachine recipe : Recipes.meowMachineRecipes)
                this.arecipes.add(new CachedMeowMachineRecipe(recipe));
        } else
            super.loadCraftingRecipes(outputId, results);
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (RecipeMeowMachine recipe : Recipes.meowMachineRecipes) {
            if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getOutput(), result)) {
                this.arecipes.add(new CachedMeowMachineRecipe(recipe));
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        for (RecipeMeowMachine recipe : Recipes.meowMachineRecipes) {
            CachedMeowMachineRecipe cachedRecipe = new CachedMeowMachineRecipe(recipe);
            if (cachedRecipe.contains(cachedRecipe.getIngredients(), ingredient))
                this.arecipes.add(cachedRecipe);
        }
    }

    public class CachedMeowMachineRecipe extends CachedRecipe {
        public PositionedStack input;
        public PositionedStack fishingRod;
        public PositionedStack result;

        public CachedMeowMachineRecipe(Object input, ItemStack output) {
            this.fishingRod = new PositionedStack(new ItemStack(Items.fishing_rod), 23, 27);
            this.input = new PositionedStack(input, 58, 27);
            this.result = new PositionedStack(output, 116, 27);
        }

        public CachedMeowMachineRecipe(RecipeMeowMachine recipe) {
            this(recipe.getCraftingInput(), recipe.getOutput());
        }

        @Override
        public List<PositionedStack> getIngredients() {
            List<PositionedStack> ingredients = new ArrayList<PositionedStack>();
            ingredients.add(input);
            ingredients.add(fishingRod);
            return ingredients;
        }

        @Override
        public PositionedStack getResult() {
            return result;
        }
    }
}
