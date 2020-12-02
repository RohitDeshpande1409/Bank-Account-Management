package com.app.bankmanagement.dao;

import java.util.List;

import com.app.bankmanagement.entity.Transaction;

public interface TransactionDAO {
	
	public void addTransaction(Transaction transaction);
	
	public List<Transaction> getTransactionByAccountId(String accountId, int limit);
	
	public Transaction getTransactionById(String transactionId);

}
