package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.model.Product;
import com.tanay.ecommercebackend.model.Rating;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.repository.RatingRepository;
import com.tanay.ecommercebackend.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImplementation implements RatingService
{
    private RatingRepository ratingRepository;
    private ProductService productService;

    public RatingServiceImplementation(RatingRepository ratingRepository, ProductService productService)
    {
        this.ratingRepository = ratingRepository;
        this.productService = productService;
    }

    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException
    {
        Product product = productService.findProductById(req.getProductId());
        Rating rating = new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRatings(Long productId)
    {
        return ratingRepository.getAllProductsRating(productId);
    }
}
