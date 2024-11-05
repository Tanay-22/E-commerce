package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.CartItemException;
import com.tanay.ecommercebackend.exception.UserException;
import com.tanay.ecommercebackend.model.Cart;
import com.tanay.ecommercebackend.model.CartItem;
import com.tanay.ecommercebackend.model.Product;
import com.tanay.ecommercebackend.model.SizeStock;

public interface CartItemService
{
    CartItem createCartItem(CartItem cartItem);

    CartItem updateCartItem(Long userId, Long id, CartItem cartItem)
            throws CartItemException, UserException;

    CartItem isCartItemExist(Cart cart, Product product, SizeStock size, Long userId);

    void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

    CartItem findCartItemById(Long cartItemId) throws CartItemException;

}
