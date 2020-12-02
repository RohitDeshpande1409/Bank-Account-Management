package com.app.bankmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="account")
public class Account {
	
	//Define fields
	@Id
	@Column(name="account_id")
	private String accountId;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="ifsc_code")
	private String ifscCode;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="cust_id", updatable=false, insertable=false)
	private String customerId; 
	
	public Account(){
		
	}

	public Account(String accountId, double balance, String branch, String ifscCode, String accountType) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.branch = branch;
		this.ifscCode = ifscCode;
		this.accountType = accountType;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCusFK(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", branch=" + branch + ", ifscCode="
				+ ifscCode + ", accountType=" + accountType + "]";
	}
	

}
