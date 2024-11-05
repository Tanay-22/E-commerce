package com.tanay.ecommercebackend.controller;

import com.tanay.ecommercebackend.config.JwtProvider;
import com.tanay.ecommercebackend.exception.UserException;
import com.tanay.ecommercebackend.model.Cart;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.repository.UserRepository;
import com.tanay.ecommercebackend.request.CreateUserRequest;
import com.tanay.ecommercebackend.request.LoginRequest;
import com.tanay.ecommercebackend.response.AuthResponse;
import com.tanay.ecommercebackend.service.CartService;
import com.tanay.ecommercebackend.service.CustomUserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserServiceImplementation customUserService;
    private final CartService cartService;

    @Autowired
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,
                          JwtProvider jwtProvider, CustomUserServiceImplementation customUserService,
                          CartService cartService)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.customUserService = customUserService;
        this.cartService = cartService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody CreateUserRequest req)
            throws UserException
    {
        String email = req.getEmail();
        String password = req.getPassword();
        String firstName = req.getFirstName();
        String lastName = req.getLastName();

        User isEmailExist = userRepository.findByEmail(email);

        if(isEmailExist != null)
            throw new UserException("Email is already used with another account");

        User createdUser = new User();
        createdUser.setEmail(email);
        createdUser.setFirstName(firstName);
        createdUser.setLastName(lastName);
        createdUser.setPassword(passwordEncoder.encode(password));

        User savedUser = userRepository.save(createdUser);
        Cart cart = cartService.createCart(savedUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
                savedUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("SignUp Successful");

        return new ResponseEntity<  >(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest)
    {
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Authentication authentication = authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("SignIn Successful");

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    private Authentication authenticate(String username, String password)
    {
        UserDetails userDetails = customUserService.loadUserByUsername(username);

        if(userDetails == null)
            throw new BadCredentialsException("Invalid username");

        if(!passwordEncoder.matches(password, userDetails.getPassword()))
            throw new BadCredentialsException("Invalid password");

        return new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
    }
}
