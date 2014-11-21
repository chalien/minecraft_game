package com.koombea.gui;
import com.koombea.gamemin.lib.Reference;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiSmasher extends GuiScreen{
	private int x, y, z;
	private EntityPlayer player;
	private World world;
	private int xSize, ySize;
	private ResourceLocation backgroundimage = 
			new ResourceLocation(Reference.MODID.toLowerCase() + ":" + "textures/client/gui/GuiSmasher.png");

	public GuiSmasher(EntityPlayer player, World world, int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.xSize = 176;
		this.ySize = 214;
		this.world = world;
		this.player = player;
		System.out.println("EN GUI SMASHER");
		System.out.println(player.getDisplayName());

	}
	
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float renderPartialTicks) {
    	System.out.println("DRAW SCREEN");
        this.mc.getTextureManager().bindTexture(backgroundimage);
        int x = (this.width - xSize) / 2;
        int y = (this.height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize,  ySize);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
