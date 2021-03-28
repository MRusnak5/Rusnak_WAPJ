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
	private String inputTitle;

	
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

	public void setInputTitle(String inputTitle) {
		this.inputTitle = inputTitle;
	}

}
