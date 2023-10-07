package com.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.advices.CartException;
import com.advices.CustomerException;
import com.advices.RestaurantException;
import com.entity.Cart;
import com.entity.Customer;
import com.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

 /*   public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(int cartId) {
       return cartRepository.findById(cartId);
    }       */

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

  /*  public void deleteCart(int cartId) {
        cartRepository.deleteById(cartId);
    }     */
    
    
    
    public List<Cart> getAllCarts() throws Throwable{
		List<Cart> carts = cartRepository.findAll();  
	    if (carts.isEmpty()) {
	        throw new CartException("No Carts found");
	    }
	    else {
	    return carts;
	}
	}
    
    
    public Optional<Cart> getCartById(int cartId) throws Throwable{
    	Optional<Cart> carts = cartRepository.findById(cartId);
		if(!carts.isEmpty()) {
		return carts;
	}
		else {
			throw new CartException("customer with "+ cartId +" Not Found");
		}
	}
    
    public Optional<Cart> deleteCart(int cartId) throws Throwable{
    	Optional<Cart> carts = cartRepository.findById(cartId);
		if(!carts.isEmpty()) {
		return carts;
	}
		else {
			throw new CartException("customer with "+ cartId +" Not Found");
		}
	}
    
    
}
