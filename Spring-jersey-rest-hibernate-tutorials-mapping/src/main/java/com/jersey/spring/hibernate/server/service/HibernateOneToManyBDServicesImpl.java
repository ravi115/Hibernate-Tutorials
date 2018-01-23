package com.jersey.spring.hibernate.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersey.spring.hibernate.model.bd.onetomany.Author;
import com.jersey.spring.hibernate.model.bd.onetomany.Books;
import com.jersey.spring.hibernate.server.repository.HibernateOneToManyBDRespository;

@Service
public class HibernateOneToManyBDServicesImpl implements HibernateOneToManyBDServices {
	
	@Autowired
	HibernateOneToManyBDRespository hibernateOneToManyBDRespository;

	@Override
	public List<Author> getAllAuthor() {
		
		return hibernateOneToManyBDRespository.getAllAuthor();
	}

	@Override
	public List<Books> getAllBooks() {
		
		return hibernateOneToManyBDRespository.getAllBooks();
	}

	@Override
	public Author getAuthor(int id) {
		
		return hibernateOneToManyBDRespository.getAuthor(id);
	}

	@Override
	public Books getBooks(int id) {
		
		return hibernateOneToManyBDRespository.getBooks(id);
	}

	@Override
	public int add(Author author) {
		
		return hibernateOneToManyBDRespository.add(author);
	}

	@Override
	public int add(Books books) {
		
		return hibernateOneToManyBDRespository.add(books);
	}

	@Override
	public void update(int id, Author author) {
		hibernateOneToManyBDRespository.update(id, author);

	}

	@Override
	public void update(int id, Books books) {
		hibernateOneToManyBDRespository.update(id, books);

	}

	@Override
	public void deleteAuthor(int id) {
		
		hibernateOneToManyBDRespository.deleteAuthor(id);
	}

	@Override
	public void deleteBooks(int id) {
		
		hibernateOneToManyBDRespository.deleteBooks(id);
	}

}
