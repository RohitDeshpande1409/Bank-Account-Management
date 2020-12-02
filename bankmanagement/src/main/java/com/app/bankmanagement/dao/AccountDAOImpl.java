package com.app.bankmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.bankmanagement.entity.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Account> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Account> theQuery = currentSession.createQuery("from Account",Account.class);
		List<Account> accounts = theQuery.getResultList();
		return accounts;
	}

	@Override
	public Double creditAmount(double amount, String accountId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("select balance from Account where accountId =: id");
		theQuery.setParameter("id", accountId);
		double newBalance = (double)theQuery.getSingleResult()+ amount;
		theQuery = currentSession.createQuery("update Account set balance =: bal where accountId =: id");
		theQuery.setParameter("bal", newBalance);
		theQuery.setParameter("id", accountId);
		theQuery.executeUpdate();
		return newBalance;
	}

	@Override
	public Double debitAmount(double amount, String accountId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("select balance from Account where accountId =: id");
		theQuery.setParameter("id", accountId);
		double newBalance = (double)theQuery.getSingleResult() - amount;
		if(newBalance < 0){
			return (double) -1;
		}
		theQuery = currentSession.createQuery("update Account set balance =: bal where accountId =: id");
		theQuery.setParameter("bal", newBalance);
		theQuery.setParameter("id", accountId);
		theQuery.executeUpdate();
		return newBalance;
	}

	@Override
	public String getCustomerIdBasedOnAccountId(String accountId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<String> theQuery = currentSession.createQuery("select customerId from Account where accountId =: id");
		theQuery.setParameter("id", accountId);
		
		return theQuery.getSingleResult();
	}

	
}
