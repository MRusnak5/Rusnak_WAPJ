package persistence.dao;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import persistence.model.Book;
import persistence.qualifiers.Real;

@Stateless
@Real
public class BookDao implements IBookDao {
	@PersistenceContext(unitName = "wapjPU")
	private EntityManager em;

	@PostConstruct
	private void init() {
		System.out.println("Created real Bookdao");

	}

	@PreDestroy
	private void destroy() {
		System.out.println("Destroying BookDao");
	}

	public List<Book> getBooksByTitle(String title) {
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", "Example");
		tq.getResultList();
		return tq.getResultList();

	}

	@Override
	public Book createBook(Book book) {
		em.persist(book);

		return book;
	}

	@Override
	public Book editBook(Book book) {
		em.merge(book);
		return book;
	}

	@Override
	public void deleteBook(Book book) {
		if (em.contains(book)) {
			em.remove(book);
		} else {
			em.remove(em.merge(book));
		}

	}

	@Override
	public List<Book> getAllBooks() {
		return em.createQuery("from Book").getResultList();
		}

	@Override
	public Book getRandomBook() {
		Query countQuery = em.createNativeQuery("select count(*) from Book");
		  long count = (Long)countQuery.getSingleResult();

		  Random random = new Random();
		  int number = random.nextInt((int)count);

		  Query selectQuery = em.createQuery("select b from Book b");
		  selectQuery.setFirstResult(number);
		  selectQuery.setMaxResults(1);
		  return (Book)selectQuery.getSingleResult();
	}

	@Override
	public Book getBookById(Integer id) {
		Book book = em.find(Book.class, id);
        return book;
	}



}
