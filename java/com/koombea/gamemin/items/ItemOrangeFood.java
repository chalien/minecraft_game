package com.koombea.gamemin.items;

import com.koombea.gamemin.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemOrangeFood extends ItemFood {
	private String name = "itemOrangeFood";

	public ItemOrangeFood(int heal, float saturation, boolean wolfMeat) {
		super(heal, saturation, wolfMeat);
		setTextureName(Reference.MODID + ":" + name);
		setUnlocalizedName(Reference.addPrefix(name));
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabFood);
	}
}
