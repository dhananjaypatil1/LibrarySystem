package com.cmpe226.lms.dao;

public class Book {
	private int bookId;
	private String bookName;
	private int bookQuantity;
	private int publicationYear;
	private String bookEdition;
	private String bookAuthor;
	private int floor;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getBookEdition() {
		return bookEdition;
	}
	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String toString(){
		return "Book [bookId="+bookId+", bookName="+bookName+", bookAuthor="+bookAuthor+", bookEdition="+bookEdition+", bookQuantity="+bookQuantity+", floor="+floor+"]";
	}

}