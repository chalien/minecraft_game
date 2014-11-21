package com.koombea.gamemin;

import com.koombea.gamemin.blocks.ModBlock;

import com.koombea.gamemin.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class GameMin {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModBlock.init();
		
	}
	
	@Mod.EventHandler
	public void init(FMLPreInitializationEvent event)
	{
	
	}
	
	@Mod.EventHandler
	public void postInit(FMLPreInitializationEvent event)
	{
	
	}
}
