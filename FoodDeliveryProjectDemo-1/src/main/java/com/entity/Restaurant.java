package com.entity;

import java.util.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant extends AppUser{

	 @NotBlank(message = "Restaurant name is required")
	    @Size(max = 100, message = "Restaurant name must be less than or equal to 100 characters")
	private String restaurantName;
	 
	 @NotBlank(message = "Location is required")
	    @Size(max = 255, message = "Location must be less than or equal to 255 characters")
    private String location;
	 
	 @NotNull(message = "Contact number is required")
    private Long contactNo;
	 
	  @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is required")
	    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    private String emailId;

    @OneToMany(mappedBy = "restaurant")
    @JsonBackReference // To avoid circular reference
    private List<FoodItems> foodItems;
    
	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<FoodItems> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItems> foodItems) {
		this.foodItems = foodItems;
	}
	
	

	public Restaurant() {
	}

	public Restaurant(String username,
            String password,
            String role,String restaurantName, String location, Long contactNo, String emailId,
			List<FoodItems> foodItems) {
		super(username, password, role);
		this.restaurantName = restaurantName;
		this.location = location;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.foodItems = foodItems;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantName=" + restaurantName + ", location=" + location + ", contactNo=" + contactNo
				+ ", emailId=" + emailId + ", foodItems=" + foodItems + "]";
	}
    
    

}
