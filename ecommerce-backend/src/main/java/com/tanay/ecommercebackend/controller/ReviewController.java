package com.tanay.ecommercebackend.controller;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.exception.UserException;
import com.tanay.ecommercebackend.model.Review;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.request.ReviewRequest;
import com.tanay.ecommercebackend.service.ReviewService;
import com.tanay.ecommercebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController
{
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest req,
                                               @RequestHeader("Authorization") String jwt)
            throws UserException, ProductException
    {
        User user = userService.findUserProfileByJwt(jwt);
        Review review = reviewService.createReview(req, user);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductsReview(@PathVariable Long productId)
    {
        List<Review> reviews = reviewService.getAllReviews(productId);

        return new ResponseEntity<>(reviews, HttpStatus.ACCEPTED);
    }
}
