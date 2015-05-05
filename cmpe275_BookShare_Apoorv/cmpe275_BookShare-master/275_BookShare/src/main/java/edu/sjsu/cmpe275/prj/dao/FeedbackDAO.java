package edu.sjsu.cmpe275.prj.dao;


import java.util.List;

import edu.sjsu.cmpe275.prj.models.Feedback;

public interface FeedbackDAO {
	
	public List<Feedback> getFeedbackBuyer(int BuyerID);
	
	public List<Feedback> getFeedbackSeller(int sellerId);

}
