/*******************************************************************************
 * AbyssalCraft
 * Copyright (c) 2012 - 2018 Shinoow.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Contributors:
 *     Shinoow -  implementation
 ******************************************************************************/
package com.shinoow.abyssalcraft.lib.util;

import java.util.Map;

import com.google.common.collect.Maps;
import com.shinoow.abyssalcraft.api.APIUtils;
import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.api.ritual.NecronomiconRitual;
import com.shinoow.abyssalcraft.api.ritual.RitualRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

/**
 * Utility class used for assembling Ritual grounds.
 * @author shinoow
 *
 */
public class RitualUtil {

	private static Map<Block, Integer> ritualBlocks = Maps.newHashMap();
	private static Map<Block, Integer> altarMeta = Maps.newHashMap();

	public static void addBlocks(){
		ritualBlocks.put(Blocks.COBBLESTONE, 0);
		ritualBlocks.put(ACBlocks.darkstone_cobblestone, 0);
		ritualBlocks.put(ACBlocks.abyssal_cobblestone, 1);
		ritualBlocks.put(ACBlocks.coralium_cobblestone, 1);
		ritualBlocks.put(ACBlocks.dreadstone_cobblestone, 2);
		ritualBlocks.put(ACBlocks.abyssalnite_cobblestone, 2);
		ritualBlocks.put(ACBlocks.ethaxium_brick, 3);
		ritualBlocks.put(ACBlocks.dark_ethaxium_brick, 3);

		altarMeta.put(Blocks.COBBLESTONE, 0);
		altarMeta.put(ACBlocks.darkstone_cobblestone, 1);
		altarMeta.put(ACBlocks.abyssal_cobblestone, 2);
		altarMeta.put(ACBlocks.coralium_cobblestone, 3);
		altarMeta.put(ACBlocks.dreadstone_cobblestone, 4);
		altarMeta.put(ACBlocks.abyssalnite_cobblestone, 5);
		altarMeta.put(ACBlocks.ethaxium_brick, 6);
		altarMeta.put(ACBlocks.dark_ethaxium_brick, 7);
	}

