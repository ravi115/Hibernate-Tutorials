package com.jersey.spring.hibernate.server.repository;

import java.util.List;
import java.util.Map;

import com.jersey.spring.hibernate.server.model.Address;

public interface AddressRepository {

	public List<Address> findBy(Map<String, String> conditions);
	
	public List<Address> getAllAddress();
	public Address getAdddress(int id);
	public int add(Address address);

}
