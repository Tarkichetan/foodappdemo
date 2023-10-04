package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import com.entity.Restaurant;
import com.repository.RestaurantRepository;

import jakarta.validation.Valid;

@Service
@Validated
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(int restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }

    public Restaurant createRestaurant(@Valid Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(int restaurantId,@Valid Restaurant updatedRestaurant) {
        if (!restaurantRepository.existsById(restaurantId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found");
        }
        updatedRestaurant.setUserId(restaurantId);
        return restaurantRepository.save(updatedRestaurant);
    }

    public void deleteRestaurant(int restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }
}
