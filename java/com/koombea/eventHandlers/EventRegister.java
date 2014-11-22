package com.koombea.eventHandlers;

import cpw.mods.fml.common.FMLCommonHandler;

public class EventRegister {

	public static void init()
	{
		addEventHandler( new PlayerTracker() );
	}
	
	public static void addEventHandler(GameMinEventHandler eventHandler)
	{
		FMLCommonHandler.instance().bus().register(new PlayerTracker());
	}
	
}
