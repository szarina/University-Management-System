package wsp;

import java.io.Serializable;

public class Book implements Serializable {
	String author;
	String title;
	int bookCount;
	
	public Book() {}
	
	public Book(String author, String title, int bookCount) {
		super();
		this.author = author;
		this.title = title;
		this.bookCount = bookCount;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String toString() {
		return "Book Author : " + author + ", Title : " + title + ", Count : " + bookCount;
	}
}