package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.server.model.mappedBy.ContractEmployee;
import com.jersey.spring.hibernate.server.model.mappedBy.RegularEmployee;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class MappedBySupperClassImpl implements MappedBySupperClass {

	@Autowired
	SessionFactory sessionFactory;


	@Override
	public List<RegularEmployee> getAllRegularEmployee() {

		Session session = sessionFactory.getCurrentSession();
		List<RegularEmployee> temp = session
				.createQuery("FROM RegularEmployee", RegularEmployee.class)
				.getResultList(); 
		
		return temp;
	}

	@Override
	public List<ContractEmployee> getAllContractEmployee() {
		Session session = sessionFactory.getCurrentSession();
		List<ContractEmployee> temp = session
				.createQuery("FROM ContractEmployee", ContractEmployee.class)
				.getResultList();

		return temp;
	}

	@Override
	public RegularEmployee getRegularEmployee(int id) {

		Session session = sessionFactory.getCurrentSession();
		RegularEmployee regularEmployee = session.get(RegularEmployee.class, id);
		return regularEmployee;
	}

	@Override
	public ContractEmployee getContractEmployee(int id) {

		Session session = sessionFactory.getCurrentSession();
		return session.get(ContractEmployee.class, id);
	}

	@Override
	public int add(RegularEmployee regularEmployee) {

		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(regularEmployee);
	}

	@Override
	public int add(ContractEmployee contractEmployee) {
		Session session = sessionFactory.getCurrentSession();

		return (int) session.save(contractEmployee);
	}

}
