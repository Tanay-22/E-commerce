package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.model.OrderItem;
import com.tanay.ecommercebackend.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImplementation implements OrderItemService
{
    private OrderItemRepository orderItemRepository;

    public OrderItemServiceImplementation(OrderItemRepository orderItemRepository)
    {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem)
    {
        return orderItemRepository.save(orderItem);
    }
}
