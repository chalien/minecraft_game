package con.koombea;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import con.koombea.constant.*;
import con.koombea.init.Blocks;
import con.koombea.init.EventRegister;
import con.koombea.init.ItemsInit;
import con.koombea.init.MessagesRegister;
import con.koombea.network.CommonProxy;
import con.koombea.network.GuiHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class GameMain {
	@Instance(Reference.MODID)
	public static GameMain instance;
	public static SimpleNetworkWrapper wrapper;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
 
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Blocks.init();
		ItemsInit.init();
		createNetworkWrapper();
		MessagesRegister.init();
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		SubscribeGuiHandler();
		EventRegister.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	
	}
	
	public void SubscribeGuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());
	}
	
	public void createNetworkWrapper()
	{
		this.wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
	}
}
