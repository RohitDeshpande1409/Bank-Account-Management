package com.app.bankmanagement.service;

import java.util.List;

import com.app.bankmanagement.entity.Payee;

public interface PayeeService {

	public List<Payee> getAll();
	
	public Payee getPayee(String payeeId);
	
	public void save(Payee thePayee);
	
	public void delete(String payeeId);
	
	public List<Payee> getPayeeByCustomerId(String customerId);
	
}
