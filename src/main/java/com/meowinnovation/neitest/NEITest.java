/*
 * Copyright (c) 2014 Jerrell Fang
 *
 * This project is Open Source and distributed under The MIT License (MIT)
 * (http://opensource.org/licenses/MIT)
 *
 * You should have received a copy of the The MIT License along with
 * this project.   If not, see <http://opensource.org/licenses/MIT>.
 */

package com.meowinnovation.neitest;


import com.meowinnovation.neitest.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Meow J on 8/30/2015.
 *
 * @author Meow J
 */
@Mod(modid = NEITest.MODID, name = NEITest.NAME, version = "@VERSION@")
public class NEITest {
    public static final String MODID = "NEITest";
    public static final String NAME = "NEI Test";

    @Mod.Instance(NEITest.MODID)
    public static NEITest instance;

    @SidedProxy(clientSide = "com.meowinnovation.neitest.client.ClientProxy", serverSide = "com.meowinnovation.neitest.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}