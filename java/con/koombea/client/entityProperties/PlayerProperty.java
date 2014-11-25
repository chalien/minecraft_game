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

    public PlayerProperty(EntityPlayer player) {
    	this.player = player;
		this.selectedClass = -1;
	}
    
	public void setSelectedClass(int indexSelectedClass)
	{	
		this.selectedClass = indexSelectedClass;
		
	}

	public int getSelectedClass()
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
		PlayerProperty playerProperty = PlayerProperty.get(this.player);
		compound.setInteger("SelectedClass", this.selectedClass); 
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound) {
		System.out.println(compound.getInteger("SelectedClass"));
		this.selectedClass = compound.getInteger("SelectedClass");
	}

	@Override
	public void init(Entity entity, World world) {
	} 

}
