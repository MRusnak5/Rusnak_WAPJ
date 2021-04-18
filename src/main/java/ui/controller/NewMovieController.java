package ui.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.dto.TOMovie;
import persistence.dao.IBookDao;
import persistence.dao.IMovieDao;
import persistence.model.Book;
import persistence.model.Movie;
import persistence.qualifiers.Real;

@ViewScoped
@Named
public class NewMovieController implements Serializable {

	private String inputMovieTitle;
	private String inputMovieDirector;
	private String inputMovieWriters;

	private List<TOMovie> moviesList;

	@Inject
	@Real
	private IMovieDao movieDao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	private void init() {
		this.inputMovieTitle = "Example title";

	}

	public void addMovie() {

		try {
			Movie m = new Movie();
			m.setTitle(this.inputMovieTitle);
			m.setDirector(this.inputMovieDirector);
			m.setWriters(this.inputMovieWriters);
			movieDao.createMovie(m);
			System.out.println("added movie with title: " + this.inputMovieTitle + "\n directed by "
					+ this.inputMovieDirector + "\n written by " + this.inputMovieWriters);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Added movie", "success"));
			System.out.println("Added");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Delete failed", e.getMessage()));
		}

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

}
