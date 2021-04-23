package com.mixology.repositories;

import com.mixology.models.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsDao extends JpaRepository<Ingredients, Integer> {
    public Ingredients getIngredientsByName(String name);
}
