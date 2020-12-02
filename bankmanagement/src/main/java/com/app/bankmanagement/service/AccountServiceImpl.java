package com.app.bankmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.bankmanagement.dao.AccountDAO;
import com.app.bankmanagement.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private TransactionService transactionService;
	
	@Override
	@Transactional
	public List<Account> getAll() {
		return accountDAO.getAll();
	}

	@Override
	@Transactional
	public String creditAmount(double amount, String accountId) {
		//transactionService.addTransaction(transaction);
		String customerId = getCustomerIdBasedOnAccountId(accountId);
		double balance = accountDAO.creditAmount(amount, accountId);
		saveTransaction(accountId, customerId, "credit", amount, "ATM", balance);
		//transactionService.makeTransactionEntry(accountId, customerId, "credit", amount, "ATM", balance);
		return "Amount credited. Balance is :"+balance;
	}

	@Override
	@Transactional
	public String debitAmount(double amount, String accountId) {
		double balance = accountDAO.debitAmount(amount, accountId);
		if(balance < 0){
			return "Insufficient funds";
		}
		String customerId = getCustomerIdBasedOnAccountId(accountId);
		saveTransaction(accountId, customerId, "debit", amount, "ATM", balance);
		//transactionService.makeTransactionEntry(accountId, customerId, "debit", amount, "ATM", balance);
		return "Amount debited. Balance is : "+balance;
	}

	@Override
	@Transactional
	public String getCustomerIdBasedOnAccountId(String accountId) {
		return accountDAO.getCustomerIdBasedOnAccountId(accountId);
	}

	@Override
	@Transactional
	public String debitAmount(double amount, String accountId, String payeeNickName) {
		double balance = accountDAO.debitAmount(amount, accountId);
		if(balance < 0){
			return "Insufficient funds";
		}
		String customerId = getCustomerIdBasedOnAccountId(accountId);
		saveTransaction(accountId, customerId, "debit", amount, "Fund transferred to "+payeeNickName, balance);
		//transactionService.makeTransactionEntry(accountId, customerId, "debit", amount, "ATM", balance);
		return "Amount debited. Balance is : "+balance;
	}
	
	private void saveTransaction(String accountId, String customerId, String type, double amount, String remark, double balance){
		transactionService.makeTransactionEntry(accountId, customerId, type, amount, remark, balance);
	}

}
