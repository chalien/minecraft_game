package com.koombea.eventHandlers;

import com.koombea.gamemin.GameMin;
import com.koombea.gui.GUIs;
import com.koombea.gui.GuiSmasher;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;


public class OnBoardLauncher {
	
	
	@SubscribeEvent
	public void onItemPickup(EntityJoinWorldEvent event)
	{
		if(event.world.isRemote && event.entity instanceof EntityPlayer)
		{
			System.out.println("HOLAAAAAA");
	
			EntityPlayer player = (EntityPlayer) event.entity;
			System.out.println(player.getDisplayName());
			System.out.println(player);
			System.out.println(event.world);
			System.out.println(player.worldObj);
			
            player.openGui(GameMin.instance, GUIs.SMASHER.ordinal(), player.worldObj, (int) player.posX , (int) player.posY , (int) player.posZ );
			
		}
		
	}
}
