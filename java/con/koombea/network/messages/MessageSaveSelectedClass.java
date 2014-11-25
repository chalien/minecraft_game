package con.koombea.network.messages;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import con.koombea.GameMain;
import con.koombea.client.entityProperties.PlayerProperty;
import con.koombea.constant.GUIs;
import con.koombea.constant.PlayerClasses;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSaveSelectedClass implements IMessage{
	public NBTTagCompound option;
	
	public MessageSaveSelectedClass() {
	}
	
	public MessageSaveSelectedClass(NBTTagCompound compound) {
		this.option = compound;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.option = ByteBufUtils.readTag(buf);

	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, this.option);
	}

	public static class Handler implements IMessageHandler<MessageSaveSelectedClass, IMessage>
	{

		public IMessage onMessage(MessageSaveSelectedClass message, MessageContext ctx) {
			EntityPlayer player = ctx.getServerHandler().playerEntity;
			PlayerProperty playerProperty = PlayerProperty.get(player);
			playerProperty.setSelectedClass( message.option.getInteger("SelectedClass"));
			player.addChatMessage(new ChatComponentText(message.option.getString("ClassName") + " CLASS SELECTED"));
			return null;
		}
		
	}
}
