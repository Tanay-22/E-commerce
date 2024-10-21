package com.tanay.ecommercebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    @ManyToOne
    private User user;

    private String mobile;
}
