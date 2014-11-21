package com.koombea.gamemin.blocks;

import net.minecraft.block.Block;


public final class ModBlock {
	
	public static Block orangeBlock;
	public static Block smasher;
	
	public static void init()
	{
		orangeBlock = new OrangeBlock();
		smasher = new Smasher();
	}
	
}
