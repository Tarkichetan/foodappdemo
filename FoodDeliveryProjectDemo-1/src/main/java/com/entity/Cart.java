package com.entity;

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
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    private int cartQuantity;
    private double totalprice;

    @ManyToOne
    @JsonBackReference // To avoid circular reference
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JsonBackReference // To avoid circular reference
    @JoinTable(name = "cart_fooditems",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "fooditem_id"))
    private List<FoodItems> fooditems;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<FoodItems> getFooditems() {
		return fooditems;
	}

	public void setFooditems(List<FoodItems> fooditems) {
		this.fooditems = fooditems;
	}

	
	
	
	public Cart() {
	}

	public Cart(int cartId, int cartQuantity, double totalprice, Customer customer, List<FoodItems> fooditems) {
		super();
		this.cartId = cartId;
		this.cartQuantity = cartQuantity;
		this.totalprice = totalprice;
		this.customer = customer;
		this.fooditems = fooditems;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartQuantity=" + cartQuantity + ", totalprice=" + totalprice
				+ ", customer=" + customer + ", fooditems=" + fooditems + "]";
	}
    
    

}
