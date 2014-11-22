package com.koombea.packetHandlers;

import com.koombea.gamemin.GameMin;

import cpw.mods.fml.relauncher.Side;

public class PackeRegister {

	static int id = 0;
	
	public static void init()
	{
		GameMin.network.registerMessage(StartLauncherPacket.Handler.class, StartLauncherPacket.class, id++, Side.CLIENT);
		
	}
}
