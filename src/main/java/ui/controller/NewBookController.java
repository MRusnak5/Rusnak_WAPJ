package ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import persistence.dao.IBookDao;
import persistence.model.Book;
import persistence.qualifiers.Real;



@ViewScoped
@Named
public class NewBookController implements Serializable{

	@Inject
	@Real
	private IBookDao bookDao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String inputTitle;
	
	@PostConstruct
	private void init() {
		this.inputTitle = "Example title";
		
	}
	
	public void addBook() {
		
		try {
			System.out.println("added book with title: " + this.inputTitle);
			Book b = new Book();
			b.setTitle(this.inputTitle);
			bookDao.createBook(b);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Added book", "success"));
			System.out.println("added");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Delete failed", e.getMessage()));
		}
	}
	
	public String getInputTitle() {
		return inputTitle;
	}

	public void setInputTitle(String inputTitle) {
		this.inputTitle = inputTitle;
	}
	
	
	
}
