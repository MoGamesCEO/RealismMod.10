package com.realism.mod.entity;

import com.realism.mod.init.RMItems;
import com.realism.mod.init.RMSounds;

import net.minecraft.world.BossInfo;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntitySkeletonKing extends EntityMob{


	public EntitySkeletonKing(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAISwimming(this));		
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(0, new EntityAIWander(this, 1.0d));		
		this.experienceValue = 300;
	}

	public boolean isAIEnabled(){
		return true;
	}
	
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(128.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);

	}
	
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(RMItems.RedDiamondSword));
    }
	
	protected Item getDroppedItem(){
		return RMItems.RedDiamondSword;
		
	}
	
	
	protected void dropRareDrop(int Item){
		this.dropItem(Items.NETHER_STAR, 1);
	}
	
	protected SoundEvent getAmbientSound(){
		return SoundEvents.ENTITY_SKELETON_AMBIENT;
		
	}
	protected SoundEvent getHurtSound(){
		return SoundEvents.ENTITY_SKELETON_HURT;
		
	}
	protected SoundEvent getDeathSound(){
		return SoundEvents.ENTITY_SKELETON_DEATH;
		
	}
}
