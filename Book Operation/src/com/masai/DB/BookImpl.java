package com.masai.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.masai.Dto.Book;
import com.masai.Exception.SomeThingWentWrong;
import com.mysql.cj.protocol.Resultset;

public class BookImpl implements BookInterface{

	@Override
	public void addbook(Book b)throws SomeThingWentWrong, SQLException {
		Connection c=null;
		try {
			c= MakeConnection.makeConnection();
			String q="create table if not exists book (book_code varchar(4) primary key, name varchar(20) not null, price double not null, publish_date date not null, number_of_pages int not null, writer_name varchar(20) not null)";
			PreparedStatement p=c.prepareStatement(q);
			p.executeUpdate();
			
			String q1="insert into book values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps=c.prepareStatement(q1);
			ps.setString(1, b.getBook_code());
			ps.setString(2, b.getName());
			ps.setDouble(3, b.getPrice());
			ps.setDate(4, Date.valueOf(b.getPublish_date()));
			ps.setInt(5, b.getNumber_of_pages());
			ps.setString(6, b.getWriter_name());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			c.close();
		}
		
	}

	@Override
	public void updateBook(Book b) throws SomeThingWentWrong, SQLException {
		Connection c=null;
		try {
			c= MakeConnection.makeConnection();
		
			String q1="update book set name=?, price=?, publish_date=?, number_of_pages =?, writer_name =? where book_code=?";
			PreparedStatement ps=c.prepareStatement(q1);
			ps.setString(6, b.getBook_code());
			ps.setString(1, b.getName());
			ps.setDouble(2, b.getPrice());
			ps.setDate(3, Date.valueOf(b.getPublish_date()));
			ps.setInt(4, b.getNumber_of_pages());
			ps.setString(5, b.getWriter_name());
			int a=ps.executeUpdate();
			if(a<=0) {
				throw new SomeThingWentWrong("Id Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			c.close();
		}
		
	}

	@Override
	public void deletebook(String bookCode) throws SomeThingWentWrong, SQLException {
		Connection c=null;
		try {
			c= MakeConnection.makeConnection();
		
			String q1="delete from book where book_code=?";
			PreparedStatement ps=c.prepareStatement(q1);
			ps.setString(1, bookCode);
			int a=ps.executeUpdate();
			if(a<=0) {
				throw new SomeThingWentWrong("Id Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			c.close();
		}
		
	}

	@Override
	public Book findBook(String bookCode) throws SomeThingWentWrong, SQLException {
		Connection c=null;
		Book b=null;
		try {
			c= MakeConnection.makeConnection();
		
			String q1="select * from book where book_code=?";
			PreparedStatement ps=c.prepareStatement(q1);
			ps.setString(1, bookCode);
			ResultSet rs=ps.executeQuery();
			if(isEmpty(rs)) {
				throw new SomeThingWentWrong("Id Not Found");
			}else {
				rs.next();
				b= new Book(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDate(4).toLocalDate(), rs.getInt(5), rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			c.close();
		}
		return b;
	}

	private boolean isEmpty(ResultSet rs) throws SQLException {
		
		return (!rs.isBeforeFirst() && rs.getRow()==0);
	}

	@Override
	public List<Book> findBookByPageYear(int start, int end, String y) throws SomeThingWentWrong, SQLException {
		Connection c=null;
		List<Book> list=new ArrayList<>();
		try {
			c= MakeConnection.makeConnection();
		
			String q1="select * from book where number_of_pages > ? and number_of_pages < ? and publish_date like '%"+y+"%' ";
			PreparedStatement ps=c.prepareStatement(q1);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			if(isEmpty(rs)) {
				throw new SomeThingWentWrong("Id Not Found");
			}else {
				while(rs.next()) {
				list.add( new Book(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDate(4).toLocalDate(), rs.getInt(5), rs.getString(6)));
			
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			c.close();
		}
		return list;
	}

}
