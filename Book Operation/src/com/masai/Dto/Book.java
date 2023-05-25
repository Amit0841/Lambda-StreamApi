package com.masai.Dto;

import java.time.LocalDate;

public class Book {
    private String	book_code ;
    private String	name ;
	private double	price ;
	private LocalDate	publish_date ;
	private int number_of_pages ;
	private String	writer_name ;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String book_code, String name, double price, LocalDate publish_date, int number_of_pages,
			String writer_name) {
		super();
		this.book_code = book_code;
		this.name = name;
		this.price = price;
		this.publish_date = publish_date;
		this.number_of_pages = number_of_pages;
		this.writer_name = writer_name;
	}
	@Override
	public String toString() {
		return "Book [book_code=" + book_code + ", name=" + name + ", price=" + price + ", publish_date=" + publish_date
				+ ", number_of_pages=" + number_of_pages + ", writer_name=" + writer_name + "]";
	}
	public String getBook_code() {
		return book_code;
	}
	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
	}
	public int getNumber_of_pages() {
		return number_of_pages;
	}
	public void setNumber_of_pages(int number_of_pages) {
		this.number_of_pages = number_of_pages;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	
}
