package com.yannitech.bookstore.yannitech.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.yannitech.bookstore.yannitech.model.Author;

@Repository
public class AuthorCustomRepositoryImpl implements AuthorCustomRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Author findAuthorById(Long id) {
		return em.find(Author.class, id);
	}

	@Override
	@Transactional
	public void removeAuthor(Author author) {
		em.remove(author);
	}

	@Override
	@Transactional
	public List<Author> findAuthorsByBookId(Long bookId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Author> criteria = cb.createQuery(Author.class);
		Root<Author> root = criteria.from(Author.class);
		criteria.select(root).where(cb.equal(root.get("book"), bookId));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	@Transactional
	public Author findAuthorByBookId(Long bookId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Author> criteria = cb.createQuery(Author.class);
		Root<Author> root = criteria.from(Author.class);
		criteria.select(root).where(cb.equal(root.get("book"), bookId));

		List<Author> elementList = em.createQuery(criteria).setMaxResults(1).getResultList();

		return CollectionUtils.isEmpty(elementList) ? null : elementList.get(0);
	}

	@Override
	@Transactional
	public void updateAuthor(Author author) {
		em.merge(author);
		em.flush();
	}

}
