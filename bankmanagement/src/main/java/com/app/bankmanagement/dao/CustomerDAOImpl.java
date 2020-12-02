package com.app.bankmanagement.dao;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.bankmanagement.entity.Account;
import com.app.bankmanagement.entity.Customer;
import com.app.bankmanagement.helper.BeanCopyProperties;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// define field for entity manager

	private EntityManager entityManager;

	// setup constructor injection
	@Autowired
	public CustomerDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Customer> getAll() {

		// get the current Hibernate Session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query

		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

		// execute query and get result list

		List<Customer> customers = theQuery.getResultList();

		// return the results

		return customers;
	}

	@Override
	public Customer getCustomer(String customerId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Customer theCustomer = currentSession.get(Customer.class, customerId);
		if (theCustomer != null) {
			if (theCustomer.isDeleted()) {
				return null;
			}
		}
		return theCustomer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session currentSession = entityManager.unwrap(Session.class);

		Customer existingCustomer = getCustomer(theCustomer.getCustomerId());
		if (existingCustomer != null) {
			try {
				BeanUtilsBean cp = new BeanCopyProperties();
				cp.copyProperties(existingCustomer, theCustomer);
				existingCustomer.setUpdateAt(Instant.now());
				currentSession.evict(theCustomer);
				currentSession.saveOrUpdate(existingCustomer);
			} catch (IllegalAccessException e) {

			} catch (InvocationTargetException ex) {

			}
		} else {

			List<Account> acc = theCustomer.getAccounts();
			ListIterator<Account> iterator = acc.listIterator();
			while (iterator.hasNext()) {
				Account a = iterator.next();
				a.setCustomer(theCustomer);
			}
			currentSession.saveOrUpdate(theCustomer);
		}

	}

	@Override
	public void deleteCustomer(String customerId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Customer theCustomer = currentSession.get(Customer.class, customerId);
		theCustomer.setDeleted(true);
		/*
		 * Query theQuery = currentSession.
		 * createQuery("delete from Customer where id=: customerId");
		 * theQuery.setParameter("customerId", customerId);
		 */

		currentSession.saveOrUpdate(theCustomer);

	}

}
