package edu.sjsu.cmpe275.prj.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.Feedback;

public class JPAFeedbackDAO implements FeedbackDAO {

	public List<Feedback> getFeedbackBuyer(int BuyerId) 
	{
		List<Feedback> tempFeedbackBuyer = new ArrayList<Feedback>();
		try {
			DBCrud<Feedback> db = new DBCrud<Feedback>();
			tempFeedbackBuyer=  db.getSellerComments(BuyerId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempFeedbackBuyer;
	}
	
	public List<Feedback> getFeedbackSeller(int sellerId) 
	{
		List<Feedback> tempFeedbackBuyer = new ArrayList<Feedback>();
		try {
			DBCrud<Feedback> db = new DBCrud<Feedback>();
			tempFeedbackBuyer=  db.getBuyerComments(sellerId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempFeedbackBuyer;
	}
	

}
