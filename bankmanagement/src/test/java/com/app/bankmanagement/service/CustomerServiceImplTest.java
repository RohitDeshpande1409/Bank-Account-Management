package com.app.bankmanagement.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.bankmanagement.dao.CustomerDAO;
import com.app.bankmanagement.entity.Customer;

class CustomerServiceImplTest {
	
	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Mock
	private CustomerDAO customerDAO;
	
	private Customer custIn;

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
		
		/*Customer custIn = new Customer();
		custIn.setCustomerId("101");
		custIn.setFirstName("Test");
		custIn.setLastName("Test");*/
		
		when(customerDAO.getCustomer(anyString())).thenReturn(custIn);
		
		Customer custOut = customerService.getCustomer("101");
		
		Assert.assertNotNull(custOut);
		Assert.assertEquals("Test",custOut.getFirstName());
	}

}
