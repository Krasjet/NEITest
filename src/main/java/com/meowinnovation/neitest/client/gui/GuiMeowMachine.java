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
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/**
 * Created by Meow J on 8/30/2015.
 *
 * @author Meow J
 */
public class GuiMeowMachine extends GuiContainer {
    private TileMeowMachine tileEntity;

    public GuiMeowMachine(InventoryPlayer inventory, TileMeowMachine tileEntity) {
        super(new ContainerMeowMachine(inventory, tileEntity));
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(new ResourceLocation("neitest:textures/gui/guiMeowMachine.png"));
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        fontRendererObj.drawString(StatCollector.translateToLocal("tile.meow_machine.name"), 8, 6, 4210752);
    }

}
