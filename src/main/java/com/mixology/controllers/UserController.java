package com.mixology.controllers;
import java.util.List;

import com.mixology.models.Drink;
import com.mixology.models.Favourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mixology.models.User;
import com.mixology.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping("/login/{username}/{password}")
    public ResponseEntity<User> getUsersByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        return new ResponseEntity<User>(us.getUsersByUsernameAndPassword(username, password), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User u) {
        return new ResponseEntity<User>(us.addUser(u), HttpStatus.CREATED);
    }

    @GetMapping("/favoriteDrinks/{userId}")
    public ResponseEntity<List<Drink>> getAllFavoriteDrinks(@PathVariable int userId){
        return new ResponseEntity<List<Drink>>(us.getAllFavoriteDrink(userId),HttpStatus.OK);
    }

    @PostMapping("/addFavorite")
    public ResponseEntity<Favourite> addFavouriteDrink(@RequestBody Favourite favorites) {
        return new ResponseEntity<Favourite>(us.addFavoriteDrink(favorites), HttpStatus.CREATED);
    }
}