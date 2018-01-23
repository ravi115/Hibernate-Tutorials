package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.model.manytomany.Cycles;
import com.jersey.spring.hibernate.model.manytomany.Stands;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class HibernateManyToManyRespositoryImpl implements HibernateManyToManyRespository {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Stands> getAllStands() {
		
		return null;
	}

	@Override
	public List<Cycles> getAllCycles() {
		
		return null;
	}

	@Override
	public Stands getStands(int id) {
		
		return null;
	}

	@Override
	public Cycles getCycles(int id) {
		
		return null;
	}

	@Override
	public int add(Stands Stands) {
		
		return 0;
	}

	@Override
	public int add(Cycles Cycles) {
		
		return 0;
	}

	@Override
	public void update(int id, Stands Stands) {
		

	}

	@Override
	public void update(int id, Cycles Cycles) {
		

	}

	@Override
	public void deleteStands(int id) {
		

	}

	@Override
	public void deleteCycles(int id) {
		

	}

}
