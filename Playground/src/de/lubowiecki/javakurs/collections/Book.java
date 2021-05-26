package de.lubowiecki.javakurs.collections;

import java.time.Year;

public class Book {
	
	
	private String title;
	
	private String isbn;
	
	private String author;
	
	private String publisher;
	
	private String description;
	
	private Year year;
	
	private int pages;

	
	public Book() {
	}
	
	public Book(String isbn) {
		this.isbn = isbn;
	}
	
	public Book(String title, String isbn, String author, String publisher, String description, Year year, int pages) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.description = description;
		this.year = year;
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + ", author=" + author + ", publisher=" + publisher
				+ ", description=" + description + ", year=" + year + ", pages=" + pages + "]";
	}
	
	// hashCode und equals werden immer zusammen überschrieben und sollten auf gleichen Eigenschaften basieren 

	@Override
	public int hashCode() {
		// System.out.println("HASHCODE: " + isbn);
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		
		// HashCode von dem String isbn wird mit der Primzahl 31 (kann auch eine andere Zahl sein) multipliziert, damit der HashCode von Book nicht
		// identisch mit dem HashCode vom String isbn ist
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// System.out.println("EQUALS: " + isbn + " " + ((Book)obj).isbn);
		
		// this ist das Buch-Objekt auf dem gerade die equals-Methode aufgerufen wurde
		// this ist eine Referenz auf DIESES Objekt
		
		// Wenn ich Methoden, Eigenschaften oder Konstruktoren von DIESEM Objekt aufrufe,
		// dann wird das this automatisch verwendet, ohne dass man es extra hinschreiben muss (man kann es aber tun)
		
		if (this == obj) // Referenzvergleich: Ist DIESES Objekt das gleich wie das, was gerade an equals übergeben wurde?
			return true;
		
		if (obj == null) // Ist das Objekt, das an die equals übergeben wurde eine NULL-Referenz?
			return false;
		
		if (getClass() != obj.getClass()) // Ist das Objekt, das an die equals übergeben wurde von gleicher Klasse?
			return false;
		
		Book other = (Book) obj; // Referenz von dem Objekt, das an equals übergeben wurde, wird von Object auf Book erweitert
		// Vergleich der Eigenschaften
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
}
