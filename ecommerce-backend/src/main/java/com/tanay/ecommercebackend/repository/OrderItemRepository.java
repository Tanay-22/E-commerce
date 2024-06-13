package com.tanay.ecommercebackend.repository;

import com.tanay.ecommercebackend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{

}
