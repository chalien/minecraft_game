package con.koombea.network.messages;

import con.koombea.GameMain;
import con.koombea.client.entityProperties.PlayerProperty;
import con.koombea.constant.GUIs;
import con.koombea.constant.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSelectClass implements IMessage{
 
	public void fromBytes(ByteBuf buf) {
		 
		
	}

 
	public void toBytes(ByteBuf buf) {
		 
		
	}
	
	public static class Handler implements IMessageHandler<MessageSelectClass, IMessage>
	{

		public IMessage onMessage(MessageSelectClass message, MessageContext ctx) {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			
			PlayerProperty playerProperty = PlayerProperty.get(player);
			System.out.println("TEST!!!!!!");
			System.out.println(playerProperty.selectedClass());
			if(playerProperty.selectedClass()==0){
				player.openGui(GameMain.instance, GUIs.SELECT_CLASS.ordinal(), player.worldObj, 0, 0, 0);
			}

			return null;
		}
		
	}
}
