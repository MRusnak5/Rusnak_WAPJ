package ui.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.MovieService;
import business.dto.TOBook;
import business.dto.TOMovie;

import persistence.dao.IMovieDao;

import persistence.model.Movie;
import persistence.qualifiers.Real;

@ViewScoped
@Named
public class MovieSinglePageController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -41322320581056199L;

	private String inputMovieTitle;
	private String inputMovieDirector;
	private String inputMovieWriters;

	private List<TOMovie> moviesList;

	@Inject
	@Real
	private IMovieDao movieDao;

	@Inject
	private MovieService ms;

	@PostConstruct
	private void init() {

		this.moviesList = this.movieDao.getAllTOMovies();
		System.out.println("MovieSinglePageController created");
	}

	public void loadList() {
		this.moviesList = this.movieDao.getAllTOMovies();
	}
	
	public void edit(TOMovie toMovie) {

		toMovie.setEditingMode(true);
		
		System.out.println("editing mode on");
	}

	public void save(TOMovie toMovie) {

		ms.editMovie(toMovie);
		this.loadList();
		toMovie.setEditingMode(false);
		System.out.println("editing mode off");

		// tobook musi odkazovat na konkretnu entitu v db

	}
	
	public void delete(TOMovie toMovie) {
		try {
			ms.deleteMovie(toMovie);
			this.loadList();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("deleted movie", "success"));
			System.out.println("deleted");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Delete failed", e.getMessage()));
		}
		//return "/index.xhtml?faces-redirect=true";
		

	}
	
	public String goToNewMoviePage() {
	return "/newMovie.xhtml?faces-redirect=true";
	}
	

	public void addMovie() {
		Movie m = new Movie();
		m.setTitle(this.inputMovieTitle);
		m.setDirector(this.inputMovieDirector);
		m.setWriters(this.inputMovieWriters);
		movieDao.createMovie(m);
		System.out.println("added movie with title: " + this.inputMovieTitle + "\n directed by "
				+ this.inputMovieDirector + "\n written by " + this.inputMovieWriters);
	}

	public String getInputMovieTitle() {
		return inputMovieTitle;
	}

	public void setInputMovieTitle(String inputMovieTitle) {
		this.inputMovieTitle = inputMovieTitle;
	}

	public String getInputMovieDirector() {
		return inputMovieDirector;
	}

	public void setInputMovieDirector(String inputMovieDirector) {
		this.inputMovieDirector = inputMovieDirector;
	}

	public String getInputMovieWriters() {
		return inputMovieWriters;
	}

	public void setInputMovieWriters(String inputMovieWriters) {
		this.inputMovieWriters = inputMovieWriters;
	}

	public List<TOMovie> getMoviesList() {
		return moviesList;
	}

	public void setMoviesList(List<TOMovie> moviesList) {
		this.moviesList = moviesList;
	}

}
