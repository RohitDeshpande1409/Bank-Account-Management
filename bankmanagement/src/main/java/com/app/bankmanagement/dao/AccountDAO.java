package com.app.bankmanagement.dao;

import java.util.List;
import com.app.bankmanagement.entity.Account;

public interface AccountDAO {

	public List<Account> getAll();
	
	public Double creditAmount(double amount, String accountId);
	
	public Double debitAmount(double amount, String accountId);
	
	public String getCustomerIdBasedOnAccountId(String accountId);
}
