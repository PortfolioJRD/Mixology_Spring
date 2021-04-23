package com.mixology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mixology.models.User;

public interface UserDao extends JpaRepository< User, Integer> {

    public User getByUsernameAndPassword(String username, String password);

}