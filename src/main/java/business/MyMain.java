package business;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import persistence.model.Book;
import persistence.model.Movie;

@Singleton
@Startup
public class MyMain {

	@PostConstruct
	private void init() {
		Book b = new Book();
		System.out.println("INIT");
		b.setTitle("Example");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("wapjPU");
		EntityManager em = emf.createEntityManager();
		em.persist(b);
		TypedQuery<Book> tq = em.createNamedQuery("Book_findByTitle", Book.class);
		tq.setParameter("title", "Example" );
		tq.getResultList();
		try {
			tq.getSingleResult();	
		} catch (NoResultException e) {
			System.out.println("Noresult exception");
		} catch (NonUniqueResultException e) {
			System.out.println("Nonunique exception");
		}
	
		
		
		
		
		Query query = em.createQuery("Select a.name,m.title,m.director,m.writers from actor a, movie m where  a.id = m.actor;");
		 List<Movie> list = query.getResultList();
		
		  for(Movie e:list) {
		
		         System.out.println(" Nazov filmu :" + e.getTitle( ));
		         System.out.println(" Reziser :" + e.getDirector( ));
		         System.out.println(" Scenaristi :" + e.getWriters( ));
		   	  System.out.print("Meno :" + e.getActor( ));
		      }
		
		  TypedQuery<Movie> tq1 = em.createNamedQuery("Movie_findByDirector", Movie.class);
			tq1.setParameter("director", "Quentin Tarantino" );
			tq1.getResultList();
			try {
				tq.getSingleResult();	
			} catch (NoResultException e) {
				System.out.println("Noresult exception");
			} catch (NonUniqueResultException e) {
				System.out.println("Nonunique exception");
			}
		  
		  
		  
	}
	
	
	
	
	
	
}
