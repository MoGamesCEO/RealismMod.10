package com.realism.mod.render;

import com.realism.mod.RMGlobal;

import com.realism.mod.entity.EntitySkeletonKing;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderSkeletonKing extends RenderLiving
{
    private static final ResourceLocation SkeletonKingeTexture = new ResourceLocation(RMGlobal.Mod_ID + ":" + "textures/models/ModelSkeletonKing.png");

    public RenderSkeletonKing(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn)
    {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }
    
    protected ResourceLocation getEntityTexture(EntitySkeletonKing entity)
    {
        return SkeletonKingeTexture;
    }
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntitySkeletonKing)entity);
	}
}