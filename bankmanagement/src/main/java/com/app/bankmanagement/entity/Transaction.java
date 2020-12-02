package com.app.bankmanagement.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@Column(name="transaction_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String transactionId;
	@Column(name="acc_id")
	private String accountId;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="cust_id")
	private Customer customer;
	@Column(name="cust_id", updatable=false, insertable=false)
	private String customerId;
	@Column(name="transaction_type")
	private String transactionType;
	@Column(name="date")
	private Instant date;
	@Column(name="amount")
	private double amount;
	@Column(name="balance")
	private double balance;
	@Column(name="remark")
	private String remark;
	
	public Transaction(){
		
	}

	public Transaction(String accountId, String customerId, String transactionType, Instant date,
			double amount, double balance, String remark) {
		this.accountId = accountId;
		this.customerId = customerId;
		this.transactionType = transactionType;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
		this.remark = remark;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
