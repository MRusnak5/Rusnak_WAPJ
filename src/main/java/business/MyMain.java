package business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import persistence.dao.BookDao;
import persistence.dao.IBookDao;
import persistence.dao.MovieDao;
import persistence.model.Book;
import persistence.model.Movie;
import persistence.qualifiers.Fake;
import persistence.qualifiers.Real;

@Singleton
@Startup
public class MyMain {

	@Inject
	private MovieDao movieDao;

	@Inject
	@Real
	private IBookDao bookDao;

	@Inject
	@Real
	private String sampleTitle;

	@PostConstruct

	private void init() {

		// novy dao object na vašej entite a zavolate namedquery
		Book b = new Book();
		Movie m = new Movie();
		// BookDao bookDao = new BookDao();
		bookDao.createBook(b);

		movieDao.create(m);
		movieDao.getMoviesByTitle("Test1");
		movieDao.getMoviesByDirector("Jozo");

		System.out.println("INIT");
		b.setTitle(sampleTitle);
		b = bookDao.createBook(b);
		System.out.println("Created book with id "+b.getId()+" and title: "+b.getTitle());
		/*
		 * EntityManagerFactory emf = Persistence.createEntityManagerFactory("wapjPU");
		 * EntityManager em = emf.createEntityManager(); // em.persist(b);
		 * TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		 * tq.setParameter("title", "Test1"); // tq.getResultList(); try {
		 * tq.getSingleResult(); } catch (NoResultException e) {
		 * System.out.println("Noresult exception"); } catch (NonUniqueResultException
		 * e) { System.out.println("Nonunique exception"); } System.out.println(tq);
		 */
		/*
		 * Query query = em.createQuery(
		 * "Select a.fullname,m.title,m.director,m.writers from actor a, movie m where  a.id = m.actor"
		 * ); List<Movie> list = query.getResultList();
		 * 
		 * for (Movie e : list) {
		 * 
		 * System.out.println(" Nazov filmu :" + e.getTitle());
		 * System.out.println(" Reziser :" + e.getDirector());
		 * System.out.println(" Scenaristi :" + e.getWriters());
		 * System.out.print("Meno :" + e.getActor()); }
		 */
		/*
		 * TypedQuery<Movie> tq1 = em.createNamedQuery("Movie_findByDirector",
		 * Movie.class); tq1.setParameter("director", "Jozo"); tq1.getResultList(); try
		 * { tq.getSingleResult(); } catch (NoResultException e) {
		 * System.out.println("Noresult exception"); } catch (NonUniqueResultException
		 * e) { System.out.println("Nonunique exception"); }
		 */

	}

}