	/**
	 * Checks if an altar can be created
	 * @param world World object
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param z Z coordinate
	 * @param bookType Level of the current Necronomicon held
	 * @return True if a Ritual Altar can be constructed, otherwise false
	 */
	public static boolean tryAltar(World world, BlockPos pos, int bookType){
		IBlockState ritualBlock = world.getBlockState(pos);
		int x = 0;
		int y = 0;
		int z = 0;
		if(ritualBlock != null && ritualBlocks.containsKey(ritualBlock.getBlock()))
			if(bookType >= ritualBlocks.get(ritualBlock.getBlock()))
				if(world.getBlockState(pos.add(x -3, y, z)) == ritualBlock &&
				world.getBlockState(pos.add(x, y, z -3)) == ritualBlock &&
				world.getBlockState(pos.add(x + 3, y, z)) == ritualBlock &&
				world.getBlockState(pos.add(x, y, z + 3)) == ritualBlock &&
				world.getBlockState(pos.add(x -2, y,z + 2)) == ritualBlock &&
				world.getBlockState(pos.add(x -2, y, z -2)) == ritualBlock &&
				world.getBlockState(pos.add(x + 2, y, z + 2)) == ritualBlock &&
				world.getBlockState(pos.add(x + 2, y, z -2)) == ritualBlock)
					if(!world.isBlockFullCube(pos.add(x -3, y, z -1)) && !world.isBlockFullCube(pos.add(x -3, y, z + 1)) &&
							!world.isBlockFullCube(pos.add(x -4, y, z)) && !world.isBlockFullCube(pos.add(x -4, y, z -1)) &&
							!world.isBlockFullCube(pos.add(x -4, y, z + 1)) && !world.isBlockFullCube(pos.add(x -3, y, z -2)) &&
							!world.isBlockFullCube(pos.add(x -3, y, z -3)) && !world.isBlockFullCube(pos.add(x -2, y, z -3)) &&
							!world.isBlockFullCube(pos.add(x -1, y, z -3)) && !world.isBlockFullCube(pos.add(x -1, y, z -4)) &&
							!world.isBlockFullCube(pos.add(x, y, z -4)) && !world.isBlockFullCube(pos.add(x + 1, y, z -4)) &&
							!world.isBlockFullCube(pos.add(x + 1, y, z -3)) && !world.isBlockFullCube(pos.add(x + 2, y, z -3)) &&
							!world.isBlockFullCube(pos.add(x + 3, y, z -3)) && !world.isBlockFullCube(pos.add(x + 3, y, z -2)) &&
							!world.isBlockFullCube(pos.add(x + 3, y, z -1)) && !world.isBlockFullCube(pos.add(x + 4, y, z -1)) &&
							!world.isBlockFullCube(pos.add(x + 4, y, z)) && !world.isBlockFullCube(pos.add(x + 4, y, z + 1)) &&
							!world.isBlockFullCube(pos.add(x + 3, y, z + 1)) && !world.isBlockFullCube(pos.add(x + 3, y, z + 2)) &&
							!world.isBlockFullCube(pos.add(x + 3, y, z + 3)) && !world.isBlockFullCube(pos.add(x + 2, y, z + 3)) &&
							!world.isBlockFullCube(pos.add(x + 1, y, z + 3)) && !world.isBlockFullCube(pos.add(x + 1, y, z + 4)) &&
							!world.isBlockFullCube(pos.add(x, y, z + 4)) && !world.isBlockFullCube(pos.add(x -1, y, z + 4)) &&
							!world.isBlockFullCube(pos.add(x -1, y, z + 3)) && !world.isBlockFullCube(pos.add(x -2, y, z + 3)) &&
							!world.isBlockFullCube(pos.add(x-3, y, z + 3)) && !world.isBlockFullCube(pos.add(x -3, y, z + 2)) &&
							!world.isBlockFullCube(pos.add(x-1, y, z + 0)) && !world.isBlockFullCube(pos.add(x + 1, y, z)) &&
							!world.isBlockFullCube(pos.add(x, y, z -1)) && !world.isBlockFullCube(pos.add(x, y, z + 1)) &&
							!world.isBlockFullCube(pos.add(x-1, y, z + 1)) && !world.isBlockFullCube(pos.add(x -2, y, z)) &&
							!world.isBlockFullCube(pos.add(x-2, y, z)) && !world.isBlockFullCube(pos.add(x -2, y, z -1)) &&
							!world.isBlockFullCube(pos.add(x-1, y, z -1)) && !world.isBlockFullCube(pos.add(x -1, y, z -2)) &&
							!world.isBlockFullCube(pos.add(x, y, z -2)) && !world.isBlockFullCube(pos.add(x + 1, y, z -2)) &&
							!world.isBlockFullCube(pos.add(x + 1, y, z -1)) && !world.isBlockFullCube(pos.add(x + 2, y, z -1)) &&
							!world.isBlockFullCube(pos.add(x + 2, y, z)) && !world.isBlockFullCube(pos.add(x + 2, y, z + 1)) &&
							!world.isBlockFullCube(pos.add(x + 1, y, z + 1)) && !world.isBlockFullCube(pos.add(x + 1, y, z + 2)) &&
							!world.isBlockFullCube(pos.add(x, y, z + 2)) && !world.isBlockFullCube(pos.add(x -1, y, z + 2)))
						if(RitualRegistry.instance().sameBookType(world.provider.getDimension(), ritualBlocks.get(ritualBlock.getBlock()))){
							createAltar(world, pos, ritualBlock.getBlock());
							return true;
						}
		return false;
	}

	/**
	 * Creates the altar
	 * @param world World object
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param z Z coordinate
	 * @param block Ritual Block
	 */
	private static void createAltar(World world, BlockPos pos, Block block){
		if(altarMeta.containsKey(block)){
			int meta = altarMeta.get(block);
			int x = 0;
			int y = 0;
			int z = 0;

			world.destroyBlock(pos, false);
			world.destroyBlock(pos.add(x -3, y, z), false);
			world.destroyBlock(pos.add(x, y, z -3), false);
			world.destroyBlock(pos.add(x + 3, y, z), false);
			world.destroyBlock(pos.add(x, y, z + 3), false);
			world.destroyBlock(pos.add(x -2, y, z + 2), false);
			world.destroyBlock(pos.add(x -2, y, z -2), false);
			world.destroyBlock(pos.add(x + 2, y, z + 2), false);
			world.destroyBlock(pos.add(x + 2, y, z -2), false);
			world.setBlockState(pos, ACBlocks.ritual_altar.getStateFromMeta(meta), 2);
			world.setBlockState(pos.add(x -3, y, z), ACBlocks.ritual_pedestal.getStateFromMeta(meta), 2);
			world.setBlockState(pos.add(x, y, z -3), ACBlocks.ritual_pedestal.getStateFromMeta(meta), 2);
			world.setBlockState(pos.add(x + 3, y, z), ACBlocks.ritual_pedestal.getStateFromMeta(meta), 2);
			world.setBlockState(pos.add(x, y, z + 3), ACBlocks.ritual_pedestal.getStateFromMeta(meta), 2);
			world.setBlockState(pos.add(x -2, y, z + 2), ACBlocks.ritual_pedestal.getStateFromMeta(meta), 2);
			world.setBlockState(pos.add(x -2, y, z -2), ACBlocks.ritual_pedestal.getStateFromMeta(meta), 2);
			world.setBlockState(pos.add(x + 2, y, z + 2), ACBlocks.ritual_pedestal.getStateFromMeta(meta), 2);
			world.setBlockState(pos.add(x + 2, y, z -2), ACBlocks.ritual_pedestal.getStateFromMeta(meta), 2);
		}
	}

