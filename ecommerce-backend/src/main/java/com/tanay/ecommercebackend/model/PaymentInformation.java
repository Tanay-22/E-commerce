package com.tanay.ecommercebackend.model;


import jakarta.persistence.Column;

import java.time.LocalDate;

public class PaymentInformation
{
    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "cardr_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    private String cvv;
}
