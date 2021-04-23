package com.mixology.repositories;

import com.mixology.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DrinkDao extends JpaRepository<Drink, Integer> {

    public List<Drink> getAllDrink();
    public Drink getDrinkByDrinkname(String name);
    public List<Drink> getDrinkByUserId(int userId);
    public Drink getDrinkById(int drinkId);
}
