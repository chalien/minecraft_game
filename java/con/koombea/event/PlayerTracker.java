package con.koombea.event;

 

import org.lwjgl.Sys;

import com.sun.xml.internal.stream.Entity;

import con.koombea.GameMain;
import con.koombea.client.entityProperties.PlayerProperty;
import con.koombea.network.messages.MessageSelectClass;
import con.koombea.network.messages.MessageSaveSelectedClass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class PlayerTracker {
	
	@SubscribeEvent
	public void showGuiSelectionClass(PlayerEvent.PlayerLoggedInEvent event)
	{
		
		EntityPlayer player = event.player;

		if(!event.player.worldObj.isRemote && player instanceof EntityPlayerMP)
		{
 
			PlayerProperty playerProperty = PlayerProperty.get(event.player);
 
			if(playerProperty.getSelectedClass()==-1)
			{
				GameMain.wrapper.sendTo(new MessageSelectClass(), (EntityPlayerMP) player);
			}
			
		}
	}
 
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityConstructing event)
	{	
		if (event.entity instanceof EntityPlayer && PlayerProperty.get((EntityPlayer) event.entity) == null)
			PlayerProperty.register((EntityPlayer) event.entity);
	}

}
