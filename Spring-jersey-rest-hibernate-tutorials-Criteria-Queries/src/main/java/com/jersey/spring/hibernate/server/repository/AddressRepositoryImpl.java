package com.jersey.spring.hibernate.server.repository;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.server.model.Address;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class AddressRepositoryImpl implements AddressRepository {

	@Autowired
	SessionFactory sessionFactory;


	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Address> getAllAddress() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Address.class);
		
		List<Address> addresses = criteria.list(); 
		return addresses;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Address getAdddress(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Address.class);
		criteria.add(Restrictions.eq("id", id));
		Address address = (Address) criteria.list().get(0);
		return address;
	}

	@Override
	public int add(Address address) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(address);
	}

	@Override
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Address> findBy(Map<String, String> conditions) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Address.class);
		
		if(conditions.get("city_name") != null && conditions.get("city_name").length() > 0 ) {
			criteria.add(Restrictions.like("city", conditions.get("city_name")));
		}
		if(conditions.get("country_name") != null && conditions.get("country_name").length() > 0 ) {
			criteria.add(Restrictions.like("country", conditions.get("country_name")));
		}
		if(conditions.get("range1") != null && conditions.get("range1").length() > 0 &&
				conditions.get("range2") != null && conditions.get("range2").length() > 0) {
			criteria.add(Restrictions.like("country", conditions.get("country_name")));
		}
		
		return criteria.list();
	}

}
