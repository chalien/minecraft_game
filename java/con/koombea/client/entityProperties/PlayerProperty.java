package con.koombea.client.entityProperties;

import scala.reflect.internal.Trees.Super;
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

	
	public void selectClass(PlayerClasses playerClass)
	{
		System.out.println("LLEGO HASTA EL SELECT CLASS");
		this.selectedClass = playerClass.ordinal();
		
	}

	public int getSelectedClass()
	{
		return this.selectedClass;
	}
	
	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(PlayerProperty.EXT_PROP_NAME, new PlayerProperty());
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
		System.out.println("LLEGO valor" + this.selectedClass);
		compound.setInteger("SelectedClass", 10);
	   
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound) {
		System.out.println("LLEGO AL LOAD");
		System.out.println(this.player.getDisplayName());
		

		this.selectedClass = compound.getInteger("SelectedClass");
		System.out.println("LLEGO valor" + this.selectedClass);
		System.out.println("LLEGO valor" + this.getSelectedClass());
	}

	@Override
	public void init(Entity entity, World world) {
        this.player = (EntityPlayer) entity;
        System.out.println("CARGA PLAYER ENTITY");
	} 

}
