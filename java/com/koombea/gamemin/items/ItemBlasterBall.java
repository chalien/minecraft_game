package com.koombea.gamemin.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.koombea.gamein.entity.EntityBlasterBall;
import com.koombea.gamemin.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemBlasterBall extends Item {

	private String name = "itemBlasterBall";
	
	public ItemBlasterBall() {
		setTextureName(Reference.MODID + ":" + name);
		setUnlocalizedName(Reference.addPrefix(name));
		GameRegistry.registerItem(this, name);
		
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		world.spawnEntityInWorld(new EntityBlasterBall(world, entityplayer));
	  
		return itemstack;
	}
}
