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
import net.minecraft.inventory.Container;

/**
 * Created by Meow J on 8/30/2015.
 *
 * @author Meow J
 */
public class ContainerMeowMachine extends Container {
    private TileMeowMachine tileEntity;

    public ContainerMeowMachine(TileMeowMachine tileEntity) {
        this.tileEntity = tileEntity;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    public TileMeowMachine getTileEntity() {
        return tileEntity;
    }
}
