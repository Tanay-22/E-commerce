package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.UserException;
import com.tanay.ecommercebackend.model.User;


public interface UserService
{
    User findUserById(Long userId) throws UserException;

    User findUserProfileByJwt(String jwt) throws UserException;
}
