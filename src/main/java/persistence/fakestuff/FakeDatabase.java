package persistence.fakestuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import persistence.model.Book;

@Singleton
public class FakeDatabase {

	private Integer lastId;

	private HashMap<Integer, Book> bookTable;

	@PostConstruct
	private void init() {
		this.lastId = 0;
		this.bookTable = new HashMap<Integer, Book>();
	}

	public Book insertBook(Book book) {
		lastId++;
		book.setId(lastId);
		this.bookTable.put(lastId, book);
		return book;
	}
	
	public void removeBook(Book book) {
		Integer Id= book.getId();
		this.bookTable.remove(Id, book);
	}
	
	public Book editBook(Book book) {
		Integer Id= book.getId();
		
		this.bookTable.replace(Id, book);
		
		return book;
	}

	public Book randomBook() {
		Integer count = bookTable.size();
		Random random = new Random();
		Integer number = random.nextInt((int)count);
		Book book = bookTable.get(number);
		return book;
	}
	public List<Book> getAllBooks() {
		List<Book> values = new ArrayList<>(bookTable.values());
		return values;
	}
	
	public Book getBookById(Integer id) {
		Book book = bookTable.get(id);
        return book;
	}

}

