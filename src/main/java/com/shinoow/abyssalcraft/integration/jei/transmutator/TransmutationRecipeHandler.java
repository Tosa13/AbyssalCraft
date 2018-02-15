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
package com.shinoow.abyssalcraft.integration.jei.transmutator;

import javax.annotation.Nonnull;

import com.shinoow.abyssalcraft.integration.jei.AbyssalCraftRecipeCategoryUid;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class TransmutationRecipeHandler implements IRecipeHandler<TransmutationRecipe> {

	@Override
	@Nonnull
	public Class<TransmutationRecipe> getRecipeClass() {
		return TransmutationRecipe.class;
	}

	@Override
	@Nonnull
	public IRecipeWrapper getRecipeWrapper(@Nonnull TransmutationRecipe recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull TransmutationRecipe recipe) {
		return recipe.getInputs().size() != 0 && recipe.getOutputs().size() > 0;
	}

	@Override
	public String getRecipeCategoryUid(TransmutationRecipe recipe) {

		return AbyssalCraftRecipeCategoryUid.TRANSMUTATION;
	}
}
