package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.model.Category;
import com.tanay.ecommercebackend.model.Product;
import com.tanay.ecommercebackend.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService
{
    Product createProduct(CreateProductRequest req) throws ProductException;

    void deleteProduct(Long productId) throws ProductException;

    Product updateProduct(Long productId, Product req) throws ProductException;

    Product findProductById(Long id) throws ProductException;

    List<Product> findProductByCategory(Category category) throws ProductException;

    Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes,
                                       Integer minPrice, Integer maxPrice, Integer minDiscount,
                                       String sort, String stock, Integer pageNumber,
                                       Integer pageSize);

    List<Product> findAllProduct();
}
