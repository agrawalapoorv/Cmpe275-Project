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
public class RequestBook implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "RequestId", length=100)
	    private int requestId;
	 @ManyToOne
		@JoinColumn(name = "userId")
		private user user;
	 
	    @Column(name = "Active", length=11)
	    private int active;

	    
	    @Column(name = "Message", length = 100)
	    private String message;
	    
		public user getUserId() {
			return user;
		}

		public void setUserId(user user) {
			this.user = user;
		}
		
		public void setRequestId(int requestId) {
			this.requestId = requestId;
		}
		
		public int getRequestId() {
			return requestId;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}

		public int getActive() {
			return active;
		}


		public void setActive(int active) {
			this.active = active;
		}


}
