package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.FoodItems;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.FoodItemsService;

@RestController
@RequestMapping("/api/fooditems")

public class FoodItemsController {
	
	@JsonIgnore
    @Autowired
    private FoodItemsService foodItemsService;

    @GetMapping("/getfood")
    public List<FoodItems> getAllFoodItems() {
        return foodItemsService.getAllFoodItems();
    }

    @GetMapping("/{foodItemId}")
    public Optional<FoodItems> getFoodItemById(@PathVariable int foodItemId) {
        return foodItemsService.getFoodItemById(foodItemId);
    }

    @PostMapping
    public FoodItems createFoodItem(@RequestBody FoodItems foodItem) {
        return foodItemsService.createFoodItem(foodItem);
    }

    @PutMapping("/{foodItemId}")
    public FoodItems updateFoodItem(@PathVariable int foodItemId, @RequestBody FoodItems updatedFoodItem) {
        return foodItemsService.updateFoodItem(foodItemId, updatedFoodItem);
    }

    @DeleteMapping("/{foodItemId}")
    public void deleteFoodItem(@PathVariable int foodItemId) {
        foodItemsService.deleteFoodItem(foodItemId);
    }
}
