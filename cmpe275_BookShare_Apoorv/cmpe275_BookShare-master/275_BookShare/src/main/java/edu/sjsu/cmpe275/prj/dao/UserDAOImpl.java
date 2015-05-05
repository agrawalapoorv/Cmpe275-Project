package edu.sjsu.cmpe275.prj.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.models.user;


 
/**
 * Implementation of the UserDao Interface
 * @author Karan
 */
@SuppressWarnings("unused")
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	
	
	/*
	 * This method inserts the record of user in db
	 * */
		public int insertUser(HomePageModel homepageModel) {
				System.out.println("I m in creatuser method");
				
				String SQL = "INSERT  INTO 275spring.user_details (id, firstname, lastname, email, address, organization, aboutMyself) values (?,?,?,?,?,?,?);";
			   
			    
			   
		       
		        try
		        {
		        	
		           
		            PreparedStatement ps= ConnectionDAO.getConnection().prepareStatement(SQL);
		            ps.setString(1, homepageModel.getId());
		            ps.setString(2, homepageModel.getFirstname());
		            System.out.println(homepageModel.getFirstname() + "<----firstname in db method----->");
		            ps.setString(3, homepageModel.getLastname());
		            ps.setString(4, homepageModel.getEmail());
		            ps.setString(5, homepageModel.getAddress());
		            ps.setString(6, homepageModel.getOrganization());
		            ps.setString(7, homepageModel.getAboutMyself());
		            
		            	
		            	if(ps.executeUpdate()==1);
		            	{
		            		
		            			System.out.println("insertion done in db");
		            			return 1;
		            	}
		            	
		           
		           
		        }
		        catch (SQLException e)
		        {
		            System.out.println("SQL Exception : "+e.getMessage());
		           
		            return 0;
		        }
				
			}
			
			/*
			 * This method retrieves  the record of user from db
			 * */
			public HomePageModel getUser(HomePageModel homepageModel) {
				System.out.println("I m in getUser method");
				String SQL = "SELECT * FROM user_details WHERE id = '"+homepageModel.getId()+"';";
		       
		        Statement stmt;
		        try
		        {
		            stmt = ConnectionDAO.getStatement();
		            ResultSet rs = stmt.executeQuery(SQL);
		            if (null!= rs && rs.next())
		            {
		            	System.out.println("user firstname is: " + rs.getString("firstname"));
		            	homepageModel.setFirstname(rs.getString("firstname"));
		            	homepageModel.setLastname(rs.getString("lastname"));
		            	homepageModel.setEmail(rs.getString("email"));
		            	homepageModel.setAddress(rs.getString("address"));
		            	homepageModel.setOrganization(rs.getString("organization"));
		            	homepageModel.setAboutMyself(rs.getString("aboutMyself"));
		            	
		            	
		                return homepageModel;
		            }
		            else
		            {
		            	
		                homepageModel.setFirstname(null);
		                return homepageModel;
		            }
		        }
		        catch (SQLException e)
		        {
		            System.out.println("SQL Exception : "+e.getMessage());
		            
		            return null;
		        }
				
			}
			
			
			/*
			 * This method deletes the record of user in db
			 * */
			public boolean deleteUser(HomePageModel homepageModel) {
				System.out.println("I m in delUser method");
				
				String SQL = "DELETE FROM user_details WHERE id = '"+homepageModel.getId()+"';";
		        System.out.println("SQL : "+ SQL);
		        Statement stmt;
		        try
		        {
		            stmt = ConnectionDAO.getStatement();
		            
		            stmt.execute(SQL);
		            
		            return true;
		        }
		        catch (SQLException e)
		        {
		            System.out.println("SQL Exception : "+e.getMessage());
		            
		            return false;
		        }
			
			}
			
			
			/*
			 * This method updates the record of user in db
			 * */
			public int updateUser(HomePageModel homepageModel)
			{
			String SQL2 = "UPDATE user_details set firstname = ?, lastname = ?, email = ?, address = ?, organization = ?, aboutMyself =? where id = ? ;";
		
		       
	        try
	        {
	        	System.out.println("in db update user method");
	        	
	        	
	           
	           
	            PreparedStatement ps= ConnectionDAO.getConnection().prepareStatement(SQL2);
	            ps.setString(1, homepageModel.getFirstname());
	            ps.setString(2, homepageModel.getLastname());
	            ps.setString(3, homepageModel.getEmail());
	            ps.setString(4, homepageModel.getAddress());
	            ps.setString(5, homepageModel.getOrganization());
	            ps.setString(6, homepageModel.getAboutMyself());
	            ps.setString(7, homepageModel.getId());
	           
	           
	            if (ps.executeUpdate()==1)
	            {
	            	System.out.println("user record updation  done in db");
	            	
	            	
	            	return 1;
	                
	            }
	            else
	            {
	            	return 0;
	            }
	            
	           
	        }
	        catch (SQLException e)
	        {
	        	System.out.println("catch in user details updation");
	            System.out.println("SQL Exception : "+e.getMessage());
	            return 0;
	           
	            
	        }
}

			public int insert(HomePageModel user) {
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

			public void update(HomePageModel user) {
				// TODO Auto-generated method stub
				
			}

			public user getUser(int userId) {
				// TODO Auto-generated method stub
				return null;
			}

			

			
}