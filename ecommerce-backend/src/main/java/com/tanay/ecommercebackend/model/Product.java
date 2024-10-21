package com.tanay.ecommercebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private Double price;
    private Double discountedPrice;
    private Integer discountPercent;

    private Integer quantity;
    private String brand;
    private String color;

    @ElementCollection
    private Set<SizeStock> sizeStocks = new HashSet<>();
    private String imageUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> review = new ArrayList<>();
    private int numRatings;

    @ManyToOne
    private Category category;

    private LocalDateTime createdAt;
}
