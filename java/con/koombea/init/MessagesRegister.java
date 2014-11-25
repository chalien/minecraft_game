package con.koombea.init;

import con.koombea.GameMain;
import con.koombea.network.messages.MessageSelectClass;
import cpw.mods.fml.relauncher.Side;

public class MessagesRegister {
	
	static int id = 0;
	
	public static void init(){
		GameMain.wrapper.registerMessage(MessageSelectClass.Handler.class, MessageSelectClass.class, id++, Side.CLIENT);
	}

}
