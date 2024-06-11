package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.model.Review;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.request.ReviewRequest;

import java.util.List;

public interface ReviewService
{
    public Review createReview(ReviewRequest req, User user) throws ProductException;

    public List<Review> getAllReviews(Long productId);
}
