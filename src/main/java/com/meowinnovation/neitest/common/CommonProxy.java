/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowinnovation.neitest.common;

import com.meowinnovation.neitest.NEITest;
import com.meowinnovation.neitest.common.block.NEITestBlocks;
import com.meowinnovation.neitest.common.block.container.ContainerMeowMachine;
import com.meowinnovation.neitest.common.block.tile.TileMeowMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Meow J on 7/26/2015.
 *
 * @author Meow J
 */
public class CommonProxy implements IGuiHandler {


    public void preInit(FMLPreInitializationEvent event) {
        NEITestBlocks.registerBlocks();
    }

    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(NEITest.instance, NEITest.proxy);
        GameRegistry.registerTileEntity(TileMeowMachine.class, "TileMeowMachine");
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if (tileEntity instanceof TileMeowMachine)
            return new ContainerMeowMachine(player.inventory, (TileMeowMachine) tileEntity);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}
