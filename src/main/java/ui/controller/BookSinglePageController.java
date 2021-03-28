package ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class BookSinglePageController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7217777665137930015L;
	private String inputTitle, inputMovieTitle,inputMovieDirector,inputMovieWriters;

	
	@PostConstruct
	private void init() {
		this.inputTitle = "Example title";
		System.out.println("BookSinglePageController created");
	}
	
	public void addBook() {
		System.out.println("added book with title: "+this.inputTitle);
	}
	public String getInputTitle() {
		return inputTitle;
	}

	public void addMovie() {
		System.out.println("added movie with title: "+this.inputMovieTitle+"\n directed by "+this.inputMovieDirector+"\n written by "+this.inputMovieWriters);
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

	public void setInputTitle(String inputTitle) {
		this.inputTitle = inputTitle;
	}
	
}
