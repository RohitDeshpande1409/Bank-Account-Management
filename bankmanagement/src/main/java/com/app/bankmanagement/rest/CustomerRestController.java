package com.app.bankmanagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bankmanagement.entity.Customer;
import com.app.bankmanagement.helper.StringResponse;
import com.app.bankmanagement.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	@Qualifier("customerServiceImpl")
	CustomerService customerService;
	
	@Autowired
	private StringResponse stringResponse;
	
	//expose /customers and return list of customers 
	@GetMapping("/customers")
	public List<Customer> getAll(){
		return customerService.getAll();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable String customerId){
		 Customer customer = customerService.getCustomer(customerId);
		 if(customer == null){
			 throw new RuntimeException("Invalid customer id");
		 }
		 return customer;
	}
	
	@PostMapping("/customers")
	@ResponseBody
	public StringResponse addCustomer(@RequestBody Customer theCustomer){
		customerService.saveCustomer(theCustomer);
		stringResponse.setMessage("Customer Saved");
		return stringResponse;
	}
	
	@PutMapping("/customers")
	@ResponseBody
	public StringResponse updateCustomer(@RequestBody Customer theCustomer){
		Customer tempCustomer = customerService.getCustomer(theCustomer.getCustomerId());
		if(tempCustomer == null){
			throw new RuntimeException("Invalid customer id");
		}
		customerService.saveCustomer(theCustomer);
		stringResponse.setMessage("Customer Updated");
		return stringResponse;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public StringResponse deleteCustomer(@PathVariable String customerId){
		Customer c = customerService.getCustomer(customerId);
		if(c == null){
			throw new RuntimeException("Invalid customer id");
		}
		customerService.deleteCustomer(customerId);
		
		stringResponse.setMessage("Deleted customer with id: "+ customerId);
		return stringResponse;
	}
}
