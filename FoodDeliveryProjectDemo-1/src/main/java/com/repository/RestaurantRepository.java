package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
