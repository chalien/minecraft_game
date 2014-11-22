package com.koombea.packetHandlers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.koombea.gamemin.GameMin;
import com.koombea.gui.GUIs;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;



public class StartLauncherPacket implements IMessage{

	private EntityPlayer player;
	
    public StartLauncherPacket()
    {
    }

    public StartLauncherPacket(EntityPlayer player)
    {
    	System.out.println("PASO POR ACA!!");
    	this.player = player;
    }

	public void fromBytes(ByteBuf buf)
	{
	
	}
	

	public void toBytes(ByteBuf buf)
	{
		
	}
	
	public static class Handler implements IMessageHandler<StartLauncherPacket, IMessage>
	{

		public IMessage onMessage(StartLauncherPacket message, MessageContext context) {
			EntityPlayer entityClientPlayerMP = Minecraft.getMinecraft().thePlayer;
			entityClientPlayerMP.openGui(GameMin.instance, GUIs.SMASHER.ordinal(), entityClientPlayerMP.worldObj, 0, 0, 0);
			return null;
		}
	
	}
}
