package com.koombea.gamemin.blocks;

import com.koombea.gamemin.GameMin;
import com.koombea.gamemin.lib.Reference;
import com.koombea.gamemin.tileentities.TileEntitySmasher;
import com.koombea.gui.GUIs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Smasher extends Block implements ITileEntityProvider{
	
	public String name = "smasher";


	protected Smasher() {
		super(Material.rock);
		setBlockTextureName(Reference.MODID + ":" + name);
		setBlockName(Reference.addPrefix(name));//prefix only include the modname_xxx
		setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySmasher();
	}

	@Override
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ)
	{
		if(world.isRemote)
		{
			if(world.getTileEntity(x, y, z) != null)
			{
				player.openGui(GameMin.instance, GUIs.SMASHER.ordinal(), world, x, y, z);
				return true;
			}
			
		}
		return true;
	}
}
