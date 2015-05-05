package edu.sjsu.cmpe275.prj.dao;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface CategoryDAO {
	public int insert(Category category);
	
	
	public void delete(Category category);
	
	public void update(Category category);
	
	
	public Category getCategory(int categoryId);
	
}
