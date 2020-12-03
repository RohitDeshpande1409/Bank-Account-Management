package com.app.bankmanagement.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bankmanagement.entity.Payee;
import com.app.bankmanagement.service.PayeeService;

@RestController
@RequestMapping("/api")
public class PayeeRestController {

	@Autowired
	PayeeService payeeService;
	
	@GetMapping("/payees/{payeeId}")
	public Payee getPayee(@PathVariable String payeeId){
		return payeeService.getPayee(payeeId);
	}
	
	@PostMapping("/payees")
	public Payee addPayee(@RequestBody Payee thePayee){
		payeeService.save(thePayee);
		return thePayee;
	}
	
	@DeleteMapping("/payees/{payeeId}")
	@ResponseBody
	public ResponseEntity<String> deletePayee(@PathVariable String payeeId){
		payeeService.delete(payeeId);
		return ResponseEntity.ok("Deleted");
	}
	
	@GetMapping("/payees")
	public List<Payee> getPayeeByCustomerId( @RequestBody Map<String,String> bodyData){
		String customerId = bodyData.get("customerId");
		return payeeService.getPayeeByCustomerId(customerId);
	}
	
}
