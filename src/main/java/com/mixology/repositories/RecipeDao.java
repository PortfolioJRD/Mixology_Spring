package com.mixology.repositories;

import com.mixology.models.Ingredients;
import com.mixology.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecipeDao extends JpaRepository<Recipe, Ingredients>{
    public List<Recipe> getRecipeByIngredientsId(int ingId);
    public List<Ingredients> getIngredientsByDrinkId(int drinkId);

}