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

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import com.meowinnovation.neitest.NEITest;
import com.meowinnovation.neitest.client.gui.GuiMeowMachine;

/**
 * Created by Meow J on 10/5/2015.
 *
 * @author Meow J
 */
public class NEIConfig implements IConfigureNEI {
    @Override
    public void loadConfig() {
        API.registerRecipeHandler(new RecipeHandlerMeowMachine());
        API.registerRecipeHandler(new RecipeHandlerMeowMachine());
        API.setGuiOffset(GuiMeowMachine.class, 0, 0);
    }

    @Override
    public String getName() {
        return NEITest.NAME + " NEI Plugin";
    }

    @Override
    public String getVersion() {
        return NEITest.VERSION;
    }
}
