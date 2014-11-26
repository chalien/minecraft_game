package con.koombea.event;

 

import org.lwjgl.Sys;

import con.koombea.GameMain;
import con.koombea.client.entityProperties.PlayerProperty;
import con.koombea.network.messages.MessageSelectClass;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
			GameMain.wrapper.sendTo(new MessageSelectClass(), (EntityPlayerMP) player);
		}
	}
 
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityConstructing event)
	{	
		if (event.entity instanceof EntityPlayer && PlayerProperty.get((EntityPlayer) event.entity) == null)
		{
			PlayerProperty.register((EntityPlayer) event.entity);
			System.out.println("SIN CARGADO");
			System.out.println(event.entity.getClass());
			
		}
	
		if (event.entity instanceof EntityPlayer && PlayerProperty.get((EntityPlayer) event.entity) != null)
		{
			System.out.println("ALGUIEN ESTA CARGADO");
			System.out.println(event.entity.getClass());
		}
	}

}
