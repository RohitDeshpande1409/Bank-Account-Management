package com.app.bankmanagement.dao;

import java.util.List;

import com.app.bankmanagement.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getAll();
	
	public Customer getCustomer(String customerId);
	
	public void saveCustomer(Customer theCustomer);
	
	public void deleteCustomer(String customerId);
}
