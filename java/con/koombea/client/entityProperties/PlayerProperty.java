package con.koombea.client.entityProperties;

import con.koombea.constant.PlayerClasses;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerProperty implements IExtendedEntityProperties{
	
	public final static String EXT_PROP_NAME = "PlayerProperty";
	private final EntityPlayer player;
	private int selectedClass;
	
	public PlayerProperty(EntityPlayer player) {
		this.player = player;
		selectedClass = 0;
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
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("SelectClass", this.selectedClass);
		compound.setTag(EXT_PROP_NAME, properties);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.selectedClass = properties.getInteger("SelectClass");
	}

	@Override
	public void init(Entity entity, World world) {
		// TODO Auto-generated method stub
		
	} 

}
