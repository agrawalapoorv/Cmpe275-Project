package edu.sjsu.cmpe275.prj.models;


import java.io.Serializable;
import java.sql.Date;

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

@Entity
public class Transaction implements Serializable
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
		@Column(name = "TransactionID", length=11)
	    private int transactionId;	
	 
	 @Column(name = "Price")
	    private int price;	
	 
	 @ManyToOne
	   @JoinColumn(name = "BuyerID")
	    private user userBuyer;

	 @ManyToOne
	   @JoinColumn(name = "SellerID")
	    private user userSeller;
	 
	 @ManyToOne
	   @JoinColumn(name = "BookID")
	    private Book book;
	 
	 public Book getBookId() {
			return book;
		}

		public void setBookId(Book book) {
			this.book = book;
		}
		
		public int getTransactonId() 
		{
			return transactionId;
		}

		public void setTransactonId(int transactionId) 
		{
			this.transactionId = transactionId;
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
		
		public int getPrice() 
		{
			return price;
		}

		public void setPrice(int price) 
		{
			this.price = price;
		}

}
