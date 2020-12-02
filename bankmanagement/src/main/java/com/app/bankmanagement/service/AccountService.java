package com.app.bankmanagement.service;

import java.util.List;

import com.app.bankmanagement.entity.Account;

public interface AccountService {

	public List<Account> getAll();
	
    public String creditAmount(double amount, String accountId);
	
	public String debitAmount(double amount, String accountId);
	
	public String debitAmount(double amount, String accountId, String payeeId);
	
	public String getCustomerIdBasedOnAccountId(String accountId);
}
