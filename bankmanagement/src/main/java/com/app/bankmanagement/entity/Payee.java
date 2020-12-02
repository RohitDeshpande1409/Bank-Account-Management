package com.app.bankmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="payee")
public class Payee {

	@Id
	@Column(name="payee_id")
	private String payeeId;
	
	@Column(name="payee_name")
	private String payeeName;
	
	@Column(name="payee_nick_name")
	private String payeeNickName;
	
	@Column(name="branch_name")
	private String branchName;
	
	@Column(name="ifsc_code")
	private String ifscCode;
	
	@Column(name="bank_name")
	private String bankName;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	@Column(name="cust_id", updatable=false, insertable=false)
	private String customerId;
	
	public Payee(){
		
	}

	public Payee(String payeeId, String payeeName, String payeeNickName, String branchName, String ifscCode,
			String bankName, String customerId) {
		super();
		this.payeeId = payeeId;
		this.payeeName = payeeName;
		this.payeeNickName = payeeNickName;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.customerId = customerId;
	}

	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeeNickName() {
		return payeeNickName;
	}

	public void setPayeeNickName(String payeeNickName) {
		this.payeeNickName = payeeNickName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	@Override
	public String toString() {
		return "Payee [payeeId=" + payeeId + ", payeeName=" + payeeName + ", payeeNickName=" + payeeNickName
				+ ", branchName=" + branchName + ", ifscCode=" + ifscCode + ", bankName=" + bankName + ", customerId="
				+ customerId + "]";
	}
	
	
}
