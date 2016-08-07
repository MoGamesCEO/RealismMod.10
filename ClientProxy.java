package com.realism.mod.proxy;

import com.realism.mod.entity.EntityRealZombie;
import com.realism.mod.entity.EntitySkeletonKing;
import com.realism.mod.entity.ModelRealZombie;
import com.realism.mod.init.RMBlocks;
import com.realism.mod.init.RMFood;
import com.realism.mod.init.RMItems;
import com.realism.mod.init.TileEntity.TileEntityCrate;
import com.realism.mod.render.RenderRealZombie;
import com.realism.mod.render.RenderSkeletonKing;
import com.realism.mod.render.TileEntityCrateRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent preevent) {
		super.preInit(preevent);
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonKing.class, new IRenderFactory()
		{
		    @Override
		    public Render<? super EntitySkeletonKing> createRenderFor(RenderManager manager)
		    {
		        return new RenderSkeletonKing(manager);
		    }
		}); 
	}

	public void Init(FMLInitializationEvent event) {
		super.Init(event);

		RMItems.registerRender();
		RMBlocks.registerRender();
		RMFood.registerRender();
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrate.class, new TileEntityCrateRenderer());


}
@Override
public void reisterItemSided(Item item) {

	}

public void postInit(FMLPostInitializationEvent postevent) {
	super.postInit(postevent);
}
}
	
