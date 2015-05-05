package edu.sjsu.cmpe275.prj.dao;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface BookDAO {
	public int insert(Book category);
	
	
	public void delete(Book category);
	
	public void update(Book category);
	
	
	public Book getBook(int bookId);
	
	
}
