package com.realism.mod.proxy;

import com.realism.mod.Achievements.AchievementList;
import com.realism.mod.entity.EntitySkeletonKing;
import com.realism.mod.init.RMBlocks;
import com.realism.mod.init.RMFood;
import com.realism.mod.init.RMItems;
import com.realism.mod.init.Smelting.RMSmelting;
import com.realism.mod.init.TileEntity.TileEntityCrate;
import com.realism.mod.render.TileEntityCrateRenderer;
import com.realism.mod.world.RMWorldGen;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preevent) {

		RMItems.init();
		RMBlocks.init();
		RMFood.init();
		RMSmelting.initSmelting();
		AchievementList.MainRegistry();
		GameRegistry.registerWorldGenerator(new RMWorldGen(), 0);

	}

	public void Init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent postevent) {

	}

	public void reisterItemSided(Item item) {

	}

	public Render<EntitySkeletonKing> createRenderFor(RenderManager manager) {
		return null;
	}

}
