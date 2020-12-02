package com.app.bankmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.bankmanagement.dao.PayeeDAO;
import com.app.bankmanagement.entity.Customer;
import com.app.bankmanagement.entity.Payee;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private PayeeDAO payeeDAO;
	@Autowired
	private CustomerService customerService;
	
	@Override
	@Transactional
	public List<Payee> getAll() {
		return payeeDAO.getAll();
	}

	@Override
	@Transactional
	public Payee getPayee(String payeeId) {
		return payeeDAO.getPayee(payeeId);
	}

	@Override
	@Transactional
	public void save(Payee thePayee) {
		Customer customer = customerService.getCustomer(thePayee.getCustomerId());
		if(customer == null){
			throw new RuntimeException("Invalid customer");
		}
		boolean alreadyPresent = payeeDAO.isPayee(thePayee.getPayeeNickName());
		if(alreadyPresent){
			throw new RuntimeException("Payee already present");
		}
		thePayee.setCustomer(customer);
		
		payeeDAO.save(thePayee);

	}

	@Override
	@Transactional
	public void delete(String payeeId) {
		payeeDAO.delete(payeeId);

	}

	@Override
	@Transactional
	public List<Payee> getPayeeByCustomerId(String customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null){
			throw new RuntimeException("Invalid customer");
		}
		return payeeDAO.getPayeeByCustomerId(customerId);
	}

}
