package com.shinoow.abyssalcraft.common.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;
import com.shinoow.abyssalcraft.common.util.EnumToolMaterialAC;

public class ItemAbyssalniteCSword extends ItemSword
{
	private float weaponDamage;
	private final EnumToolMaterialAC toolMaterial;
	public ItemAbyssalniteCSword(EnumToolMaterialAC abyssalniteC)
	{
		super(ToolMaterial.valueOf("ABYSSALNITE_C"));
		toolMaterial = abyssalniteC;
		maxStackSize = 1;
		setMaxDamage(abyssalniteC.getMaxUses());
		weaponDamage = 4.0F + abyssalniteC.getDamageVsEntity();
	}
	/**
	 * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
	 * sword
	 */
	public float func_150893_a(ItemStack par1ItemStack, Block par2Block)
	{
		return par2Block != Blocks.web ? 1.5F : 15F;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B)
	{
		l.add("This sword applies fire and");
		l.add("potion effects on hit");
	}
	
	/**
	 * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
	 * the damage on the stack.
	 */
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		par1ItemStack.damageItem(10, par3EntityLivingBase);
		par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 3));
		par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 1));
		par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
		par2EntityLivingBase.setFire(4);
		return true;
	}
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
	{
		if ((double)par3.getBlockHardness(par2World, par4, par5, par6) != 0.0D)
		{
			par1ItemStack.damageItem(1, par7EntityLivingBase);
		}

		return true;
	}
	/**
	 * Returns the damage against a given entity.
	 */
	 public float func_82803_g()
	 {
		 return this.toolMaterial.getDamageVsEntity();
	 }
	 /**
	  * Returns True is the item is renderer in full 3D when hold.
	  */
	 public boolean isFull3D()
	 {
		 return true;
	 }
	 /**
	  * returns the action that specifies what animation to play when the items is being used
	  */
	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	 {
		 return EnumAction.block;
	 }
	 /**
	  * How long it takes to use or consume an item
	  */
	 public int getMaxItemUseDuration(ItemStack par1ItemStack)
	 {
		 return 0x11940;
	 }
	 /**
	  * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	  */
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	 {
		 par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
		 return par1ItemStack;
	 }
	 /**
	  * Returns if the item (tool) can harvest results from the block type.
	  */
	 public boolean func_150897_b(Block par1Block)
	 {
		 return par1Block == Blocks.web;
	 }
	 /**
	  * Return the enchantability factor of the item, most of the time is based on material.
	  */
	 public int getItemEnchantability()
	 {
		 return toolMaterial.getEnchantability();
	 }

	 public String getToolMaterialName()
	 {
		 return this.toolMaterial.toString();
	 }

	 /**
	  * Return whether this item is repairable in an anvil.
	  */
	 public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	 {
		 return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	 }

	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 public Multimap getItemAttributeModifiers()
	 {
		 Multimap multimap = super.getItemAttributeModifiers();
		 multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
		 return multimap;
	 }

}