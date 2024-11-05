package com.tanay.ecommercebackend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingRequest
{
    private Long productId;
    private Integer rating;
}
