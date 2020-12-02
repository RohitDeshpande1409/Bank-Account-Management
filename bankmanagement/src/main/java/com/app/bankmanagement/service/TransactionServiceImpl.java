package com.app.bankmanagement.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.bankmanagement.dao.TransactionDAO;
import com.app.bankmanagement.entity.Customer;
import com.app.bankmanagement.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private CustomerService customerService;
	@Override
	@Transactional
	public void addTransaction(Transaction transaction) {
		Customer customer = customerService.getCustomer(transaction.getCustomerId());
		if(customer == null){
			throw new RuntimeException("Invalid customer");
		}
		transaction.setCustomer(customer);
		transactionDAO.addTransaction(transaction);

	}

	@Override
	@Transactional
	public List<Transaction> getTransactionByAccountId(String accountId, int... limit) {
		return transactionDAO.getTransactionByAccountId(accountId, limit.length > 0 ? limit[0] : 10);
	}

	@Override
	@Transactional
	public Transaction getTransactionById(String transactionId) {
		return transactionDAO.getTransactionById(transactionId);
	}
	
	@Override
	@Transactional
	public void makeTransactionEntry(String accountId, String customerId,String type, double amount,String remark, double balance){
		addTransaction(new Transaction(accountId, customerId, type, Instant.now(), amount, balance, remark));
	}

}
