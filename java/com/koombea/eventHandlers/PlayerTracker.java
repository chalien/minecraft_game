package com.koombea.eventHandlers;

import com.koombea.gamemin.GameMin;
import com.koombea.packetHandlers.StartLauncherPacket;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class PlayerTracker implements GameMinEventHandler{

	 @SubscribeEvent
	  public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	  {
		 EntityPlayer player = event.player;
		 
		 if ((player instanceof EntityPlayerMP)) {
			 GameMin.network.sendTo(new StartLauncherPacket((EntityPlayerMP)player), (EntityPlayerMP)player);
		 }
	  }
}
