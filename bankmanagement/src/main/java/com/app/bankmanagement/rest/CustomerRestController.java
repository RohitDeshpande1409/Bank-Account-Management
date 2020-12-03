package com.app.bankmanagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bankmanagement.entity.Customer;
import com.app.bankmanagement.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	@Qualifier("customerServiceImpl")
	CustomerService customerService;
	
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
	public ResponseEntity<String> addCustomer(@RequestBody Customer theCustomer,@RequestHeader String role){
		if(!role.equals("employee")) {
			return new ResponseEntity<>("Unauthorized access",HttpStatus.FORBIDDEN);
		}
		customerService.saveCustomer(theCustomer);
		return ResponseEntity.ok("Customer Saved");
	}
	
	@PutMapping("/customers")
	@ResponseBody
	public ResponseEntity<String> updateCustomer(@RequestBody Customer theCustomer,@RequestHeader String role){
		if(!role.equals("employee")) {
			return new ResponseEntity<>("Unauthorized access",HttpStatus.FORBIDDEN);
		}
		Customer tempCustomer = customerService.getCustomer(theCustomer.getCustomerId());
		if(tempCustomer == null){
			return new ResponseEntity<>("Invalid customer id",HttpStatus.NOT_FOUND);
		}
		customerService.updateCustomer(theCustomer);
		return ResponseEntity.ok("Customer Updated");
	}
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String customerId, @RequestHeader String role){
		if(!role.equals("employee")) {
			return new ResponseEntity<>("Unauthorized access",HttpStatus.FORBIDDEN);
		}
		Customer c = customerService.getCustomer(customerId);
		if(c == null){
			throw new RuntimeException("Invalid customer id");
		}
		customerService.deleteCustomer(customerId);
		
		return ResponseEntity.ok("Deleted customer with id: "+ customerId);
	}
}
