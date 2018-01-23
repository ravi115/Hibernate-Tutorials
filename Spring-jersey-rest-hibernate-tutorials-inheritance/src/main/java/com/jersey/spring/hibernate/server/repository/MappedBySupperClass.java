package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.server.model.mappedBy.ContractEmployee;
import com.jersey.spring.hibernate.server.model.mappedBy.RegularEmployee;

public interface MappedBySupperClass {

	
	public List<RegularEmployee> getAllRegularEmployee();
	
	public List<ContractEmployee> getAllContractEmployee();
	
	public RegularEmployee getRegularEmployee(int id);
	
	public ContractEmployee getContractEmployee(int id);
	
	public int add(RegularEmployee regularEmployee);
	
	public int add(ContractEmployee contractEmployee);
}
