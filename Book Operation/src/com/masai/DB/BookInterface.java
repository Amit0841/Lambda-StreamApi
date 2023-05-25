package com.masai.DB;

import java.sql.SQLException;
import java.util.List;

import com.masai.Dto.Book;
import com.masai.Exception.SomeThingWentWrong;

public interface BookInterface {

	void addbook(Book b) throws SomeThingWentWrong, SQLException;

	void updateBook(Book b) throws SomeThingWentWrong, SQLException;

	void deletebook(String bookCode) throws SomeThingWentWrong, SQLException;

	Book findBook(String bookCode) throws SomeThingWentWrong, SQLException;

	List<Book> findBookByPageYear(int start, int end, String y) throws SomeThingWentWrong, SQLException;

}
