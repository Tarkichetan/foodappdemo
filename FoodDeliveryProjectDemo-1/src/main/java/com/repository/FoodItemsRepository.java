package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.FoodItems;

public interface FoodItemsRepository extends JpaRepository<FoodItems, Integer> {

}
