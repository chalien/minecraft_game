package com.koombea.gamein.entity;

import com.koombea.gamemin.lib.Reference;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;


public class EntityBlasterBall extends EntityThrowable
{
	String name = "entityBlasterBall";
	int explosionRadius = 2;
    public EntityBlasterBall(World par1World)
    {
    	
        super(par1World);
    }
    public EntityBlasterBall(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityBlasterBall(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if (par1MovingObjectPosition.entityHit != null)
        {
            byte b0 = 5;
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
        }
		
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);
		this.setDead();
	}

}