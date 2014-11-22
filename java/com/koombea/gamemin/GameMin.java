package com.koombea.gamemin;

import com.koombea.eventHandlers.EventRegister;
import com.koombea.eventHandlers.PlayerTracker;
import com.koombea.gamemin.blocks.ModBlock;
import com.koombea.gamemin.items.ModItem;
import com.koombea.gamemin.lib.Reference;
import com.koombea.gamemin.proxy.CommonProxy;
import com.koombea.gui.GuiHandler;
import com.koombea.packetHandlers.PackeRegister;
import com.koombea.packetHandlers.StartLauncherPacket;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class GameMin {
	@Instance(Reference.MODID)
	public static GameMin instance;
	public static SimpleNetworkWrapper network;
	
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModBlock.init();
		ModItem.init();
		createNetworkWrapper();
		//help to create all the messages
		PackeRegister.init();
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		SubscribeGuiHandler();
		EventRegister.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	
	}
	
	public void createNetworkWrapper()
	{
		//help us to manage messages between server and client
		this.network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
	}
	
	public void SubscribeGuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());
	}
}
