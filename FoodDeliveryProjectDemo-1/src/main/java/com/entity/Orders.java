package com.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int orderId;
	    private LocalDateTime date;
	    private String status;

	    @ManyToOne
	    //@JsonBackReference // To avoid circular reference
	    private Customer customer;
	    
	    
	    @ManyToMany
	   // @JsonBackReference // To avoid circular reference
	    @JoinTable(
	        name = "order_fooditems",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "fooditem_id")
	    )
	    private List<FoodItems> foodItems;
	    
	    

		

		public Orders() {
		}

		public Orders(int orderId, LocalDateTime date, String status, Customer customer, List<FoodItems> foodItems) {
			super();
			this.orderId = orderId;
			this.date = date;
			this.status = status;
			this.customer = customer;
			this.foodItems = foodItems;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public LocalDateTime getDate() {
			return date;
		}

		public void setDate(LocalDateTime date) {
			this.date = date;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<FoodItems> getFoodItems() {
			return foodItems;
		}

		public void setFoodItems(List<FoodItems> foodItems) {
			this.foodItems = foodItems;
		}

		@Override
		public String toString() {
			return "Orders [orderId=" + orderId + ", date=" + date + ", status=" + status + ", customer=" + customer
					+ ", foodItems=" + foodItems + "]";
		}

		
	    
	    

}
