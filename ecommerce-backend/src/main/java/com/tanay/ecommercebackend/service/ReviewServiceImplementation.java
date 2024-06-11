package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.model.Product;
import com.tanay.ecommercebackend.model.Review;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.repository.ProductRepository;
import com.tanay.ecommercebackend.repository.ReviewRepository;
import com.tanay.ecommercebackend.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService
{
    private ReviewRepository reviewRepository;
    private ProductService productService;
    private ProductRepository productRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository, ProductService productService, ProductRepository productRepository)
    {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException
    {
        Product product = productService.findProductById(req.getProductId());

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews(Long productId)
    {
        return reviewRepository.getAllProductsReview(productId);
    }
}
