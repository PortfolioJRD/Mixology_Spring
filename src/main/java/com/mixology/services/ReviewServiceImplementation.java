package com.mixology.services;

import com.mixology.models.Review;
import com.mixology.repositories.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService{

    private ReviewDao rd;

    @Autowired
    public ReviewServiceImplementation(ReviewDao rd) {
        this.rd = rd;
    }


    @Override
    public Review addReview(Review r) {
        return rd.saveAndFlush(r);
    }

    @Override
    public List<Review> getReviewByDrinkId(int drinkId) {
        return rd.getReviewByDrinkId(drinkId);
    }

    @Override
    public List<Review> getReviewByUserId(int userId) {
        return rd.getReviewByUserId(userId);
    }
}
