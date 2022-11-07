package first;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class BookMarshalling 
{
	public static void main(String[] args) throws JAXBException, IOException {

		final File destFile = new File("./book.xml");
		marshal(destFile);

		Book derJavaProfi = unmarshal(destFile);
		System.out.println(derJavaProfi);
	}

	public static void marshal(File file) throws JAXBException, IOException {
		Book book = createJavaProfiBook();

		JAXBContext context = JAXBContext.newInstance(Book.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		mar.marshal(book, file);
	}

	private static Book createJavaProfiBook() {
		Book book = new Book();
		book.setId(1L);
		book.setName("Der Weg zum Java-Profi");
		book.setAuthor("Michael Inden");
		book.setDate(new Date(111, 0, 31));
		book.setEbookReleaseDate(LocalDate.now().plusDays(10));
		return book;
	}

	public static Book unmarshal(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		return (Book) jaxbUnmarshaller.unmarshal(file);		
	}
}
