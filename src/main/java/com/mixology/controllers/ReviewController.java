package com.mixology.controllers;

import com.mixology.models.Review;
import com.mixology.services.ReviewServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewServiceImplementation reviewService;

    public ReviewController(ReviewServiceImplementation reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping("/{drinkId}")
    public ResponseEntity<List<Review>> getReviewByDrinkId(@PathVariable int drinkId){
        return new ResponseEntity<List<Review>>(reviewService.getReviewByDrinkId(drinkId), HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<Review>> getReviewByUserId(@PathVariable int userId){
        return new ResponseEntity<List<Review>>(reviewService.getReviewByUserId(userId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review reviews){
        return new ResponseEntity<Review>(reviewService.addReview(reviews), HttpStatus.OK);
    }
}