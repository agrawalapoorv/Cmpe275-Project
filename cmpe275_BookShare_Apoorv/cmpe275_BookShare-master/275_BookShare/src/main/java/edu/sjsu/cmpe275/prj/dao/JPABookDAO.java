package edu.sjsu.cmpe275.prj.dao;

import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.Book;
import edu.sjsu.cmpe275.prj.models.user;


/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPABookDAO implements BookDAO{

	
	/*
	 * Function to add address
	 * 
	 */
	
	public int insert(Book book) 
	{
		System.out.println("in category jpa");
		int addressId= 0;
		try {
			DBCrud<Book> db = new DBCrud<Book>();
			addressId = db.Insert(book);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return addressId;
	}

	
	/*
	  * function to update address tuple n the database 
	  * 
	  */
	public void update(Book book) {
		
		
				try {
					DBCrud<Book> db = new DBCrud<Book>();
					db.update(book);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}

	
	/*
	 * Function to delete address from databse
	 * 
	 */
	public void delete(Book book) {
		
		
		
		try {
			DBCrud<Book> db = new DBCrud<Book>();
			db.delete(book);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}


	public Book getBook(int bookId) {
		Book tempBook = new Book();
		try {
			DBCrud<Book> db = new DBCrud<Book>();
			tempBook=  db.get(tempBook, bookId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempBook	;
	}



	
}
