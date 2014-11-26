package con.koombea.client.entityProperties;

import con.koombea.constant.PlayerClasses;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerProperty implements IExtendedEntityProperties{
	
	public final static String EXT_PROP_NAME = "PlayerProperty";
	private  EntityPlayer player;
	private int selectedClass;
	
	public PlayerProperty(EntityPlayer player) {
		System.out.println("PASO POR AQUI");

		this.player = player;
	}
	
	public void selectClass(PlayerClasses playerClass)
	{
		System.out.println("LLEGO HASTA EL SELECT CLASS");
		this.selectedClass = playerClass.ordinal();
		
	}

	public  int selectedClass()
	{
		return this.selectedClass;
	}
	
	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(PlayerProperty.EXT_PROP_NAME, new PlayerProperty(player));
	}
	
	public static final PlayerProperty get(EntityPlayer player)
	{
		return (PlayerProperty) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		System.out.println("LLEGO AL SAVE");
		System.out.println(this.player.getDisplayName());
		PlayerProperty playerProperty = PlayerProperty.get(this.player);
		
		System.out.println("LLEGO valor" + playerProperty.selectedClass);
		compound.setInteger("selectedClass", playerProperty.selectedClass);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound) {
		System.out.println("LLEGO AL LOAD");
		System.out.println(this.player.getDisplayName());
		this.selectedClass = compound.getInteger("selectedClass");
		System.out.println("LLEGO valor" + this.selectedClass);
	}

	@Override
	public void init(Entity entity, World world) {
		this.selectedClass = 0;
	} 

}
