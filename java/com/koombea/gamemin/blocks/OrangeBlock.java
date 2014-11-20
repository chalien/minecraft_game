package com.koombea.gamemin.blocks;

import com.koombea.gamemin.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class OrangeBlock extends Block {
	public String name = "orangeBlock";

	public OrangeBlock() {
		super(Material.rock);
		
		setBlockTextureName(Reference.MODID + ":" + name);
		setBlockName(Reference.addPrefix(name));//prefix only include the modname_xxx
		setCreativeTab(CreativeTabs.tabBlock);
		
		GameRegistry.registerBlock(this, name);
	}
 
}
