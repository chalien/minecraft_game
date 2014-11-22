
package com.koombea.gamemin.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.koombea.gamein.entity.EntityBlasterBall;
import com.koombea.gamemin.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public class StandardBow extends ItemBow {
	
	private String name = "standardBow";
	
	public StandardBow() {
		setTextureName(Reference.MODID + ":" + name);
		setUnlocalizedName(Reference.addPrefix(name));
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("standardBow");	
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
	    if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(Items.redstone))
	    {
	        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        if (!par2World.isRemote)
	        {
	        	//par2World.spawnEntityInWorld(new EntitySnowball(par2World, par3EntityPlayer));
	            par2World.spawnEntityInWorld(new EntityBlasterBall(par2World, par3EntityPlayer));
	        }
	    }
	        return par1ItemStack;
	}
	
}
