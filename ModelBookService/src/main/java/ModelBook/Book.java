package ModelBook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Objects;

public class Book implements Serializable, Annotation {
	transient public int Id;
	@NotNull
	public String name;
	@NotNull
	public String author;
	public int year;
	@NotNull
	public String genre;
	
	public void setId(int id) {
		this.Id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setDate(int year) {
		this.year = year;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public int getDate() {
		return this.year;
	}
	public String getGenre() {
		return this.genre;
	}

	@Override
	public String toString() {
		String buf_str = "";
		buf_str = buf_str + name + "\t" + author +"\t" + year + "\t" + genre + "\n";
		return buf_str;
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		return null;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass()!=o.getClass()) return false;
		Book that = (Book) o;
		return name.equals(that.name) && author.equals(that.author) && year == that.year && genre.equals(that.genre);
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(name,author,year, genre);
	}
	public Book() {
		super();
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public Book(String name, String author, Integer year, String genre) {
		this.name = name;
		this.author = author;
		this.year = year;
		this.genre = genre;
	}
	public static class BookBuilder
{
	protected Book book;
	public Book getBook() {
		return book;
	}
		public void createNewBook( ) {
			book = new Book();
		}

	public void addName(String name) {
		book.setName(name);
	}

	public void addAuthor(String author) {
		book.setAuthor(author);
	}

	public void addYear(int year) {
		book.setDate(year);
	}

	public void addGenre(String genre) {
		book.setGenre(genre);
	}
	public BookBuilder(String name, String author, int year, String genre) {
		this.createNewBook();
		this.addName(name);
		this.addAuthor(author);
		this.addYear(year);
		this.addGenre(genre);
	}
}



}