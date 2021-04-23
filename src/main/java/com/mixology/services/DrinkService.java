package com.mixology.services;

import com.mixology.models.Drink;
import com.mixology.models.Ingredients;
import com.mixology.models.Recipe;
import com.mixology.models.User;
import java.util.List;

public interface DrinkService {

    public List<Drink> getAllDrink();
    public Drink addDrink(Drink d);
    public Drink getDrinkById(int i);
    public Drink getDrinkByDrinkname(String name);
    public List<Drink> getByUserId(User u);
    public List<Drink> getDrinkByIngredientsName(String name);
    public List<Ingredients> getIngredientsByDrinkId(int drinkId);
}
