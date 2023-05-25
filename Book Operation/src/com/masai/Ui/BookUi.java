package com.masai.Ui;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.masai.Dto.Book;
import com.masai.Exception.SomeThingWentWrong;
import com.masai.DB.BookInterface;
import com.masai.DB.BookImpl;
public class BookUi {
	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int c=0;
	do {
		System.out.println("1. Add book");
		System.out.println("2. Update book");
		System.out.println("3. Delete book");
		System.out.println("4. find Book by page, date");
		System.out.println("5. Find book");
		System.out.println("0. Exit");
		c=sc.nextInt();
		switch(c) {
		case 1:
			addBook(sc);
			break;
        case 2:
			updateBook(sc);
			break;
        case 3:
	        deleteBook(sc);
	        break;
        case 4:
	        findReangeofBook(sc);
	        break;
        case 5:
	findBook(sc);
	break;
	default:
		System.out.println("wrong Input");
		}
		
	}while(c!=0);
	sc.close();
}

private static void findReangeofBook(Scanner sc) {
	System.out.println("Enter Book page Start");
	int start=sc.nextInt();
	System.out.println("Enter Book page end");
	int end=sc.nextInt();
	System.out.println("Enter public year");
	String y=sc.next();
	
	BookInterface inter=new BookImpl();
	try {
	List <Book> list=inter.findBookByPageYear(start, end, y);
		list.forEach(a->System.out.println(a));
	} catch (SomeThingWentWrong | SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	
}

private static void findBook(Scanner sc) {
	System.out.println("Enter Book Id");
	String bookCode=sc.next();
	BookInterface inter=new BookImpl();
	try {
	System.out.println(inter.findBook(bookCode));
		System.out.println("Book upated" );
	} catch (SomeThingWentWrong | SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	
}

private static void deleteBook(Scanner sc) {
	System.out.println("Enter Book Id");
	String bookCode=sc.next();
	BookInterface inter=new BookImpl();
	try {
		inter.deletebook(bookCode);
		System.out.println("Book Deleted" );
	} catch (SomeThingWentWrong | SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
}

private static void updateBook(Scanner sc) {
	System.out.println("Enter Book Id");
	String bookCode=sc.next();
	System.out.println("Enter Book name");
	String name=sc.next();
	System.out.println("Enter Book price");
	double price=sc.nextDouble();
	System.out.println("Enter Book public Date");
	LocalDate publicDate=LocalDate.parse(sc.next());
	System.out.println("Enter Book Number of page");
	int NoPage=sc.nextInt();
	System.out.println("Enter Book writer name");
	String writer=sc.next();
	
	Book b=new Book(bookCode,name,price,publicDate,NoPage,writer);
	BookInterface inter=new BookImpl();
	try {
		inter.updateBook(b);
		System.out.println("Book upated" );
	} catch (SomeThingWentWrong | SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	
}

private static void addBook(Scanner sc) {
	System.out.println("Enter Book Id");
	String bookCode=sc.next();
	System.out.println("Enter Book name");
	String name=sc.next();
	System.out.println("Enter Book price");
	double price=sc.nextDouble();
	System.out.println("Enter Book public Date");
	LocalDate publicDate=LocalDate.parse(sc.next());
	System.out.println("Enter Book Number of page");
	int NoPage=sc.nextInt();
	System.out.println("Enter Book writer name");
	String writer=sc.next();
	
	Book b=new Book(bookCode,name,price,publicDate,NoPage,writer);
	BookInterface inter=new BookImpl();
	try {
		inter.addbook(b);
		System.out.println("Book Added" );
	} catch (SomeThingWentWrong | SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
}
}
