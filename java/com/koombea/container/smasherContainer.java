package com.koombea.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class smasherContainer extends Container{

	public smasherContainer(EntityPlayer player) {
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		 
		return true;
	}

}
