package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import com.jersey.spring.hibernate.model.bd.onetomany.Author;
import com.jersey.spring.hibernate.model.bd.onetomany.Books;

public interface HibernateOneToManyBDRespository {


	public List<Author> getAllAuthor();

	public List<Books> getAllBooks();

	public Author getAuthor(int id);

	public Books getBooks(int id);

	public int add(Author author);

	public int add(Books books);

	public void update(int id, Author author);

	public void update(int id, Books books);

	public void deleteAuthor(int id);

	public void deleteBooks(int id);
}
