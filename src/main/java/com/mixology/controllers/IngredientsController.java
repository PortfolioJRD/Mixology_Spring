package com.mixology.controllers;
import com.mixology.models.Ingredients;
import com.mixology.models.Recipe;
import com.mixology.services.IngredientsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    private IngredientsService is;

    @Autowired
    public IngredientsController(IngredientsService is) {
        this.is = is;
    }

    @GetMapping
    public ResponseEntity<List<Ingredients>> getAllIngredients(){
        return new ResponseEntity<List<Ingredients>>(is.getAllIngredients(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Ingredients> addIngredient(@RequestBody Ingredients i){
        return new ResponseEntity<Ingredients>(is.addIngredient(i), HttpStatus.OK);
    }

    @PostMapping("/recipe")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe r){
        return new ResponseEntity<Recipe>(is.addRecipe(r), HttpStatus.OK);
    }


}