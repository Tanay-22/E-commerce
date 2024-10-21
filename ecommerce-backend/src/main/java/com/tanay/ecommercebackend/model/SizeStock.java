package com.tanay.ecommercebackend.model;

import com.tanay.ecommercebackend.domain.Size;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SizeStock
{
    private Size size;
    private Integer quantity;
}
