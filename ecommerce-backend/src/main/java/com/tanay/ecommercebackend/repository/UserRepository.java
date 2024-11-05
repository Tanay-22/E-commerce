package com.tanay.ecommercebackend.repository;

import com.tanay.ecommercebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findByEmail(String email);
}
