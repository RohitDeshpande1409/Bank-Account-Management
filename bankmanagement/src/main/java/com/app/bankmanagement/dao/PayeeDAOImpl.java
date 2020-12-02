package com.app.bankmanagement.dao;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.bankmanagement.entity.Payee;
import com.app.bankmanagement.entity.Transaction;
import com.app.bankmanagement.helper.BeanCopyProperties;

@SuppressWarnings("unchecked")
@Repository
public class PayeeDAOImpl implements PayeeDAO {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Payee> getAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Payee> theQuery = currentSession.createQuery("from Payee", Payee.class);

		List<Payee> payees = theQuery.getResultList();
		return payees;
	}

	@Override
	public Payee getPayee(String payeeId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Payee payee = currentSession.get(Payee.class, payeeId);

		return payee;
	}

	@Override
	public void save(Payee thePayee) {
		Session currentSession = entityManager.unwrap(Session.class);

		/*Payee existingPayee = currentSession.get(Payee.class, thePayee.getPayeeId());
		if (existingPayee != null) {
			try {
				BeanUtilsBean cp = new BeanCopyProperties();
				cp.copyProperties(existingPayee, thePayee);
				currentSession.evict(thePayee);
				currentSession.saveOrUpdate(existingPayee);
			} catch (IllegalAccessException e) {

			} catch (InvocationTargetException ex) {

			}
		} else {
			currentSession.saveOrUpdate(thePayee);

		}*/
		currentSession.saveOrUpdate(thePayee);

	}

	@Override
	public void delete(String payeeId) {
		Session currentSession = entityManager.unwrap(Session.class);
		/*Payee p = currentSession.get(Payee.class, payeeId);
		if (p != null) {
			currentSession.delete(p);
		}*/
		
		Query theQuery = currentSession.createQuery("delete from Payee where payeeId=: payeeId");
		
		theQuery.setParameter("payeeId", payeeId);
		
		theQuery.executeUpdate();
	}
	
	@Override
	public boolean isPayee(String theNickName){
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<String> theQuery = currentSession.createQuery(" Select payeeNickName from Payee where payeeNickName =: nick ");
		theQuery.setParameter("nick", theNickName);
		
		String nickName = theQuery.getSingleResult();
		
		if(nickName.equals(theNickName) ){
			return true;
		}
		return false;
	}

	@Override
	public List<Payee> getPayeeByCustomerId(String customerId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Payee> query = currentSession.createQuery("from Payee p where customerId =: id");
		query.setParameter("id", customerId);
		List<Payee> payeeList = query.getResultList();
		return payeeList;
	}

}
