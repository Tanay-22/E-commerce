package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.model.Category;
import com.tanay.ecommercebackend.model.Product;
import com.tanay.ecommercebackend.repository.CategoryRepository;
import com.tanay.ecommercebackend.repository.ProductRepository;
import com.tanay.ecommercebackend.request.CreateProductRequest;
import com.tanay.ecommercebackend.response.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(CreateProductRequest req) throws ProductException
    {
        throw new ProductException("Customers cannot create Products");
    }

    @Override
    public void deleteProduct(Long productId) throws ProductException
    {
        throw new ProductException("Customers cannot delete Products");
    }

    @Override
    public Product updateProduct(Long productId, Product req) throws ProductException
    {
        throw new ProductException("Customers cannot delete Products");
    }

    @Override
    public Product findProductById(Long id) throws ProductException
    {
        Optional<Product> opt = productRepository.findById(id);

        if(opt.isPresent())
            return opt.get();

        throw new ProductException("Product not found wit id - " + id);
    }

    @Override
    public List<Product> findProductByCategory(Category category)
    {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findAllProduct()
    {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice,
                                       Integer maxPrice, Integer minDiscount, String sort, String stock,
                                       Integer pageNumber, Integer pageSize)
    {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        List<Product> products = productRepository.filterProduct(category, minPrice, maxPrice, minDiscount, sort);

        if(!colors.isEmpty())
            products = products.stream().filter(
                    p -> colors.stream().anyMatch(
                            c -> c.equalsIgnoreCase(p.getColor())))
                    .collect(Collectors.toList());

        if(stock != null)
        {
            if(stock.equals("in_stock"))
                products = products.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
            else if (stock.equals("out_of_stock"))
                products = products.stream().filter(p -> p.getQuantity() < 1).collect(Collectors.toList());
        }

        int startIndex = (int)pageable.getOffset();
        int endIndex = Math.min(startIndex + pageable.getPageSize(), products.size());

        List<Product> pageContent = products.subList(startIndex, endIndex);

        return new PageImpl<>(pageContent, pageable, products.size());
    }
}
