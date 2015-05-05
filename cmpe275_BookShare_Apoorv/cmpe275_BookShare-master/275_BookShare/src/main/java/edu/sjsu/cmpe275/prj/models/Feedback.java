package edu.sjsu.cmpe275.prj.models;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Feedback implements Serializable
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
		@Column(name = "FeedbackID", length=100)
	    private int feedbackId;
	 
	 @Column(name = "SellerRating", length=10)
	    private int sellerRating;
	 
	 @Column(name = "BuyerRating", length=10)
	    private int buyerRating;
	 
	 @Column(name = "SellerComments", length=1000)
	    private String sellerComments;
	 
	 @Column(name = "BuyerComments", length=1000)
	    private String buyerComments;
	 
	/*
	 @Column(name = "FeedbackTime")
	    private Date feedbacktime;
	    */
	 
	 @Column(name="FeedbackTime", insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	 private Timestamp feedbacktime;
	 
	 
	 
	 @ManyToOne
	@JoinColumn(name = "SellerID")
	private user userSeller;
	 
	 @ManyToOne
		@JoinColumn(name = "BuyerID")
		private user userBuyer;
	 
	 @ManyToOne
		@JoinColumn(name = "TransactionID")
		private Transaction transaction;
	 
	 
	 
	 public Transaction getTransactionId() {
			return transaction;
		}

		public void setTransactionId(Transaction transaction) {
			this.transaction = transaction;
		}
	 
		public user getBuyerId() {
			return userBuyer;
		}


		public void setBuyerId(user userBuyer) {
			this.userBuyer = userBuyer;
		}
		
		public user getSellerId() {
			return userSeller;
		}


		public void setSellerId(user userSeller) {
			this.userSeller = userSeller;
		}
		public int getFeedbackId() 
		{
			return feedbackId;
		}

		public void setFeedbackId(int feedbackId) 
		{
			this.feedbackId = feedbackId;
		}
	 
		public int getSellerRating() 
		{
			return sellerRating;
		}
		
		 public Timestamp getFeedbackTime() 
		{
			return feedbacktime;
		}

		public void setFeedbackTime(Timestamp feedbacktime) 
		{
			this.feedbacktime = feedbacktime;
		}
	
		

		public void setSellerRating(int sellerRating) 
		{
			this.sellerRating = sellerRating;
		}
		
		public int getBuyerRating() 
		{
			return buyerRating;
		}

		public void setBuyerRating(int buyerRating) 
		{
			this.buyerRating = buyerRating;
		}
		
		public String getSellerComments() 
		{
			return sellerComments;
		}

		public void setSellerComments(String sellerComments) 
		{
			this.sellerComments = sellerComments;
		}
		
		public String getBuyerComments() 
		{
			return buyerComments;
		}

		public void setBuyerComments(String buyerComments) 
		{
			this.buyerComments = buyerComments;
		}
		
		
		
}
