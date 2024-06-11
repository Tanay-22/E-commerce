package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.model.Rating;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.request.RatingRequest;

import java.util.List;

public interface RatingService
{
    public Rating createRating(RatingRequest req, User user)throws ProductException;

    public List<Rating> getProductsRatings(Long productId);
}
