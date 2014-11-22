package com.koombea.gamemin.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ModItem {
	public static Item orangeItem;
	public static ItemFood itemOrangeFood;
	
	public static void init()
	{
		orangeItem = new ItemOrange();
		itemOrangeFood = new ItemOrangeFood(4, 0.3f, false); //food points max:20, saturation , wolfmeat (raw beef) 
	}
}	
