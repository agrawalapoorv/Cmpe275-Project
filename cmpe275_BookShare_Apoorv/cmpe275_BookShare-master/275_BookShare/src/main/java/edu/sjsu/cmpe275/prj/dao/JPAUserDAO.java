package edu.sjsu.cmpe275.prj.dao;

import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.models.user;


/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPAUserDAO implements UserDAO{

	
	/*
	 * Function to add address
	 * 
	 */
	
	public int insert(user address) 
	{
		System.out.println("in user jpa");
		int addressId= 0;
		try {
			DBCrud<user> db = new DBCrud<user>();
			addressId = db.Insert(address);
			
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
	public void update(user address) {
		
		
				try {
					DBCrud<user> db = new DBCrud<user>();
					db.update(address);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}

	
	/*
	 * Function to delete address from databse
	 * 
	 */
	public void delete(user user) {
		
		
		
		try {
			DBCrud<user> db = new DBCrud<user>();
			db.delete(user);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}


	/*
	 * Function to delete address from databse
	 * 
	 */
	public int getExistingEmail(String emailId) {
		
		int result = 0;
		
		try {
			DBCrud<user> db = new DBCrud<user>();
			result = db.getExistingEmail(emailId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}
	
	
	public user getUser(int userId) {
		user tempUser = new user();
		try {
			DBCrud<user> db = new DBCrud<user>();
			tempUser=  db.get(tempUser, userId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempUser;
	}


	public int insert(HomePageModel user) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int insertUser(HomePageModel user) {
		// TODO Auto-generated method stub
		return 0;
	}


	public HomePageModel getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public void delete(HomePageModel user) {
		// TODO Auto-generated method stub
		
	}


	public boolean deleteUser(HomePageModel homepageModel) {
		// TODO Auto-generated method stub
		return false;
	}


	public void update(HomePageModel user) {
		// TODO Auto-generated method stub
		
	}


	public int updateUser(HomePageModel homepageModel) {
		// TODO Auto-generated method stub
		return 0;
	}


	public HomePageModel getUser(HomePageModel homepageModel) {
		// TODO Auto-generated method stub
		return null;
	}


	


	
}
