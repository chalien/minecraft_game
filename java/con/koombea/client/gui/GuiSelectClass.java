package con.koombea.client.gui;

import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import con.koombea.GameMain;
import con.koombea.client.entityProperties.PlayerProperty;
import con.koombea.constant.PlayerClasses;
import con.koombea.constant.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiSelectClass extends GuiScreen{
	 
	private int x;
	private int y;
	private int z;
	private int xSize;
	private int ySize;
	private World world;
	private EntityPlayer player;
	private ResourceLocation backgroundimage =  new ResourceLocation(Reference.MODID.toLowerCase() + ":" + "textures/client/gui/GuiSelectClass.png");

	public GuiSelectClass(EntityPlayer player, World world, int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.xSize = 250;
		this.ySize = 250;
		this.world = world;
		this.player = player;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartialTick) {
		 //Draw background
		this.mc.getTextureManager().bindTexture(backgroundimage);
        int x = (this.width - xSize) / 2;
        int y = (this.height - ySize) / 2;
        

        drawTexturedModalRect(0, 0, 0, 0, width,  height);
		super.drawScreen(mouseX, mouseY, renderPartialTick);
	}
	
	@Override
	public void initGui() {
		int positionX = this.width / 2;
		int positionFinalX =  this.width / 4;
		int positionY = this.height / 2;
		int positionFinalY = this.height / 4;
	
		
		this.buttonList.add(new GuiButton(0,  positionX - positionFinalX, positionY - positionFinalY, 100,  20, PlayerClasses.getLabel(PlayerClasses.SABER)));
			
		this.buttonList.add(new GuiButton(0,  positionX + positionFinalX, positionY - positionFinalY, 100, 20, PlayerClasses.getLabel(PlayerClasses.VIKINGS)));
			
		this.buttonList.add(new GuiButton(0,  positionX - positionFinalX, positionY + positionFinalY, 100, 20, PlayerClasses.getLabel(PlayerClasses.WIZARD)));
		
		this.buttonList.add(new GuiButton(0,  positionX + positionFinalX, positionY + positionFinalY, 100, 20, PlayerClasses.getLabel(PlayerClasses.ARCHER)));
		
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0:
			System.out.println("CARGAR EL PROPERTY");
			 PlayerProperty playerProperty = PlayerProperty.get(this.player);
			 
			 Minecraft.getMinecraft().thePlayer.sendChatMessage("ELEGISTE "+ button.displayString);
			 System.out.println("AQUIII" + PlayerClasses.get(button.displayString).ordinal());
			 System.out.println(PlayerClasses.get(button.displayString));
			 
			
			 
			 System.out.println("SET VALUE");
			 playerProperty.selectClass( PlayerClasses.get(button.displayString) );
			 System.out.println("FIN SET VALUE");
			 
			 
			 Minecraft.getMinecraft().thePlayer.sendChatMessage("ELEGISTE "+ playerProperty.getSelectedClass());
			 this.mc.displayGuiScreen((GuiScreen)null);
			break;
		default:
		}
	}
	
}
