package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Laptop;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Mobile;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.OperatingSystem;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Phones;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Tablets;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class TablePerConcreteClassImpl implements TablePerConcreteClass {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Mobile> getAllMobile() {
		Session session = sessionFactory.getCurrentSession();
		List<Mobile> mobiles = session.createQuery("From Mobile", Mobile.class).getResultList();
		return mobiles;
	}

	@Override
	public List<Laptop> getAllLaptops() {
		Session session = sessionFactory.getCurrentSession();
		List<Laptop> laptop = session.createQuery("From Laptop", Laptop.class).getResultList();
		return laptop;
	}

	@Override
	public List<Phones> getAllPhones() {
		Session session = sessionFactory.getCurrentSession();
		List<Phones> phones = session.createQuery("From Phones", Phones.class).getResultList();
		return phones;
	}

	@Override
	public List<Tablets> getAllTablets() {
		Session session = sessionFactory.getCurrentSession();
		List<Tablets> tablets = session.createQuery("From Tablets", Tablets.class).getResultList();
		return tablets;
	}

	@Override
	public Mobile getMobile(int id) {
		Session session = sessionFactory.getCurrentSession();
		Mobile mobile = session.get(Mobile.class, id);
		return mobile;
	}

	@Override
	public Laptop getLaptop(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Laptop.class, id);
	}

	@Override
	public Phones getPhone(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Phones.class, id);
	}

	@Override
	public Tablets getTablet(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Tablets.class, id);
	}

	@Override
	public int add(Laptop laptops) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(laptops);
	}

	@Override
	public int add(Phones phones) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(phones);
	}

	@Override
	public int add(Tablets tablets) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(tablets);
	}

	@Override
	public List<OperatingSystem> getAllOperatingSystem() {
		Session session = sessionFactory.getCurrentSession();
		List<OperatingSystem> operatingSystem = 
				session.createQuery("From OperatingSystem", OperatingSystem.class)
				.getResultList();
		return operatingSystem;
	}

	@Override
	public OperatingSystem getOperatingSystem(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(OperatingSystem.class, id);
	}

}
