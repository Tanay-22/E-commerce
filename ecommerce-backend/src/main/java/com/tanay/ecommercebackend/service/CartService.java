package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.model.Cart;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.request.AddItemRequest;

public interface CartService
{
    Cart createCart(User user);

    String addCartItem(Long userId, AddItemRequest req) throws ProductException;

    Cart findUsercart(Long userId);
}
