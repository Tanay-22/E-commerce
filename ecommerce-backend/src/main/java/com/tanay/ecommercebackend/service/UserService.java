package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.exception.UserException;
import com.tanay.ecommercebackend.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService
{
    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(Long userId) throws UserException;

}
