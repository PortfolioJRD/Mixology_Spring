package com.mixology.services;

import com.mixology.models.Ingredients;
import com.mixology.models.Recipe;
import com.mixology.repositories.IngredientsDao;
import com.mixology.repositories.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsServiceImplementation implements IngredientsService{

    private RecipeDao rd;
    private IngredientsDao ingD;

    @Autowired
    public IngredientsServiceImplementation(RecipeDao rd, IngredientsDao ingD) {
        this.rd = rd;
        this.ingD = ingD;
    }

    @Override
    public List<Ingredients> getAllIngredients() {
        return ingD.getAllIngredients();
    }

    @Override
    public Ingredients addIngredient(Ingredients i) {
        return ingD.saveAndFlush(i);
    }

    @Override
    public Recipe addRecipe(Recipe r) {
        return rd.saveAndFlush(r);

    }

}
