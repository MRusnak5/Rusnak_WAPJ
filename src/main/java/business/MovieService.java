package business;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import business.dto.TOBook;
import business.dto.TOMovie;

import persistence.dao.IMovieDao;
import persistence.model.Book;
import persistence.model.Movie;
import persistence.qualifiers.Real;


@Stateless
public class MovieService {
	@Inject 
	@Real
	private IMovieDao movieDao;
	


	public TOMovie editMovie(TOMovie toMovie) {
		
		Movie movie = movieDao.getMovieById(toMovie.getId());
		if(movie==null) {
			 try {
		          System.out.println("Editing movie failed: Movie not found id +  " + toMovie.getId());
		        } catch (EntityNotFoundException e) {
		            System.out.println(e.getMessage());
		        }
			return toMovie;
		}
		movie.setTitle(toMovie.getTitle());
		movieDao.editMovie(movie);
		return toMovie;
		
	}
	
	public void deleteMovie(TOMovie toMovie) {

		Movie movie = movieDao.getMovieById(toMovie.getId());
		if (movie == null) {
			try {
				System.out.println("deleting book failed: Book not found id +  " + toMovie.getId());
			} catch (EntityNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		movieDao.deleteMovie(movie);

	}
	
	
}
