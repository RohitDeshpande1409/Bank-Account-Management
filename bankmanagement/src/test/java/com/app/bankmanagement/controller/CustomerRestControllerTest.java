package com.app.bankmanagement.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.bankmanagement.entity.Customer;
import com.app.bankmanagement.rest.CustomerRestController;
import com.app.bankmanagement.service.CustomerServiceImpl;

class CustomerRestControllerTest {
	
	@InjectMocks
	CustomerRestController customerRest;
	
	@Mock
	CustomerServiceImpl customerService;
	
	Customer custIn;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		custIn = new Customer();
		custIn.setCustomerId("101");
		custIn.setFirstName("Test");
		custIn.setLastName("Test");
	}

	@Test
	void testGetCustomer() {
		when(customerService.getCustomer(anyString())).thenReturn(custIn);
		
		Customer custOut = customerRest.getCustomer("Id");
		
		assertNotNull(custOut);
		assertEquals(custIn.getCustomerId(),custOut.getCustomerId());		
	}

}