	public static void modifyRitualBookType(String name, int bookType){
		for(NecronomiconRitual r : RitualRegistry.instance().getRituals())
			if(r.getUnlocalizedName().substring("ac.ritual.".length()).equals(name)){
				ReflectionHelper.setPrivateValue(NecronomiconRitual.class, r, bookType, "bookType");
				break;
			}
	}

	public static void modifyRitualDimension(String name, int dimension){
		for(NecronomiconRitual r : RitualRegistry.instance().getRituals())
			if(r.getUnlocalizedName().substring("ac.ritual.".length()).equals(name)){
				ReflectionHelper.setPrivateValue(NecronomiconRitual.class, r, dimension, "dimension");
				break;
			}
	}

	public static void modifyRitualSacrificeRequirement(String name, boolean requiresSacrifice){
		for(NecronomiconRitual r : RitualRegistry.instance().getRituals())
			if(r.getUnlocalizedName().substring("ac.ritual.".length()).equals(name)){
				ReflectionHelper.setPrivateValue(NecronomiconRitual.class, r, requiresSacrifice, "requiresSacrifice");
				break;
			}
	}

	public static void modifyRitualEnergyRequirement(String name, float requiredEnergy){
		for(NecronomiconRitual r : RitualRegistry.instance().getRituals())
			if(r.getUnlocalizedName().substring("ac.ritual.".length()).equals(name)){
				ReflectionHelper.setPrivateValue(NecronomiconRitual.class, r, requiredEnergy, "requiredEnergy");
				break;
			}
	}

	public static void modifyRitualSacrifice(String name, Object sacrifice){
		for(NecronomiconRitual r : RitualRegistry.instance().getRituals())
			if(r.getUnlocalizedName().substring("ac.ritual.".length()).equals(name) && r.getSacrifice() != null){
				ReflectionHelper.setPrivateValue(NecronomiconRitual.class, r, sacrifice, "sacrifice");
				break;
			}
	}

	public static void modifyRitualNbtSensitivity(String name, boolean nbtSensitive){
		for(NecronomiconRitual r : RitualRegistry.instance().getRituals())
			if(r.getUnlocalizedName().substring("ac.ritual.".length()).equals(name)){
				ReflectionHelper.setPrivateValue(NecronomiconRitual.class, r, nbtSensitive, "nbtSensitive");
				break;
			}
	}

	public static void modifyRitualNbtSensitivitySacrifice(String name, boolean nbtSensitiveSacrifice){
		for(NecronomiconRitual r : RitualRegistry.instance().getRituals())
			if(r.getUnlocalizedName().substring("ac.ritual.".length()).equals(name)){
				ReflectionHelper.setPrivateValue(NecronomiconRitual.class, r, nbtSensitiveSacrifice, "nbtSensitiveSacrifice");
				break;
			}
	}

	public static void modifyRitualOfferings(String name, Object...offerings){
		for(NecronomiconRitual r : RitualRegistry.instance().getRituals())
			if(r.getUnlocalizedName().substring("ac.ritual.".length()).equals(name)){
				ReflectionHelper.setPrivateValue(NecronomiconRitual.class, r, offerings, "offerings");
				break;
			}
	}

	public static void modifyRitualReplaceOffering(String name, Object original, Object replace, boolean nbt){
		for(NecronomiconRitual r : RitualRegistry.instance().getRituals())
			if(r.getUnlocalizedName().substring("ac.ritual.".length()).equals(name)){
				Object[] offerings = new Object[r.getOfferings().length];
				for(int i = 0; i < offerings.length; i++)
					offerings[i] = APIUtils.areObjectsEqual(APIUtils.convertToStack(original), r.getOfferings()[i], nbt) ? replace : r.getOfferings()[i];
				ReflectionHelper.setPrivateValue(NecronomiconRitual.class, r, offerings, "offerings");
				break;
			}
	}
}
