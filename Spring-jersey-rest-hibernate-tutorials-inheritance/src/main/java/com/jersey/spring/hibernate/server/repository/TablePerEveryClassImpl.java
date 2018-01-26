package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.server.model.tablepereveryclass.ClassRoom;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.JuniorRoom;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.Library;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.School;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.SeniorRoom;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class TablePerEveryClassImpl implements TablePerEveryClass {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<School> getAllSchools() {

		Session session = sessionFactory.getCurrentSession();

		List<School> schools = session.createQuery("FROM School", School.class).getResultList();
		return schools;
	}

	@Override
	public List<ClassRoom> getAllClassRoom() {
		Session session = sessionFactory.getCurrentSession();
		List<ClassRoom> classRoom = session.createQuery("FROM ClassRoom", ClassRoom.class).getResultList();
		return classRoom;
	}

	@Override
	public List<Library> getAllLibrary() {
		Session session = sessionFactory.getCurrentSession();
		List<Library> library = session.createQuery("FROM Library", Library.class).getResultList();
		return library;
	}

	@Override
	public List<JuniorRoom> getAllJuniorRoom() {
		Session session = sessionFactory.getCurrentSession();
		List<JuniorRoom> juniorRoom = session.createQuery("FROM JuniorRoom", JuniorRoom.class).getResultList();
		return juniorRoom;
	}

	@Override
	public List<SeniorRoom> getAllSeniorRoom() {
		Session session = sessionFactory.getCurrentSession();
		List<SeniorRoom> seniorRoom = session.createQuery("FROM SeniorRoom", SeniorRoom.class).getResultList();
		return seniorRoom;
	}

	@Override
	public School getSchools(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(School.class, id);
	}

	@Override
	public ClassRoom getClassRoom(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(ClassRoom.class, id);
	}

	@Override
	public Library getLibrary(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Library.class, id);
	}

	@Override
	public JuniorRoom getJuniorRoom(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(JuniorRoom.class, id);
	}

	@Override
	public SeniorRoom getSeniorRoom(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(SeniorRoom.class, id);
	}

	@Override
	public int add(School school) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(school);
	}

	@Override
	public int add(ClassRoom classRoom) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(classRoom);
	}

	@Override
	public int add(Library library) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(library);
	}

	@Override
	public int add(JuniorRoom juniorRoom) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(juniorRoom);
	}

	@Override
	public int add(SeniorRoom seniorRoom) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(seniorRoom);
	}

}
