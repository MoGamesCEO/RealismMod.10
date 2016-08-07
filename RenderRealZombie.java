package com.realism.mod.render;

import com.realism.mod.RMGlobal;

import com.realism.mod.entity.EntityRealZombie;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderRealZombie extends RenderLiving
{
    private static final ResourceLocation ZombieTexture = new ResourceLocation(RMGlobal.Mod_ID + ":" + "textures/models/ModelRealZombie.png");

    public RenderRealZombie(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn)
    {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }
    
    protected ResourceLocation getEntityTexture(EntityRealZombie entity)
    {
        return ZombieTexture;
    }
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityRealZombie)entity);
	}
}