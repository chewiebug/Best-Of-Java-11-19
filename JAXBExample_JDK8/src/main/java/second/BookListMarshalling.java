package second;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import first.Book;

public class BookListMarshalling {

	public static void main(String[] args) throws JAXBException, IOException {

		final File destFile = new File("./mybooks.xml");
		marshal(destFile);

		List<Book> myBooks = unmarshal(destFile);
		System.out.println(myBooks);
	}

	public static void marshal(File file) throws JAXBException, IOException {
		Book bookJavaProfi = createJavaProfi();
		Book bookJavaChallenge = createJavaChallenge();

		// Container
		final Books books = new Books();
	    books.add(bookJavaProfi);
		books.add(bookJavaChallenge);
		
		JAXBContext context = JAXBContext.newInstance(Books.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		mar.marshal(books, file);
	}

	private static Book createJavaProfi() {
		Book bookJavaProfi = new Book();
		bookJavaProfi.setId(1L);
		bookJavaProfi.setName("Der Weg zum Java-Profi");
		bookJavaProfi.setAuthor("Michael Inden");
		bookJavaProfi.setDate(new Date(111, 0, 31));
		bookJavaProfi.setEbookReleaseDate(LocalDate.of(2020, 11, 26));
		return bookJavaProfi;
	}

	private static Book createJavaChallenge() {
		Book bookJavaChallenge = new Book();
		bookJavaChallenge.setId(2L);
		bookJavaChallenge.setName("Java Challenge");
		bookJavaChallenge.setAuthor("Michael Inden");
		bookJavaChallenge.setDate(new Date(120, 7, 26));
		bookJavaChallenge.setEbookReleaseDate(LocalDate.of(2020, 9, 3));
		return bookJavaChallenge;
	}

	public static List<Book> unmarshal(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		final Books books = (Books)jaxbUnmarshaller.unmarshal(file);
		return books.getBooks();
	}
}
