package com.koombea.gamemin.lib;

public class Reference {
	public static final String MODID = "koombeamod01";
	public static final String VERSION = "0.0.1";
	public static final String NAME = "Koombea Mod";
	
	public static String addPrefix(String name)
	{
		return (MODID + "_" + name).toString();
	}
	
}
