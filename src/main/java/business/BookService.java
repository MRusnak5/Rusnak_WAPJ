package business;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import business.dto.TOBook;
import persistence.dao.IBookDao;
import persistence.model.Book;
import persistence.qualifiers.Real;

@Stateless
public class BookService {
	@Inject
	@Real
	private IBookDao bookDao;

	
	
	public TOBook editBook(TOBook toBook) {

		Book book = bookDao.getBookById(toBook.getId());
		if (book == null) {
			try {
				System.out.println("Editing book failed: Book not found id +  " + toBook.getId());
			} catch (EntityNotFoundException e) {
				System.out.println(e.getMessage());
			}
			return toBook;
		}
		book.setTitle(toBook.getTitle());

		return new TOBook(bookDao.editBook(book));

	}
	
	
	public void deleteBook(TOBook toBook) {

		Book book = bookDao.getBookById(toBook.getId());
		if (book == null) {
			try {
				System.out.println("deleting book failed: Book not found id +  " + toBook.getId());
			} catch (EntityNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		bookDao.deleteBook(book);

	}
}
