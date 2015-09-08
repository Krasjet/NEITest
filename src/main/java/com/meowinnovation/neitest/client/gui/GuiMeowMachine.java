/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowinnovation.neitest.client.gui;

import com.meowinnovation.neitest.common.block.container.ContainerMeowMachine;
import com.meowinnovation.neitest.common.block.tile.TileMeowMachine;
import net.minecraft.client.gui.inventory.GuiContainer;

/**
 * Created by Meow J on 8/30/2015.
 *
 * @author Meow J
 */
public class GuiMeowMachine extends GuiContainer {
    private TileMeowMachine tileEntity;

    public GuiMeowMachine(TileMeowMachine tileEntity) {
        super(new ContainerMeowMachine(tileEntity));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

    }
}
