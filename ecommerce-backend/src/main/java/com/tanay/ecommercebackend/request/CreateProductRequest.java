package com.tanay.ecommercebackend.request;

import com.tanay.ecommercebackend.model.SizeStock;

import java.util.HashSet;
import java.util.Set;

public class CreateProductRequest
{
    private String title;

    private String description;

    private int price;

    private int discountedPrice;

    private int discountPercentage;

    private int quantity;

    private String brand;

    private String color;

    private Set<SizeStock> sizeStock = new HashSet<SizeStock>();

    private String imgUrl;

    private String topLevelCategory;
    private String secondLevelCategory;
    private String thirdLevelCategory;

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getDiscountedPrice()
    {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice)
    {
        this.discountedPrice = discountedPrice;
    }

    public int getDiscountPercentage()
    {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage)
    {
        this.discountPercentage = discountPercentage;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Set<SizeStock> getSize()
    {
        return sizeStock;
    }

    public void setSize(Set<SizeStock> sizeStock)
    {
        this.sizeStock = sizeStock;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getTopLevelCategory()
    {
        return topLevelCategory;
    }

    public void setTopLevelCategory(String topLevelCategory)
    {
        this.topLevelCategory = topLevelCategory;
    }

    public String getSecondLevelCategory()
    {
        return secondLevelCategory;
    }

    public void setSecondLevelCategory(String secondLevelCategory)
    {
        this.secondLevelCategory = secondLevelCategory;
    }

    public String getThirdLevelCategory()
    {
        return thirdLevelCategory;
    }

    public void setThirdLevelCategory(String thirdLevelCategory)
    {
        this.thirdLevelCategory = thirdLevelCategory;
    }
}
