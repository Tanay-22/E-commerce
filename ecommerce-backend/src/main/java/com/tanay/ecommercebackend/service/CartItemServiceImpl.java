package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.CartItemException;
import com.tanay.ecommercebackend.exception.UserException;
import com.tanay.ecommercebackend.model.*;
import com.tanay.ecommercebackend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService
{
    private final CartItemRepository cartItemRepository;
    private final UserService userService;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, UserService userService)
    {
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
    }

    @Override
    public CartItem createCartItem(CartItem cartItem)
    {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice() * cartItem.getQuantity());

        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException
    {
        CartItem item = findCartItemById(id);
        User user = userService.findUserById(item.getUserId());

        if(user.getId().equals(userId))
        {
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getProduct().getPrice() * item.getQuantity());
            item.setDiscountedPrice(item.getProduct().getDiscountedPrice() * item.getQuantity());
        }
        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, SizeStock size, Long userId)
    {
        return cartItemRepository.isCartItemExist(cart, product, size, userId);
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException
    {
        CartItem cartItem = findCartItemById(cartItemId);
        User user = userService.findUserById(userId);

        User reqUser = userService.findUserById(userId);

        if(user.getId().equals(reqUser.getId()))
            cartItemRepository.deleteById(cartItemId);
        else
            throw new UserException("You can't remove another users items");
    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException
    {
        Optional<CartItem> opt = cartItemRepository.findById(cartItemId);

        if(opt.isPresent())
            return opt.get();
        else
            throw new CartItemException("CartItem not found with id: " + cartItemId);
    }
}
