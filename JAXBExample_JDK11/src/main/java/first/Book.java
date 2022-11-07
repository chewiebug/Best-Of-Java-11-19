package first;

import java.time.LocalDate;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "name", "author", "date", "ebookReleaseDate" })
public class Book {

	private Long id;
	private String name;
	private String author;
	
	//@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;
	
	private LocalDate ebookReleaseDate;

	@XmlTransient
	private String additionalInfo;
	
	@XmlAttribute
	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "title")
	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// constructor, getters and setters

	public Date getDate() {
		return date;
	}

	/// @XmlJavaTypeAdapter(DateAdapter.class)	
	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement(name = "ebookDate")
	public LocalDate getEbookReleaseDate() {
		return ebookReleaseDate;
	}

	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public void setEbookReleaseDate(LocalDate ebookReleaseDate) {
		this.ebookReleaseDate = ebookReleaseDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", date=" + date + ", ebookReleaseDate="
				+ ebookReleaseDate + "]";
	}
}