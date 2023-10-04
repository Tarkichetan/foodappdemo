package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodItems {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String itemName;
	    private int itemPrice;
	    private int itemQuantity;

	    @ManyToOne
	    //@JsonBackReference // To avoid circular reference
	    private Restaurant restaurant;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public int getItemPrice() {
			return itemPrice;
		}

		public void setItemPrice(int itemPrice) {
			this.itemPrice = itemPrice;
		}

		public int getItemQuantity() {
			return itemQuantity;
		}

		public void setItemQuantity(int itemQuantity) {
			this.itemQuantity = itemQuantity;
		}

		public Restaurant getRestaurant() {
			return restaurant;
		}

		public void setRestaurant(Restaurant restaurant) {
			this.restaurant = restaurant;
		}
		
		
		public FoodItems() {
		}

		public FoodItems(int id, String itemName, int itemPrice, int itemQuantity, Restaurant restaurant) {
			super();
			this.id = id;
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.itemQuantity = itemQuantity;
			this.restaurant = restaurant;
		}

		@Override
		public String toString() {
			return "FoodItems [id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemQuantity="
					+ itemQuantity + ", restaurant=" + restaurant + "]";
		}
	    
	    

}
