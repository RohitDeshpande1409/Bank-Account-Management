package com.app.bankmanagement.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.bankmanagement.dao.PayeeDAO;
import com.app.bankmanagement.entity.Payee;

class PayeeServiceImplTest {
	
	@InjectMocks
	PayeeServiceImpl payeeService;
	
	@Mock
	PayeeDAO payeeDao;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSave() {
		Payee payeeIn = new Payee();
		payeeIn.setPayeeId("102");
		payeeIn.setPayeeName("Test");
		payeeIn.setCustomerId("");
		
		assertThrows(RuntimeException.class, 
				() -> {
					payeeService.save(payeeIn);
				}
				);
	}

}
