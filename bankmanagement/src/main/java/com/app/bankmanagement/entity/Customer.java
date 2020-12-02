package com.app.bankmanagement.entity;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customer")
public class Customer {
	
	// define fields
	@Id
	@Column(name="customer_id")
	private String customerId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="status")
	private String status;
	@Column(name="created_at")
	//@Temporal(value = TemporalType.TIMESTAMP)
	private Instant createdAt;
	@Column(name="updated_at")
	//@Temporal(value = TemporalType.TIMESTAMP)
	private Instant updateAt;
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@OneToMany(cascade ={CascadeType.PERSIST} ,mappedBy="customer")
	private List<Account> accounts;
	
	@OneToMany(mappedBy="customer")
	private List<Payee> payee;
	//define constructor

	public Customer(){
		
	}

	public Customer(String customerId, String firstName, String lastName, String status, Instant createdAt,
			Instant updateAt) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	// define setters/getters 
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status.toString();
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Instant updateAt) {
		this.updateAt = updateAt;
	}
	
	@JsonIgnore
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	//define tostring
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", status=" + status + ", createdAt=" + createdAt + ", updateAt=" + updateAt + "]";
	}
	
	/*public void add(Account theAccount){
		if(accounts == null){
			accounts = new ArrayList<>();
		}
		
		accounts.add(theAccount);
		
		theAccount.setCustomer(this);
	}*/

}
