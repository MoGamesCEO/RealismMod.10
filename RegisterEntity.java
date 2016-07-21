package com.realism.mod.entity;

import java.util.BitSet;

import com.realism.mod.Main;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class RegisterEntity {

	private static final RegisterEntity INSTANCE = new RegisterEntity();
	private BitSet availibleIndecies;
	
	public static RegisterEntity instance(){
		return INSTANCE;
	}
	
	private RegisterEntity(){
		availibleIndecies = new BitSet(256);
		availibleIndecies.set(1, 255);
		for(Object id : EntityList.ID_TO_CLASS.keySet()){
			availibleIndecies.clear((Integer)id);
		}
	}	
	
	public static int findGlobalUniqueEntity(){
		int res = instance().availibleIndecies.nextSetBit(0);
		if(res < 0){
			throw new RuntimeException("No more Entity indencies left");
		}
		return res;
		
	}
	
	public static void registerEntity(){
		createEntity(EntityRealZombie.class, "RealZombie", 0x007F0E, 0x12067C);
		createEntity(EntitySkeletonKing.class, "SkeletonKing", 0xA6A6A6, 0x000000);

		
		
	}
	
	public static void createEntity(Class entityClass, String entityname, int solidColor, int spotColor){
		
		int randomId = findGlobalUniqueEntity();
		EntityRegistry.registerModEntity(entityClass, entityname, randomId, Main.instance, 64, 1, true, solidColor, spotColor);
	}
	
}
