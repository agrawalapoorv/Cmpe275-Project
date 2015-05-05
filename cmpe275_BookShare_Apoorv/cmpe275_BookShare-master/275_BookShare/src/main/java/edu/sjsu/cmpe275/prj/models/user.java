package edu.sjsu.cmpe275.prj.models;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class user implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
    private int user_Id;
    
    @Column(name = "EmailID", length  = 50)
    private String emailId;
    
    @Column(name = "Name", length = 100)
    private String name;
    
    
    @Column(name = "Address", length = 500)
    private String address;
    
    @Column(name = "PhoneNumber", length = 15)
    private String phone ;
	
    
    @Column(name = "Age", length = 11)
    private int age;
	

    @Column(name = "Active")
    private int active;
    
    @Column(name = "Password", length = 100)
    private String password ;
    
    public int getUserId() {
		return user_Id;
	}


	public void setUserId(int userId) {
		this.user_Id = userId;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}

	public int getPassword() {
		return active;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
}
