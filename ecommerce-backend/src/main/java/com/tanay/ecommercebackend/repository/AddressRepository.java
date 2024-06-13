package com.tanay.ecommercebackend.repository;

import com.tanay.ecommercebackend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>
{
}
