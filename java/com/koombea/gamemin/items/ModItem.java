package com.koombea.gamemin.items;

import net.minecraft.item.Item;

public class ModItem {
	public static Item orangeItem;
	
	public static void init()
	{
		orangeItem = new ItemOrange();
	}
}
