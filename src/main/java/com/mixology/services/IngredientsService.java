package com.mixology.services;

import com.mixology.models.Ingredients;
import com.mixology.models.Recipe;

import java.util.List;

public interface IngredientsService {

    public List<Ingredients> getAllIngredients();
    public Ingredients addIngredient(Ingredients i);
    public Recipe addRecipe(Recipe r);


}
