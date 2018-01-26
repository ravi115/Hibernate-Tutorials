package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.server.model.Address;

public interface AddressRepository {

	public List<Address> getAllAddress();
	public Address getAdddress(int id);
	public int add(Address address);

	
	public List<Address> getAllAddressUsingSQL(); 
}
