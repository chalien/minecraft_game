package con.koombea.event;

 

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
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{	
		if (event.entity instanceof EntityPlayer && PlayerProperty.get((EntityPlayer) event.entity) == null)
		{
			System.out.println("REGISTRAR");
			PlayerProperty.register((EntityPlayer) event.entity);
		} 
	
	}

}
