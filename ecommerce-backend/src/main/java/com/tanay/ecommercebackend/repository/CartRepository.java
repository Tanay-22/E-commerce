package com.tanay.ecommercebackend.repository;

import com.tanay.ecommercebackend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Long>
{
    @Query("select c from Cart c " +
            "where c.user.id = :userId")
    public Cart findByUserId(@Param("userId") Long userId);
}
