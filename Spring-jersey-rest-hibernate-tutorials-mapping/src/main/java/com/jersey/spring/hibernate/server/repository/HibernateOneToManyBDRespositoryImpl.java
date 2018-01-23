package com.jersey.spring.hibernate.server.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jersey.spring.hibernate.model.bd.onetomany.Author;
import com.jersey.spring.hibernate.model.bd.onetomany.Books;

@Repository
@Transactional(noRollbackFor = Exception.class)
public class HibernateOneToManyBDRespositoryImpl implements HibernateOneToManyBDRespository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Author> getAllAuthor() {

		Session session = sessionFactory.getCurrentSession();

		List<Author> authors = session.createQuery("FROM Author", Author.class).getResultList();
		return authors;
	}

	@Override
	public List<Books> getAllBooks() {

		Session session = sessionFactory.getCurrentSession();

		List<Books> books = session.createQuery("FROM Books", Books.class).getResultList();
		return books;
	}

	@Override
	public Author getAuthor(int id) {

		Session session = sessionFactory.getCurrentSession();
		Author author = session.get(Author.class, id);
		return author;
	}

	@Override
	public Books getBooks(int id) {
		Session session = sessionFactory.getCurrentSession();
		Books books = session.get(Books.class, id);
		return books;
	}

	@Override
	public int add(Author author) {
		Session session = sessionFactory.getCurrentSession();

		return (int) session.save(author);
	}

	@Override
	public int add(Books books) {

		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(books);
	}

	@Override
	public void update(int id, Author author) {

		Session session = sessionFactory.getCurrentSession();
	}

	@Override
	public void update(int id, Books books) {

		Session session = sessionFactory.getCurrentSession();

	}

	@Override
	public void deleteAuthor(int id) {

		Session session = sessionFactory.getCurrentSession();
		int deletedRow = session.createQuery("delete from Author where id =:id")
				.setParameter("id", id)
				.executeUpdate();
		
		if(deletedRow > 0 ) {
			System.out.println("Deleted Data for id : " + id);
		}

	}

	@Override
	public void deleteBooks(int id) {

		Session session = sessionFactory.getCurrentSession();
		int deletedRow = session.createQuery("delete from Books where id =:id")
				.setParameter("id", id)
				.executeUpdate();
		
		if(deletedRow > 0 ) {
			System.out.println("Deleted Data for id : " + id);
		}
	}
}
