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
public class Book implements Serializable {
	
	/**
	 * 
	 */
	

	// Persistent Fields:
	
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "BookID")
	    private int bookId;
	
	
  
	//@Column(name = "UserID")
    //private int userId;
	 @ManyToOne
	@JoinColumn(name = "userId")
	private user user;

    
		@ManyToOne
	   @JoinColumn(name = "categoryId")
	    private Category category;
	
    @Column(name = "Title", length  = 100)
    private String title;
    
    @Column(name = "Author", length = 100)
    private String author;
    
    
    @Column(name = "ISBN", length = 100)
    private String isbn;
    
    @Column(name = "Description", length = 500)
    private String description ;
	
   
    @Column(name = "PictureID", length = 500)
    private String pictureId ;
    
    
    
    @Column(name = "Price")
    private double price;
	

    @Column(name = "Conditions")
    private String condition;
    
    @Column(name = "Keywords")
    private String keywords;
    
    
 
    
    @Column(name = "Status")
    private String status;
    
    @Column(name = "PickupAddress")
    private String pickupAddress;
    
    
    @Column(name = "Active")
    private int active;


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public user getUserId() {
		return user;
	}


	public void setUserId(user user) {
		this.user = user;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPictureId() {
		return pictureId;
	}


	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public String getKeywords() {
		return keywords;
	}


	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public Category getCategoryId() {
		return category;
	}


	public void setCategoryId(Category category) {
		this.category = category;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPickupAddress() {
		return pickupAddress;
	}


	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	/*
    private int categoryX;


	public int getCategoryX() {
		return categoryX;
	}


	public void setCategoryX(int categoryX) {
		this.categoryX = categoryX;
	}
    
    
*/

	
}
