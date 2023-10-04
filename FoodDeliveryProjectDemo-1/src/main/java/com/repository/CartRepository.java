package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
