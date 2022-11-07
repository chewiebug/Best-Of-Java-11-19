package second;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import first.Book;

@XmlRootElement(name = "books")
public class Books {
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	@XmlElement(name = "book")
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void add(Book book) {
		if (this.books == null) {
			this.books = new ArrayList<>();
		}
		this.books.add(book);
	}
}