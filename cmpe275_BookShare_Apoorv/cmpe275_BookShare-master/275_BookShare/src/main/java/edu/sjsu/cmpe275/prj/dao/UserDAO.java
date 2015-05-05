package edu.sjsu.cmpe275.prj.dao;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface UserDAO {
	public int insert(HomePageModel user);
	public int insertUser(HomePageModel user);
	public HomePageModel getAll();
	public void delete(HomePageModel user);
	public boolean deleteUser(HomePageModel homepageModel);
	public void update(HomePageModel user);
	public int updateUser(HomePageModel homepageModel);
	public HomePageModel getUser(HomePageModel homepageModel);
	public user getUser(int userId);
	
	
}
