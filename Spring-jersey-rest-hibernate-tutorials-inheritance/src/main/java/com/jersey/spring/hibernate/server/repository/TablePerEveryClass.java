package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.server.model.tablepereveryclass.ClassRoom;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.JuniorRoom;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.Library;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.School;
import com.jersey.spring.hibernate.server.model.tablepereveryclass.SeniorRoom;

public interface TablePerEveryClass {

	public List<School> getAllSchools();
	public List<ClassRoom> getAllClassRoom();
	public List<Library> getAllLibrary();
	public List<JuniorRoom> getAllJuniorRoom();
	public List<SeniorRoom> getAllSeniorRoom();

	public School getSchools(int id);
	public ClassRoom getClassRoom(int id);
	public Library getLibrary(int id);
	public JuniorRoom getJuniorRoom(int id);
	public SeniorRoom getSeniorRoom(int id);

	public int add(School school);
	public int add(ClassRoom classRoom);
	public int add(Library library);
	public int add(JuniorRoom juniorRoom);
	public int add(SeniorRoom seniorRoom);

}

