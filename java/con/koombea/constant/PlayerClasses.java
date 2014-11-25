package con.koombea.constant;

public enum PlayerClasses {
	SABER, 
	WIZARD, 
	ARCHER, 
	VIKINGS;
	
	public static String getLabel(PlayerClasses playerclass)
	{
		switch (playerclass) {
		case SABER:
			return "SABER";
		case WIZARD:
			return "WIZARD";
		case ARCHER:
			return "ARCHER";
		case VIKINGS:
			return "VIKINGS";
		}
		return null;
	}
	
	public static PlayerClasses get(String name)
	{
		if (name.equals("SABER")) return SABER;
		if (name.equals("WIZARD")) return WIZARD;
		if (name.equals("ARCHER")) return ARCHER;
		if (name.equals("VIKINGS")) return VIKINGS;
		
		return null; 
	}
}
