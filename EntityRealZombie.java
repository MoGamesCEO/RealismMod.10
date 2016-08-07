package com.realism.mod.entity;

import com.realism.mod.init.RMItems;
import com.realism.mod.init.RMSounds;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRealZombie extends EntityMob{

	public EntityRealZombie(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAISwimming(this));		
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));


        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityWolf.class, 50.0F, 2.0d, 5.0d));
		this.tasks.addTask(0, new EntityAIWander(this, 1.0d));
		this.tasks.addTask(4, new EntityAIBreakDoor(this));
	
		

		
		this.experienceValue = 50;
	}

	public boolean isAIEnabled(){
		return true;
	}
	
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.5D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);

	}
	
	protected void addRandomArmor(){
		this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(RMItems.RedDiamondSword));
		this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(RMItems.RedDiamondHelmet));

	}
	
	protected Item getDroppedItem(){
		return Items.SHIELD;
		
	}
	
	
	protected void dropRareDrop(int Item){
		this.dropItem(RMItems.RedDiamondSword, 1);
	}
	
	protected SoundEvent getAmbientSound(){
		return RMSounds.RealZombieAmbientSound;
		
	}
	protected SoundEvent getHurtSound(){
		return SoundEvents.ENTITY_ZOMBIE_HURT;
		
	}
	protected SoundEvent getDeathSound(){
		return SoundEvents.ENTITY_ZOMBIE_DEATH;
		
	}
}
