package com.app.bankmanagement.service;

import java.time.Instant;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.bankmanagement.dao.CustomerDAO;
import com.app.bankmanagement.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	@Qualifier("customerDAOImpl")
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getAll() {
		List<Customer> customer = customerDAO.getAll();
		
		ListIterator<Customer> iterator = customer.listIterator();
		while(iterator.hasNext()){
			Customer c = iterator.next();
			if(c.isDeleted()){
				iterator.remove();
			}
		}
		
		return customer;
	}

	@Override
	@Transactional
	public Customer getCustomer(String customerId) {
		if(customerId.isEmpty()) {
			return null;
		}
		return customerDAO.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		Customer existing = getCustomer(theCustomer.getCustomerId());
		if(existing == null){
		theCustomer.setCreatedAt(Instant.now());
		theCustomer.setUpdateAt(Instant.now());
		customerDAO.saveCustomer(theCustomer);
		}
	}

	@Override
	@Transactional
	public void deleteCustomer(String customerId) {
		customerDAO.deleteCustomer(customerId);
		
	}

	@Override
	public void updateCustomer(Customer theCustomer) {
		theCustomer.setUpdateAt(Instant.now());
		customerDAO.saveCustomer(theCustomer);
	}
}
