package con.koombea.event;

 

import con.koombea.GameMain;
import con.koombea.network.messages.MessageSelectClass;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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

}
