package com.yannitech.bookstore.yannitech.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yannitech.bookstore.yannitech.model.Author;
import com.yannitech.bookstore.yannitech.model.Book;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AuthorCustomRepository authoRepository;

	@Override
	@Transactional
	public List<Book> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> criteria = cb.createQuery(Book.class);
		Root<Book> book = criteria.from(Book.class);
		criteria.select(book).orderBy(cb.asc(book.get("category")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	@Transactional
	public Book findBookById(Long bookId) {
		return em.find(Book.class, bookId);
	}

	@Override
	@Transactional
	public Book saveBook(Book book) {
		book.setAuthorList(null);
		em.persist(book);
		em.flush();
		return book;
	}

	@Override
	@Transactional
	public Book updateBook(Book book) {
		em.merge(book);
		return book;
	}

	@Override
	@Transactional
	public Book findById(Long id) {
		return em.find(Book.class, id);
	}

	@Override
	@Transactional
	public void delete(Book book) {
		
		long bookId = book.getId();
		Author author = authoRepository.findAuthorByBookId(bookId);

		if (author != null) {
			em.remove(author);
			em.remove(book);
		} else {
			em.remove(book);
		}
	}

}
