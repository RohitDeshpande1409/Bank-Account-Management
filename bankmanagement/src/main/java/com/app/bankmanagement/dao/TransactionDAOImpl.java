package com.app.bankmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.bankmanagement.entity.Transaction;


@SuppressWarnings("unchecked")
@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	private EntityManager entityManager;
	@Override
	public void addTransaction(Transaction transaction) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(transaction);
	}

	@Override
	public List<Transaction> getTransactionByAccountId(String accountId, int limit) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Transaction> query = currentSession.createQuery("from Transaction t where accountId =: id order by t.date desc");
		query.setMaxResults(limit);
		query.setParameter("id", accountId);
		List<Transaction> tr = query.getResultList();
		
		return tr;
	}

	@Override
	public Transaction getTransactionById(String transactionId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Transaction> query = currentSession.createQuery("from Transaction where transactionId =: id");
		query.setParameter("id", transactionId);
		Transaction tr = query.getSingleResult();
		return tr;
	}

}
