package ui.session;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class BookSession implements Serializable {
//conect to bookdao
	/**
	 * 
	 */
	private static final long serialVersionUID = -4382962757350908214L;
	private String favoriteBook;
	
	@PostConstruct
	private void init() {
		System.out.println("created session bean");
		
	}

	public String getFavoriteBook() {
		return favoriteBook;
	}

	public void setFavoriteBook(String favoriteBook) {
		this.favoriteBook = favoriteBook;
	}
}
