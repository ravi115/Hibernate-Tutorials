package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.server.model.Address;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class AddressRepositoryImpl implements AddressRepository {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getAllAddress() {

		Session session = sessionFactory.getCurrentSession();
		List<Address> addresses = session
				.getNamedQuery("HQL_GET_ALL_ADDRESS")
				.list();
		return addresses;
	}

	@Override
	public Address getAdddress(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("HQL_GET_ADDRESS_FOR_ID");
		query.setParameter("id", id);
		return (Address) query.getSingleResult();
	}

	@Override
	public int add(Address address) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(address);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getAllAddressUsingSQL() {
		Session session = sessionFactory.getCurrentSession();
		List<Address> addresses = session
				.getNamedNativeQuery("SQL_GET_ALL_ADDRESS")
				.list();
		return addresses;
	}

}
