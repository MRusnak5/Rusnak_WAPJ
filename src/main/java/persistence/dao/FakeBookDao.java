package persistence.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import persistence.fakestuff.FakeDatabase;
import persistence.model.Book;
import persistence.qualifiers.Fake;

@Stateless
@Fake
public class FakeBookDao implements IBookDao {

	@Inject
	private FakeDatabase fakeDatabase;
	
	@PostConstruct
	private void init() {
		System.out.println("fake dao");
	}
	
	@Override
	public Book createBook(Book book) {
		return fakeDatabase.insertBook(book);
		
	}

	@Override
	public Book editBook(Book book) {
		return fakeDatabase.editBook(book);
	}

	@Override
	public void deleteBook(Book book) {
		fakeDatabase.removeBook(book);
		
	}

	@Override
	public List<Book> getAllBooks() {
		return fakeDatabase.getAllBooks();
	}

	@Override
	public Book getRandomBook() {
		
		return fakeDatabase.randomBook();
	}

	
	@Override
	public Book getBookById(Integer id) {
		
		return fakeDatabase.getBookById(id);
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
	
		return null;
	}

}
