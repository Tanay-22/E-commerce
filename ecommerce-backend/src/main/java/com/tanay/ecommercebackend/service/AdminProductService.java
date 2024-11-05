package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.model.Category;
import com.tanay.ecommercebackend.model.Product;
import com.tanay.ecommercebackend.repository.CategoryRepository;
import com.tanay.ecommercebackend.repository.ProductRepository;
import com.tanay.ecommercebackend.request.CreateProductRequest;
import com.tanay.ecommercebackend.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminProductService implements ProductService
{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public AdminProductService(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(CreateProductRequest req)
    {
        Category topLevel = categoryRepository.findByName(req.getTopLevelCategory());

        if(topLevel == null)
        {
            Category newTopLevel = new Category();
            newTopLevel.setName(req.getTopLevelCategory());
            newTopLevel.setLevel(1);

            topLevel = categoryRepository.save(newTopLevel);
        }

        Category secondLevel = categoryRepository.findByNameAndParent(req.getSecondLevelCategory(),
                topLevel.getName());

        if(secondLevel == null)
        {
            Category newSecondLevel = new Category();
            newSecondLevel.setName(req.getSecondLevelCategory());
            newSecondLevel.setParentCategory(topLevel);
            newSecondLevel.setLevel(2);

            secondLevel = categoryRepository.save(newSecondLevel);
        }
        Category thirdLevel = categoryRepository.findByNameAndParent(req.getThirdLevelCategory(),
                secondLevel.getName());

        if(thirdLevel == null)
        {
            Category newThirdLevel = new Category();
            newThirdLevel.setName(req.getThirdLevelCategory());
            newThirdLevel.setParentCategory(secondLevel);
            newThirdLevel.setLevel(3);

            thirdLevel = categoryRepository.save(newThirdLevel);
        }
        // can use @Builder here
        Product product = new Product();
        product.setTitle(req.getTitle());
        product.setColor(req.getColor());
        product.setDescription(req.getDescription());
        product.setDiscountedPrice(req.getDiscountedPrice());
        product.setDiscountPercent(req.getDiscountPercentage());
        product.setImageUrl(req.getImgUrl());
        product.setBrand(req.getBrand());
        product.setPrice(req.getPrice());
        product.setSizeStocks((req.getSizeStocks()));
        product.setQuantity(req.getQuantity());
        product.setCategory(thirdLevel);
        product.setCreatedAt(LocalDateTime.now());

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) throws ProductException
    {
        Product product = findProductById(productId);
        product.getSizeStocks().clear();
        productRepository.delete(product);

        ApiResponse res = new ApiResponse();
        res.setMessage("Product deleted successfully");
        res.setStatus(true);

    }

    @Override
    public Product updateProduct(Long productId, Product req) throws ProductException
    {
        Product product = findProductById(productId);

        if(req.getQuantity() != 0)
            product.setQuantity(req.getQuantity());
        return null;
    }

    @Override
    public Product findProductById(Long id) throws ProductException
    {
        return null;
    }

    @Override
    public List<Product> findProductByCategory(Category category) throws ProductException
    {
        return List.of();
    }

    @Override
    public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize)
    {
        return null;
    }

    @Override
    public List<Product> findAllProduct()
    {
        return List.of();
    }
}
