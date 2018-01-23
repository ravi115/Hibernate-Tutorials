package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Animal;
import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Cat;
import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Dog;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class TablePerClassHirarcheyImpl implements TablePerClassHirarchey {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Animal> getAllAnimals() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Animal> animals = session.createQuery("From Animal" , Animal.class).getResultList();
		return animals;
	}

	@Override
	public List<Cat> getAllCat() {
		Session session = sessionFactory.getCurrentSession();
		List<Cat> cats = session.createQuery("From Cat" , Cat.class).getResultList();
		return cats;
	}

	@Override
	public List<Dog> getAllDog() {
		Session session = sessionFactory.getCurrentSession();
		List<Dog> dogs = session.createQuery("From Dog" , Dog.class).getResultList();
		return dogs;
	}

	@Override
	public Animal getAnimal(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Animal.class, id);
	}

	@Override
	public Cat getCat(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Cat.class, id);
	}

	@Override
	public Dog getDog(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Dog.class, id);
	}
	
	@Override
	public int add(Cat cat) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(cat);
	}

	@Override
	public int add(Dog dog) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(dog);
	}

}
