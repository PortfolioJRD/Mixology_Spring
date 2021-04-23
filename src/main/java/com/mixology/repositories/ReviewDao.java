package com.mixology.repositories;

import com.mixology.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mixology.models.Review;
import java.util.List;

public interface ReviewDao extends JpaRepository<Review, Integer>{
    public List<Review> getReviewByDrinkId(int id);
    public List<Review> getReviewByUserId(int id);
}