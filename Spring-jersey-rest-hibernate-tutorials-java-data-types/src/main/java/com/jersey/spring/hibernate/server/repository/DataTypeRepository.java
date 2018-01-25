package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.server.model.JavaDataTypesModel;

public interface DataTypeRepository {

	public List<JavaDataTypesModel> getAllDataValues();
	
	public JavaDataTypesModel getDataValues(int id);
	
	public int add(JavaDataTypesModel javaDataTypesModel);
}
