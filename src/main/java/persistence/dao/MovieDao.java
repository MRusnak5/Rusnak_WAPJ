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

import persistence.model.Movie;

@Stateless
public class MovieDao {
	@PersistenceContext(unitName = "wapjPU")
	private EntityManager em;

	@PostConstruct

	private void init() {
		System.out.println("Created Moviedao");

	}

	@PreDestroy
	private void destroy() {
		System.out.println("Destroying Moviedao");
	}

	public List<Movie> getMoviesByTitle(String title) {

		TypedQuery<Movie> tq = em.createNamedQuery("Movie_findByTitle", Movie.class);
		tq.setParameter("title", "Test");
		tq.getResultList();
		return tq.getResultList();

	}

	public List<Movie> getMoviesByDirector(String director) {

		TypedQuery<Movie> tq = em.createNamedQuery("Movie_findByDirector", Movie.class);
		tq.setParameter("director", "Jozo");
		tq.getResultList();
		return tq.getResultList();

	}

	/*
	 * public List<Movie> ListAll() { TypedQuery<Movie> tq =
	 * em.createNamedQuery("Movie_findAll", Movie.class); List<Movie> list =
	 * tq.getResultList();
	 * 
	 * for (Movie e : list) {
	 * 
	 * System.out.println(" Nazov filmu :" + e.getTitle());
	 * System.out.println(" Reziser :" + e.getDirector());
	 * System.out.println(" Scenaristi :" + e.getWriters());
	 * System.out.print("Meno :" + e.getActor()); } return list; }
	 */
	public Movie create(Movie movie) {

		em.persist(movie);

		return movie;
	}

}
