package com.app.bankmanagement.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bankmanagement.entity.Transaction;
import com.app.bankmanagement.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionRestController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transaction/{transactionId}")
	public Transaction getTransactionById(@PathVariable String transactionId){
		return transactionService.getTransactionById(transactionId);
	}

	@GetMapping("/transaction")
	public List<Transaction> getTransactionByAccountId( @RequestBody Map<String,String> bodyData){
		String accountId = bodyData.get("accountId");
		String slimit = bodyData.get("limit");
		int limit = -1;
		if(slimit != null){
			limit = Integer.valueOf(slimit);
		}
		if(limit > 0)
		return transactionService.getTransactionByAccountId(accountId,limit);
		else
			return transactionService.getTransactionByAccountId(accountId);
	}

}
