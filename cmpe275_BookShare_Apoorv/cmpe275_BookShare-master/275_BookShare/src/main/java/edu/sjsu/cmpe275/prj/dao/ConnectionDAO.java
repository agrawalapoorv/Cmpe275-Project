package edu.sjsu.cmpe275.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Connection manager class.
 * @author Karan
 *
 */
public class ConnectionDAO
{
    static Connection connki;
 
    /**
     * This method returns the connection object.
     * @return Connection
     */
    public static Connection getConnection()
    {
    	//String url = "jdbc:mysql://127.0.0.1:3306/";
    			String url = "jdbc:mysql://cmpe275bookshare.cpusgzoh9nxr.us-west-1.rds.amazonaws.com:3306/";
    			String dbName ="booksharedb"; // here the name of Database.
    			String uname = "team8"; //username
    			String pwd = "team8_275"; //password
    	 
    			//MySQL jdbc driver
    			//Class.forName("com.mysql.jdbc.Driver");
    			try {
    			    System.out.println("Loading driver...");
    			    Class.forName("com.mysql.jdbc.Driver");
    			    System.out.println("Driver loaded!");
    			  } catch (ClassNotFoundException e) {
    			    throw new RuntimeException("Cannot find the driver in the classpath!", e);
    			  }
    			try
    			{
    			    
    			       connki = DriverManager.getConnection(url+dbName,uname,pwd);
    				//conk = DriverManager.getConnection(url);
    			        System.out.println(" !!! got db conk from rds !!! ");
    			    
    			}
    			catch (SQLException ex)
    			{
    			    System.out.println("SQL Exception occurred while getting connection object. \nDetails : "+ ex.getMessage());
    			}
    	        return connki;
    	    }
    
            
 
    /**
     * This method returns the Statement object to execute any SQL query.
     * @return
     */
    public static Statement getStatement()
    {
        Statement stmt = null;
        try
        {
            Connection connection = ConnectionDAO.getConnection();
            stmt=connection.createStatement();
        }
        catch (SQLException e) {
            System.out.println("Exception occurred while getting Statement object. \nDetails : "+ e.getMessage());
        }
        return stmt;
    }
}