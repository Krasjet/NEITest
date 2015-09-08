/*
 * Copyright (c) 2015 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowinnovation.neitest.common.block;

import com.meowinnovation.neitest.NEITest;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Meow J on 8/30/2015.
 *
 * @author Meow J
 */
public class NEITestBlocks {

    public static final BlockMeowMachine meowMachine = new BlockMeowMachine();

    public static void registerBlocks() {
        registerBlock(meowMachine);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerRender(meowMachine);
    }

    private static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().replace("tile.", ""));
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(NEITest.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }
}
