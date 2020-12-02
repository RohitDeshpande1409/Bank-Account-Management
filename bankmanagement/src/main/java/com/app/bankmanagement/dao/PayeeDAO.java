package com.app.bankmanagement.dao;

import java.util.List;

import com.app.bankmanagement.entity.Payee;

public interface PayeeDAO {
	
	public List<Payee> getAll();
	
	public Payee getPayee(String payeeId);
	
	public void save(Payee thePayee);
	
	public void delete(String payeeId);
	
	public boolean isPayee(String thePayee);
	
	public List<Payee> getPayeeByCustomerId(String customerId);

}
