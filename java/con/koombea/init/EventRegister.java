package con.koombea.init;

import con.koombea.event.PlayerTracker;
import cpw.mods.fml.common.FMLCommonHandler;

public class EventRegister {
	public static void init()
	{
		FMLCommonHandler.instance().bus().register(new PlayerTracker());
	}
	
}
