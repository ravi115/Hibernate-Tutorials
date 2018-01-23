package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.model.manytomany.Cycles;
import com.jersey.spring.hibernate.model.manytomany.Stands;


public interface HibernateManyToManyRespository {

	public List<Stands> getAllStands();

	public List<Cycles> getAllCycles();

	public Stands getStands(int id);

	public Cycles getCycles(int id);

	public int add(Stands Stands);

	public int add(Cycles Cycles);

	public void update(int id, Stands Stands);

	public void update(int id, Cycles Cycles);

	public void deleteStands(int id);

	public void deleteCycles(int id);
}
