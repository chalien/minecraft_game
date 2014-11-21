package com.koombea.gamemin;

import com.koombea.gamemin.blocks.ModBlock;
import com.koombea.gamemin.items.ModItem;
import com.koombea.gamemin.lib.Reference;
import com.koombea.gamemin.proxy.CommonProxy;
import com.koombea.gui.GuiHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class GameMin {
	@Instance(Reference.MODID)
	public static GameMin instance;
	
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModBlock.init();
		ModItem.init();
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	
	}
}
