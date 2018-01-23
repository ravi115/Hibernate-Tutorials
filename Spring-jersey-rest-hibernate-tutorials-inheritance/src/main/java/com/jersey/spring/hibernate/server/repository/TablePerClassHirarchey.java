package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Animal;
import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Cat;
import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Dog;

public interface TablePerClassHirarchey {

	public List<Animal> getAllAnimals();
	public List<Cat> getAllCat();
	public List<Dog> getAllDog();
	
	public Animal getAnimal(int id);
	public Cat getCat(int id);
	public Dog getDog(int id);
	
	public int add(Cat cat);
	public int add(Dog dog);
}
