/**AbyssalCraft
 *Copyright 2012-2014 Shinoow
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */
package com.shinoow.abyssalcraft.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.shinoow.abyssalcraft.client.model.entity.ModelDG;
import com.shinoow.abyssalcraft.common.entity.EntityDepthsghoul;


public class RenderDepthsghoul extends RenderLiving
{
	protected ModelDG model;

	private static ResourceLocation field_110865_p = new ResourceLocation("abyssalcraft:textures/model/depths_ghoul.png");
	private static final ResourceLocation field_110861_l = new ResourceLocation("abyssalcraft:textures/model/depths_ghoul_pete.png");
	private static final ResourceLocation field_110861_m = new ResourceLocation("abyssalcraft:textures/model/depths_ghoul_wilson.png");
	private static final ResourceLocation field_110861_n = new ResourceLocation("abyssalcraft:textures/model/depths_ghoul_orange.png");
	private static final ResourceLocation field_110861_o = new ResourceLocation("abyssalcraft:textures/model/depths_ghoul.png");

	public RenderDepthsghoul (ModelDG ModelDG, float f)
	{
		super(ModelDG, f);
		model = ((ModelDG)mainModel);
	}

	public void renderDephsghoul(EntityDepthsghoul entity, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(entity, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		renderDephsghoul((EntityDepthsghoul)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation func_110860_a(EntityDepthsghoul par1EntityLiving)
	{
		switch (par1EntityLiving.getGhoulType())
		{
		case 0:
			field_110865_p = field_110861_o;
			break;
		case 1:
			field_110865_p = field_110861_l;
			break;
		case 2:
			field_110865_p = field_110861_m;
			break;
		case 3:
			field_110865_p = field_110861_n;

		}
		return field_110865_p;
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		renderDephsghoul((EntityDepthsghoul)par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {

		return this.func_110860_a((EntityDepthsghoul)entity);
	}
}