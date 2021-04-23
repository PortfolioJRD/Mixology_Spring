package com.mixology.repositories;

import com.mixology.models.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteDao extends JpaRepository<Favourite, Integer> {
    public List<Favourite> findByUserId(int userId);
}
