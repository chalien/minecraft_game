package com.koombea.gamemin.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.koombea.gamemin.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemOrange extends Item {

	private String name = "itemOrange";
	
	public ItemOrange() {
		setTextureName(Reference.MODID + ":" + name);
		setUnlocalizedName(Reference.addPrefix(name));
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
