package com.mixology.services;

import com.mixology.models.Drink;
import com.mixology.models.Favourite;
import com.mixology.models.User;
import com.mixology.repositories.DrinkDao;
import com.mixology.repositories.FavouriteDao;
import com.mixology.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    private UserDao ud;
    private DrinkDao dd;
    private FavouriteDao fd;

    @Autowired
    public UserServiceImplementation(UserDao ud, DrinkDao dd, FavouriteDao fd) {
        this.ud = ud;
        this.dd = dd;
        this.fd = fd;
    }

    @Override
    public User getUsersByUsernameAndPassword(String username, String password) {
        return ud.getByUsernameAndPassword(username,password);
    }

    @Override
    public User addUser(User u) {
        return ud.saveAndFlush(u);
    }

    @Override
    public List<Drink> getAllFavoriteDrink(int userId) {
        List<Drink> drinkList = new ArrayList<>();
        List<Integer> drinkIdList = new ArrayList<>();
        List<Favourite> favList = fd.getByUserId(userId);

        for(int i =0;i< favList.size();i++){
            drinkIdList.add(favList.get(i).getDrink().getId());
        }

        for(int i = 0; i < drinkIdList.size(); i++) {
            drinkList.add(dd.getOne(drinkIdList.get(i))); //getOne() - returns a proxy without hitting the db lazily fetched. Can throw a EntityNotFoundException if it does not exist in db
        }
        return drinkList;
    }

    @Override
    public Favourite addFavoriteDrink(Favourite favorite) {

        return fd.saveAndFlush(favorite);
    }


}
