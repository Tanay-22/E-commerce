package com.tanay.ecommercebackend.request;

import com.tanay.ecommercebackend.model.SizeStock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddItemRequest
{
    private Long productId;
    private SizeStock size;
}
