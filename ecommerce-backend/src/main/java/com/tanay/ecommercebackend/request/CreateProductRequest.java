package com.tanay.ecommercebackend.request;

import com.tanay.ecommercebackend.model.SizeStock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest
{
    private String title;
    private String description;
    private Double price;
    private Double discountedPrice;
    private Integer discountPercentage;
    private Integer quantity;
    private String brand;
    private String color;
    private String imgUrl;
    private Set<SizeStock> sizeStocks;
    private String topLevelCategory;
    private String secondLevelCategory;
    private String thirdLevelCategory;
}
