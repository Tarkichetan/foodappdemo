package com.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import com.entity.Customer;
import com.entity.FoodItems;
import com.entity.Orders;
import com.repository.CustomerRepository;

import jakarta.validation.Valid;

@Service
@Validated
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int customerId) {
        return customerRepository.findById(customerId);
    }
    
    public List<FoodItems> getOrderedFoodItems(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            List<Orders> orders = customer.get().getOrders();
            List<FoodItems> orderedFoodItems = new ArrayList<>();
            for (Orders order : orders) {
                orderedFoodItems.addAll(order.getFoodItems());
            }
            return orderedFoodItems;
        } else {
        	 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
    }

    public Customer createCustomer(@Valid Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int customerId,@Valid Customer updatedCustomer) {
        if (!customerRepository.existsById(customerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        // You don't need to set the customerId; it's inherited from AppUser.
        return customerRepository.save(updatedCustomer);
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
