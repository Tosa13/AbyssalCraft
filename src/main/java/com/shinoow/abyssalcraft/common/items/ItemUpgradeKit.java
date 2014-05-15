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
package com.shinoow.abyssalcraft.common.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.shinoow.abyssalcraft.AbyssalCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUpgradeKit extends Item

{
	@SuppressWarnings("rawtypes")
	private static final Map type = new HashMap();

	/** The name of the record. */
	public final String typeName;
	public final String typeName2;

	@SuppressWarnings("unchecked")
	public ItemUpgradeKit(String par2Str, String par3Str)
	{
		super();
		this.typeName = par2Str;
		this.typeName2 = par3Str;
		this.maxStackSize = 16;
		this.setCreativeTab(AbyssalCraft.tabItems);
		type.put(par2Str, this);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add(this.getRecordTitle());
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Return the title for this record.
	 */
	public String getRecordTitle()
	{
		return this.typeName + " To " + this.typeName2;
	}

}
