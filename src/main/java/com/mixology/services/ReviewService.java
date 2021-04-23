package com.mixology.services;

import com.mixology.models.Review;

import java.util.List;

public interface ReviewService {

    public Review addReview(Review r);
    public List<Review> getReviewByDrinkId(int drinkId);
    public List<Review> getReviewByUserId(int userId);
}
