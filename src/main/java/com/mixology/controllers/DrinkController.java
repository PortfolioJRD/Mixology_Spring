package com.mixology.controllers;

import com.mixology.models.Drink;
import com.mixology.models.Ingredients;
import com.mixology.models.User;
import com.mixology.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    private DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return new ResponseEntity<List<Drink>>(drinkService.getAllDrink(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable int id){
        return new ResponseEntity<Drink>(drinkService.getDrinkById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Drink> addDrink(@RequestBody Drink d){
        return new ResponseEntity<Drink>(drinkService.addDrink(d), HttpStatus.OK);
    }

    @GetMapping("/drinkName/{name}")
    public ResponseEntity<Drink> getDrinksByName(@PathVariable String name){
        return new ResponseEntity<Drink>(drinkService.getDrinkByDrinkname(name), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Drink>> getByCreator(User u){
        return new ResponseEntity<List<Drink>>(drinkService.getByUserId(u), HttpStatus.OK);
    }

    @GetMapping("/ingredientName/{ingredientName}")
    public ResponseEntity<List<Drink>> getDrinksByIngredientName(@PathVariable String ingredientName){
        return new ResponseEntity<List<Drink>>(drinkService.getDrinkByIngredientsName(ingredientName), HttpStatus.OK);
    }

    @GetMapping("/ingredients/{drinkId}")
    public ResponseEntity<List<Ingredients>> getIngredientsByDrinkId(@PathVariable int drinkId){
        return new ResponseEntity<List<Ingredients>>(drinkService.getIngredientsByDrinkId(drinkId), HttpStatus.OK);
    }
}