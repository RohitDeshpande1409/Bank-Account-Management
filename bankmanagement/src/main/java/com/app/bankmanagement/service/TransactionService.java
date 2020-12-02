package com.app.bankmanagement.service;

import java.util.List;

import com.app.bankmanagement.entity.Transaction;

public interface TransactionService {
	
	public void addTransaction(Transaction transaction);
	
	public List<Transaction> getTransactionByAccountId(String accountId, int... limit);
	
	public Transaction getTransactionById(String transactionId);
	
	public void makeTransactionEntry(String accountId, String customerId,String type, double amount,String remark, double balance);

}
