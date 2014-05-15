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
package com.shinoow.abyssalcraft.common.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

import com.shinoow.abyssalcraft.AbyssalCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderAbyss extends WorldProvider
{

	@Override
	public void setDimension (int dim) 
	{
		this.dimensionId = dim;
		super.setDimension(dim);
	}

	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderAbyss(worldObj, worldObj.getSeed(), true);
	}

	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(AbyssalCraft.Wastelands, 0.0F);
		this.isHellWorld= false;
		this.dimensionId = AbyssalCraft.dimension;
		this.hasNoSky = true;
	}

	public String getDimensionName() 
	{
		return "The Abyssal Wasteland";
	}

	public boolean canRespawnHere()
	{
		return false;
	}

	/**
	 * Creates the light to brightness table
	 */
	protected void generateLightBrightnessTable()
	{
		float f = 0.25F;

		for (int i = 0; i <= 15; ++i)
		{
			float f1 = 1.0F - (float)i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}
	@Override
	public boolean canDoRainSnowIce(Chunk chunk)
	{
		return false;
	}

	public boolean isSurfaceWorld()
	{
		return false;
	}
	/**
	 * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
	 */
	public float calculateCelestialAngle(long par1, float par3)
	{
		return 0.0F;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns array with sunrise/sunset colors
	 */
	public float[] calcSunriseSunsetColors(float par1, float par2)
	{
		return null;
	}

	@SideOnly(Side.CLIENT)
	public boolean isSkyColored()
	{
		return true;
	}
	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
		return this.worldObj.getWorldVec3Pool().getVecFromPool(0, 180, 50);
	}

	@SideOnly(Side.CLIENT)

	/**
	 * the y level at which clouds are rendered.
	 */
	public float getCloudHeight()
	{
		return 8.0F;
	}

	public String getSaveFolder()
	{
		return "The_Abyss";
	}

	public int getAverageGroundLevel()
	{
		return 50;
	}
}