package com.tanay.ecommercebackend.service;

import com.tanay.ecommercebackend.config.JwtProvider;
import com.tanay.ecommercebackend.exception.UserException;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider)
    {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public User findUserById(Long userId) throws UserException
    {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent())
            return user.get();

        throw new UserException("User not found with id : " + userId);
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException
    {
        String email = jwtProvider.getEmailFromToken(jwt);
        User user = userRepository.findByEmail(email);

        if(user != null)
            return user;

        throw new UserException("User not found with jwt token : " + jwt);
    }
}
