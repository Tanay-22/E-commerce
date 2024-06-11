package com.tanay.ecommercebackend.service;


import com.tanay.ecommercebackend.exception.OrderException;
import com.tanay.ecommercebackend.model.Address;
import com.tanay.ecommercebackend.model.Order;
import com.tanay.ecommercebackend.model.User;

import java.util.List;

public interface OrderService
{
     public Order createOrder(User user, Address shippingAddress);

     public Order findOrderById(Long orderId) throws OrderException;

    public List<Order> usersOrderHistory(Long userId);

    public Order placedOrder(Long orderId) throws OrderException;

    public Order confirmedOrder(Long orderId) throws OrderException;

    public Order shippedOrder(Long orderId) throws OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order canceledOrder(Long orderId) throws OrderException;

    public List<Order> getAllOrders();

    public void deleteOrder(Long orderId) throws OrderException;

}
