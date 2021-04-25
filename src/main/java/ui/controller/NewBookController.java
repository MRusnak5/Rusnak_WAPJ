package ui.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.BookService;
import business.dto.TOBook;
import persistence.dao.IBookDao;
import persistence.model.Book;
import persistence.qualifiers.Real;



@ViewScoped
@Named
public class NewBookController implements Serializable{
	@Inject
	private BookService bs;
	
	@Inject
	@Real
	private IBookDao bookDao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String inputTitle;
	private Book book;
	
	@PostConstruct
	private void init() {
		this.inputTitle = "Example title";
		this.setBook(new Book());
	}
	
	public void addBook() {
	/*	if(inputTitle.length()==0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("you muset enter title"));
			return;
		}*/
		
		try {
			System.out.println("added book with title: " + this.book.getTitle());
			/*Book b = new Book();
			b.setTitle(this.inputTitle);
			bookDao.createBook(b);*/
			bs.addBook(book);
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
