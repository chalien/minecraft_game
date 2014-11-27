package con.koombea.event;

 

import org.lwjgl.Sys;

import com.sun.xml.internal.stream.Entity;

import con.koombea.GameMain;
import con.koombea.client.entityProperties.PlayerProperty;
import con.koombea.network.messages.MessageSelectClass;
import con.koombea.network.messages.MessageTest;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class PlayerTracker {
	
	@SubscribeEvent
	public void showGuiSelectionClass(PlayerEvent.PlayerLoggedInEvent event)
	{
		EntityPlayer player = event.player;
		
		if(player instanceof EntityPlayerMP)
		{
 
 
			PlayerProperty playerProperty = PlayerProperty.get(event.player);
			
			
			System.out.println(playerProperty.getSelectedClass());
//			GameMain.wrapper.sendTo(new MessageSelectClass(), (EntityPlayerMP) player);
			System.out.println("entro desde el Server");
			GameMain.wrapper.sendToServer(new MessageTest());
//			GameMain.wrapper.sendTo(new MessageSelectClass(), (EntityPlayerMP) player);
			
		}
	}
 
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityConstructing event)
	{	
		if ( event.entity instanceof EntityClientPlayerMP ) {
			System.out.println("entro desde el client");
//			GameMain.wrapper.sendToServer(new MessageTest());
		}

	}

}
