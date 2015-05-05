package edu.sjsu.cmpe275.prj.models;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * 
	 */
	
	// Persistent Fields:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
    private int category_Id;
    
    
    
    @Column(name = "Name", length = 200)
    private String name;
    
	
    @Column(name = "Active")
    private int active;


	public int getCategoryId() {
		return category_Id;
	}


	public void setCategoryId(int categoryId) {
		this.category_Id = categoryId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	
}
