package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.factory.HibernateFactory;
import com.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private static Session session;
	private SessionFactory factory = null;
	{
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
	}

	public void createCustomer(Customer customer) {

		session = HibernateFactory.getSessionFactory();
		session.getTransaction().begin();
		session.save(customer);
		session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer", Customer.class);

		List<Customer> list = query.getResultList();
		session.getTransaction().commit();
		return list;

	}

	@Override
	public void deleteCust(Customer customer) {
		session = factory.openSession();
		session.getTransaction().begin();
		session.remove(customer);
		session.getTransaction().commit();

	}

	@Override
	public Customer getCustomerById(int id) {
		session = factory.openSession();
		session.getTransaction().begin();
		Customer c = session.get(Customer.class, id);
		session.getTransaction().commit();
		return c;
	}

	@Override
	public void updateCust(Customer customer) {
		session = factory.openSession();
		session.getTransaction().begin();

		session.update(customer);
		session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchCustomer(String str) {
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Customer WHERE firstName like concat('%',:customerName,'%')");
		query.setParameter("customerName", str);
		session.getTransaction().commit();

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> sortCustomer(String str) {

		if (str.equalsIgnoreCase("ascending") ) {
			session = factory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery("FROM Customer ORDER BY firstName ASC");
			List<Customer> custlist = query.getResultList();
			session.getTransaction().commit();
			return custlist;
		}
		else {
			session = factory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery("FROM Customer ORDER BY firstName DESC");
			List<Customer> custlist = query.getResultList();
			session.getTransaction().commit();
			return custlist;
		}
	}

}
