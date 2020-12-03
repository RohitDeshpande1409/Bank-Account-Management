package com.app.bankmanagement.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bankmanagement.entity.Account;
import com.app.bankmanagement.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountRestController {

	@Autowired
	@Qualifier("accountServiceImpl")
	AccountService accountService;
	
	/*@Autowired
	public AccountRestController(@Qualifier("accountServiceImpl") AccountService theAccountService){
		this.accountService = theAccountService;
	}*/
	@GetMapping("/accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	@PutMapping("/account/{accountId}/transfer")
	@ResponseBody
	public ResponseEntity<String> transferAmount(@PathVariable String accountId, @RequestBody Map<String,String> bodyData){
		double amount = Double.valueOf(bodyData.get("amount"));
		String type = bodyData.get("type");
		String message = "Invalid operation";
		if(type.equals("credit")){
			message = accountService.creditAmount(amount, accountId);
		}else if(type.equals("debit")){
			message = accountService.debitAmount(amount, accountId);
		}
		return ResponseEntity.ok(message);
	}
	
	@PutMapping("/account/{accountId}/transfer/{payeeNickName}")
	@ResponseBody
	public ResponseEntity<String> transferAmount(@PathVariable String accountId,@PathVariable String payeeNickName, @RequestBody Map<String,String> bodyData){
		String message = accountService.debitAmount(Double.valueOf(bodyData.get("amount")), accountId,payeeNickName);
		
		return ResponseEntity.ok(message);
	}
}
