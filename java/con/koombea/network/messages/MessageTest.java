package con.koombea.network.messages;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import con.koombea.GameMain;
import con.koombea.client.entityProperties.PlayerProperty;
import con.koombea.constant.GUIs;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageTest implements IMessage{

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	public static class Handler implements IMessageHandler<MessageTest, IMessage>
	{

		public IMessage onMessage(MessageTest message, MessageContext ctx) {
			System.out.println("TEST SERVER!!!!!");
			EntityPlayer player = ctx.getServerHandler().playerEntity;
 
			PlayerProperty playerProperty = PlayerProperty.get(player);
			
			
//			System.out.println(playerProperty.getSelectedClass());
//			GameMain.wrapper.sendTo(new MessageSelectClass(), (EntityPlayerMP) player);
			return null;
		}
		
	}
}
