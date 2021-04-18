package ui.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.BookService;
import business.dto.TOBook;
import persistence.dao.BookDao;
import persistence.dao.IBookDao;
import persistence.model.Book;
import persistence.model.Movie;
import persistence.qualifiers.Real;

@ViewScoped
@Named
public class BookSinglePageController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7217777665137930015L;
	private String inputTitle;

	private List<TOBook> booksList;

	@Inject
	@Real
	private IBookDao bookDao;

	@Inject
	private BookService bs;

	@PostConstruct
	private void init() {
		this.inputTitle = "Example title";
		this.booksList = this.bookDao.getAllTOBooks();
		System.out.println("BookSinglePageController created");
	}
	public void loadList() {
		this.booksList = this.bookDao.getAllTOBooks();
	}
	
	public void edit(TOBook toBook) {

		toBook.setEditingMode(true);
		
		System.out.println("editing mode on");
	}

	public void save(TOBook toBook) {

		bs.editBook(toBook);
		this.loadList();
		toBook.setEditingMode(false);
		System.out.println("editing mode off");

		// tobook musi odkazovat na konkretnu entitu v db

	}

	public String goToNewBookPage() {
	return "/newBook.xhtml?faces-redirect=true";
	}
	
	
	public void delete(TOBook toBook) {
		try {
			bs.deleteBook(toBook);
			this.loadList();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deleted book", "success"));
			System.out.println("deleted");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Delete failed", e.getMessage()));
		}
		//return "/index.xhtml?faces-redirect=true";
		

	}

	

	public String getInputTitle() {
		return inputTitle;
	}

	public void setInputTitle(String inputTitle) {
		this.inputTitle = inputTitle;
	}

	public List<TOBook> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<TOBook> booksList) {
		this.booksList = booksList;
	}

}
