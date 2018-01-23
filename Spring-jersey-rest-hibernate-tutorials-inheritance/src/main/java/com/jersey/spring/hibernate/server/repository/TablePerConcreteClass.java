package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Laptop;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Mobile;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.OperatingSystem;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Phones;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Tablets;

public interface TablePerConcreteClass {

	public List<OperatingSystem> getAllOperatingSystem();
	public List<Mobile> getAllMobile();
	public List<Laptop> getAllLaptops();
	public List <Phones> getAllPhones();
	public List<Tablets> getAllTablets();
	
	public OperatingSystem getOperatingSystem(int id);
	public Mobile getMobile(int id);
	public Laptop getLaptop(int id);
	public Phones getPhone(int id);
	public Tablets getTablet(int id);
	
	public int add(Laptop laptops);
	public int add(Phones phones);
	public int add(Tablets tablets);
	
}
