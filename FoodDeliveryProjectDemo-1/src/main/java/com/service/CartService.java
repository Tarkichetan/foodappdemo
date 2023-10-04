package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.entity.Cart;
import com.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(int cartId) {
        return cartRepository.findById(cartId);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(int cartId, Cart updatedCart) {
        if (!cartRepository.existsById(cartId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found");
        }
        updatedCart.setCartId(cartId);
        return cartRepository.save(updatedCart);
    }

    public void deleteCart(int cartId) {
        cartRepository.deleteById(cartId);
    }
}
