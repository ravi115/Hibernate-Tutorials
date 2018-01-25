package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.server.model.JavaDataTypesModel;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class DataTypeRepositoryImpl implements DataTypeRepository {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<JavaDataTypesModel> getAllDataValues() {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<JavaDataTypesModel> list = session.createQuery("FROM JavaDataTypesModel", JavaDataTypesModel.class)
				.getResultList(); 
		return list;
	}

	@Override
	public JavaDataTypesModel getDataValues(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(JavaDataTypesModel.class, id);
	}

	@Override
	public int add(JavaDataTypesModel javaDataTypesModel) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(javaDataTypesModel);
	}

}
