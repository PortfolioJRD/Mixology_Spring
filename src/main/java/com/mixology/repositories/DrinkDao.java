package com.mixology.repositories;

import com.mixology.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DrinkDao extends JpaRepository<Drink, Integer> {

    public Drink findDrinkByDrinkname(String name);
    public Drink findDrinkByDrinkPercent(double percent);
    public List<Drink> findDrinkByUserId(int userId);
}
