package persistence.dao;

import java.util.List;

import business.dto.TOMovie;
import persistence.model.Movie;

public interface IMovieDao {
	public Movie createMovie(Movie movie);

	public Movie editMovie(Movie movie);

	public void deleteMovie(Movie movie);

	public List<Movie> getAllMovies();

	public List<Movie> getMoviesByTitle(String title);
	// no result exception/nonunique result exception

	public List<Movie> getMoviesByDirector(String director);

	// no result exception/nonunique result exception
	public Movie getMovieById(Integer id);

	public List<TOMovie> getAllTOMovies();
}
