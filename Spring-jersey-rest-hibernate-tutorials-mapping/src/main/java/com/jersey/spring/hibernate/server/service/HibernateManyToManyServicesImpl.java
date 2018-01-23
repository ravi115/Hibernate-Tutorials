package com.jersey.spring.hibernate.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jersey.spring.hibernate.model.manytomany.Cycles;
import com.jersey.spring.hibernate.model.manytomany.Stands;
import com.jersey.spring.hibernate.server.repository.HibernateManyToManyRespository;

public class HibernateManyToManyServicesImpl implements HibernateManyToManyServices {

	@Autowired
	HibernateManyToManyRespository hibernateManyToManyRespository;

	@Override
	public List<Stands> getAllStands() {

		return hibernateManyToManyRespository.getAllStands();
	}

	@Override
	public List<Cycles> getAllCycles() {

		return hibernateManyToManyRespository.getAllCycles();
	}

	@Override
	public Stands getStands(int id) {

		return hibernateManyToManyRespository.getStands(id);
	}

	@Override
	public Cycles getCycles(int id) {

		return hibernateManyToManyRespository.getCycles(id);
	}

	@Override
	public int add(Stands Stands) {

		return hibernateManyToManyRespository.add(Stands);
	}

	@Override
	public int add(Cycles Cycles) {

		return hibernateManyToManyRespository.add(Cycles);
	}

	@Override
	public void update(int id, Stands Stands) {

		hibernateManyToManyRespository.update(id, Stands);
	}

	@Override
	public void update(int id, Cycles Cycles) {

		hibernateManyToManyRespository.add(Cycles);
	}

	@Override
	public void deleteStands(int id) {

		hibernateManyToManyRespository.deleteStands(id);
	}

	@Override
	public void deleteCycles(int id) {

		hibernateManyToManyRespository.deleteCycles(id);
	}

}
