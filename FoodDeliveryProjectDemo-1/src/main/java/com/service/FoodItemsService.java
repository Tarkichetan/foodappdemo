package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.entity.FoodItems;
import com.repository.FoodItemsRepository;

@Service
public class FoodItemsService {

    @Autowired
    private FoodItemsRepository foodItemsRepository;

    public List<FoodItems> getAllFoodItems() {
        return foodItemsRepository.findAll();
    }

    public Optional<FoodItems> getFoodItemById(int foodItemId) {
        return foodItemsRepository.findById(foodItemId);
    }

    public FoodItems createFoodItem(FoodItems foodItem) {
        return foodItemsRepository.save(foodItem);
    }

    public FoodItems updateFoodItem(int foodItemId, FoodItems updatedFoodItem) {
        if (!foodItemsRepository.existsById(foodItemId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Food Item not found");
        }
        updatedFoodItem.setId(foodItemId);
        return foodItemsRepository.save(updatedFoodItem);
    }

    public void deleteFoodItem(int foodItemId) {
        foodItemsRepository.deleteById(foodItemId);
    }
}
