package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.OrderException;
import com.tanay.ecommercebackend.model.Address;
import com.tanay.ecommercebackend.model.Order;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService
{
    private CartRepository cartRepository;
    private CartService cartService;
    private ProductService productService;

    public OrderServiceImplementation(CartRepository cartRepository, CartService cartService, ProductService productService)
    {
        this.cartRepository = cartRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    @Override
    public Order createOrder(User user, Address shippingAddress)
    {
        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException
    {
        return null;
    }

    @Override
    public List<Order> usersOrderHistory(Long userId)
    {
        return List.of();
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException
    {
        return null;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException
    {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException
    {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException
    {
        return null;
    }

    @Override
    public Order canceledOrder(Long orderId) throws OrderException
    {
        return null;
    }

    @Override
    public List<Order> getAllOrders()
    {
        return List.of();
    }

    @Override
    public void deleteOrder(Long orderId) throws OrderException
    {

    }
}
