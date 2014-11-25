package con.koombea.constant;

import java.util.ArrayList;

public class Reference {
	public static final String MODID = "koombeamod01";
	public static final String VERSION = "0.0.1";
	public static final String NAME = "Koombea Mod";
	public static final String CLIENT_PROXY_CLASS = "con.koombea.network.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.koombea.network.CommonProxy";
	    
	public static String addPrefix(String name)
	{
		return (MODID + "_" + name).toString();
	}
	
	public static String addPrefixAsset(String name)
	{
		return (MODID + ":" + name).toString();
	}

}
