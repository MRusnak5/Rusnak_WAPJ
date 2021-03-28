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
	

	}

}
