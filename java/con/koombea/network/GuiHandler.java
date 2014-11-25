package con.koombea.network;

import con.koombea.client.gui.GuiSelectClass;
import con.koombea.constant.GUIs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GUIs.SELECT_CLASS.ordinal()) return new GuiSelectClass(player, world, x, y, z);

		return null;
	}

}
