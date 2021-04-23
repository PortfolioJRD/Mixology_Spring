package com.mixology.services;

import com.mixology.models.Drink;
import com.mixology.models.Ingredients;
import com.mixology.models.Recipe;
import com.mixology.models.User;
import com.mixology.repositories.DrinkDao;
import com.mixology.repositories.IngredientsDao;
import com.mixology.repositories.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrinkServiceImplementation implements DrinkService{

    private DrinkDao dd;
    private IngredientsDao ingD;
    private RecipeDao rd;

    @Autowired
    public DrinkServiceImplementation(DrinkDao dd, IngredientsDao ingD, RecipeDao rd) {
        this.dd = dd;
        this.ingD = ingD;
        this.rd = rd;
    }

    @Override
    public List<Drink> getAllDrink() {
        return dd.getAllDrink();
    }

    @Override
    public Drink addDrink(Drink d) {
        return dd.saveAndFlush(d);
    }

    @Override
    public Drink getDrinkById(int i) {
        return dd.getDrinkById(i);
    }

    @Override
    public Drink getDrinkByDrinkname(String name) {
        return dd.getDrinkByDrinkname(name);
    }

    @Override
    public List<Drink> getByUserId(User u) {
        return dd.getDrinkByUserId(u.getId());
    }

    @Override
    public List<Drink> getDrinkByIngredientsName(String name) {
        List<Recipe> recipes = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        int ingredientsId = ingD.getIngredientsByName(name).getId();

        rd.getRecipeByIngredientsId(ingredientsId).forEach(recipes::add);

        for (int i = 0; i < recipes.size(); i++) {
            drinks.add(recipes.get(i).getDrink());
        }
        return drinks;
    }

    @Override
    public List<Ingredients> getIngredientsByDrinkId(int drinkId) {
        return rd.getIngredientsByDrinkId(drinkId);
    }


}
