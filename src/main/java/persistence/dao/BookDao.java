package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistence.model.Book;

@Stateless
public class BookDao {
	@PersistenceContext(unitName = "wapjPU")
	private EntityManager em;
	
	@PostConstruct
	
	private void init() {
		System.out.println("Created Bookdao");
		
	}

	@PreDestroy
	private void destroy() {
		System.out.println("Destroying BookDao");
	}
	public List<Book> getBooksByTitle(String title) {

		/*
		 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("wapjPU");
		 * EntityManager em = emf.createEntityManager();
		 */
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", "Example");
		tq.getResultList();
		return tq.getResultList();

	}

	public Book create(Book book) {
		/*
		 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("wapjPU");
		 * EntityManager em = emf.createEntityManager();
		 */
		em.persist(book);

		return book;
	}

}
