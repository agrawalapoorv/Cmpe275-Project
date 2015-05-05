package edu.sjsu.cmpe275.prj.dataoperations;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.sjsu.cmpe275.prj.models.Book;
import edu.sjsu.cmpe275.prj.models.Category;
import edu.sjsu.cmpe275.prj.models.Feedback;
import edu.sjsu.cmpe275.prj.models.RequestBook;
import edu.sjsu.cmpe275.prj.models.user;

/*
 * Class to perform database operation using sessionfactory object
 * perform Create, read, update, delete operation
 */
@SuppressWarnings("unused")
public class DBCrud<T> {
	Session session;
	SessionFactory s;
	public DBCrud(){}
	
	
	/*
	 * Function to save new record
	 * 
	 */
	public int Insert(T obj){
		System.out.println("in crud");
		int id = 0;
		
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		if(obj instanceof user){
			user p = (user)obj;
			id = p.getUserId();
		}
		else if(obj instanceof Category){
			Category s = (Category)obj;
			id = s.getCategoryId();
			System.out.println("in crud category " + id);
		}
		else if(obj instanceof Book){
			Book s = (Book)obj;
			id = s.getBookId();
			System.out.println("in crud book " + id);
		}
		else if(obj instanceof RequestBook){
			RequestBook s = (RequestBook)obj;
			id = s.getRequestId();
			System.out.println("in crud book " + id);
		}
		
		else if(obj instanceof Feedback){
			Feedback s = (Feedback)obj;
			id = s.getFeedbackId();
			System.out.println("in crud book " + id);
		}
		session.close();
		s.close();
		
		return id;
	}
	
	
	/*
	 * Function to reterieve tuple from database
	 * 
	 */
	@SuppressWarnings("unchecked")
	public T get(T obj, int id){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		T newR;
		newR = (T)session.get(obj.getClass(), id);
		
		session.close();
		s.close();
		
		return newR;
	}
	
	
	/*
	 * Function to update a tuple
	 * 
	 */
	public void update(T obj){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		session.close();
		s.close();
	}
	
	
	/*
	 * Function to delete a tuple
	 * 
	 */
	public void delete(T obj){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		session.close();
		s.close();
	}

	
	
	public int getExistingEmail(String emailId){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from user  where EmailID = :sCode")
				.addEntity(user.class)
				.setParameter("sCode", emailId);
				int  result = query.list().size();
		session.close();
		s.close();
		
		System.out.println("----" + result);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Feedback> getSellerComments(int buyerID){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from feedback  where BuyerID = :sCode")
				.addEntity(Feedback.class)
				.setParameter("sCode", buyerID);
				List<Feedback>  result = (List<Feedback>)query.list();
		session.close();
		s.close();
		
		System.out.println("----" + result);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Feedback> getBuyerComments(int sellerID){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from feedback  where SellerID = :sCode")
				.addEntity(Feedback.class)
				.setParameter("sCode", sellerID);
				List<Feedback>  result = (List<Feedback>)query.list();
		session.close();
		s.close();
		
		System.out.println("----" + result);
		return result;
	}
	
	
}