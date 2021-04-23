package com.mixology.services;

import com.mixology.models.Drink;
import com.mixology.models.Favourite;
import com.mixology.models.User;
import java.util.List;

public interface UserService {
    public User getUsersByUsernameAndPassword(String username, String password);
    public User addUser(User u);

    public List<Drink> getAllFavoriteDrink(int userId);
    public Favourite addFavoriteDrink(Favourite favorite);

}
