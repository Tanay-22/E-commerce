package com.tanay.ecommercebackend.controller;

import com.tanay.ecommercebackend.exception.ProductException;
import com.tanay.ecommercebackend.exception.UserException;
import com.tanay.ecommercebackend.model.Cart;
import com.tanay.ecommercebackend.model.User;
import com.tanay.ecommercebackend.request.AddItemRequest;
import com.tanay.ecommercebackend.response.ApiResponse;
import com.tanay.ecommercebackend.service.CartService;
import com.tanay.ecommercebackend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@Tag(name = "Cart Management", description = "find user cart, add item to cart")
public class CartController
{
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    @Operation(description = "find cart by user id")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization")String jwt) throws UserException
    {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUsercart(user.getId());

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
    @Operation(description = "add item to cart")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req,
                                                     @RequestHeader("Authorization")String jwt)
        throws UserException, ProductException
    {
        User user = userService.findUserProfileByJwt(jwt);
        cartService.addCartItem(user.getId(), req);

        ApiResponse res = new ApiResponse();
        res.setMessage("item added to cart");
        res.setStatus(true);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
