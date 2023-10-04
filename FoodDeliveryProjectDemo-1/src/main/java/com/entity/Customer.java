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

public class Customer extends AppUser {
	
	 @NotBlank(message = "First name is required")
	    @Size(max = 50, message = "First name must be less than or equal to 50 characters")
	 private String customerFirstName;
	 
	 @NotBlank(message = "Last name is required")
	    @Size(max = 50, message = "Last name must be less than or equal to 50 characters")
	    private String customerLastName;
	 
	 @NotBlank(message = "Address is required")
	    @Size(max = 255, message = "Address must be less than or equal to 255 characters")
	    private String address;
	 
	 @NotNull(message = "Mobile number is required")
	    private Long mobilenumber;
	 
	  @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is required")
	    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
	    private String emailId;

	    @OneToMany(mappedBy = "customer")
	    @JsonBackReference // To avoid circular reference
	    private List<Orders> orders;

		public String getCustomerFirstName() {
			return customerFirstName;
		}

		public void setCustomerFirstName(String customerFirstName) {
			this.customerFirstName = customerFirstName;
		}

		public String getCustomerLastName() {
			return customerLastName;
		}

		public void setCustomerLastName(String customerLastName) {
			this.customerLastName = customerLastName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Long getMobilenumber() {
			return mobilenumber;
		}

		public void setMobilenumber(Long mobilenumber) {
			this.mobilenumber = mobilenumber;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public List<Orders> getOrders() {
			return orders;
		}

		public void setOrders(List<Orders> orders) {
			this.orders = orders;
		}

		
		  public Customer() {
		    }

		  public Customer(String customerFirstName, String customerLastName, String address, Long mobilenumber,
		            String emailId, List<Orders> orders) {
		        super();
		        this.customerFirstName = customerFirstName;
		        this.customerLastName = customerLastName;
		        this.address = address;
		        this.mobilenumber = mobilenumber;
		        this.emailId = emailId;
		        this.orders = orders;
		    }

		  @Override
		    public String toString() {
		        return "Customer [customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
		                + ", address=" + address + ", mobilenumber=" + mobilenumber + ", emailId=" + emailId + ", orders="
		                + orders + "]";
		    }
	    
	    
	    

}
