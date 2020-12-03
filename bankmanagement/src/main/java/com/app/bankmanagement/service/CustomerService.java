package com.app.bankmanagement.service;

import java.util.List;

import com.app.bankmanagement.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAll();
	
	public Customer getCustomer(String customerId);
	
	public void saveCustomer(Customer theCustomer);
	
	public void deleteCustomer(String customerId);
	
	public void updateCustomer (Customer theCustomer);

	public boolean isDeleted(String customerId);
	
	public boolean isActive(String customerId);
}
