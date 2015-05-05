package edu.sjsu.cmpe275.prj.dao;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;

import edu.sjsu.cmpe275.prj.models.RequestBook;

public class JPARequestCategory implements RequestBookDAO {

	public int insert(RequestBook requestbook) 
	{
		System.out.println("in category jpa");
		int addressId= 0;
		try {
			DBCrud<RequestBook> db = new DBCrud<RequestBook>();
			addressId = db.Insert(requestbook);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return addressId;
		
	}


	

}
