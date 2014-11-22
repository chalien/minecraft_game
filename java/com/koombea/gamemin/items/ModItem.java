package com.koombea.gamemin.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemBow;

public class ModItem {
	public static Item orangeItem;
	public static ItemBow standardBow;
	public static ItemFood itemOrangeFood;
	public static Item itemBlasterBall;
	
	
	public static void init()
	{
		orangeItem = new ItemOrange();
		standardBow = new StandardBow();
		itemBlasterBall = new ItemBlasterBall();
		itemOrangeFood = new ItemOrangeFood(4, 0.3f, false); //food points max:20, saturation , wolfmeat (raw beef) 
	}
}	
