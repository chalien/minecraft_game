package con.koombea.init;

import con.koombea.GameMain;
import con.koombea.network.messages.MessageSelectClass;
import con.koombea.network.messages.MessageSaveSelectedClass;
import cpw.mods.fml.relauncher.Side;

public class MessagesRegister {
	
	static int id = 0;
	
	public static void init(){
		GameMain.wrapper.registerMessage(MessageSelectClass.Handler.class, MessageSelectClass.class, 1, Side.CLIENT);
		GameMain.wrapper.registerMessage(MessageSaveSelectedClass.Handler.class, MessageSaveSelectedClass.class, 0, Side.SERVER);
	}

}
