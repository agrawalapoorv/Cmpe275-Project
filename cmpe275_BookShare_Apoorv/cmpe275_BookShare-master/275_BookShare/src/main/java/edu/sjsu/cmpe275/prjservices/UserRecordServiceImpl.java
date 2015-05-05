package edu.sjsu.cmpe275.prjservices;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.dao.UserDAO;

/**
 * Implementation of UserRecordService
 * @author karan
 *
 */
@Service("userRecordService")
public class UserRecordServiceImpl implements UserRecordService {
    @Autowired
    UserDAO userDAO;
 
    

	public int insertUser(HomePageModel homepageModel) {
	return userDAO.insertUser(homepageModel);
	}

	public HomePageModel getUser(HomePageModel homepageModel) {
		return userDAO.getUser(homepageModel);
		
	}

	public boolean deleteUser(HomePageModel homepageModel) {
		return userDAO.deleteUser(homepageModel);
	}

	public int updateUser(HomePageModel homepageModel) {
		return userDAO.updateUser(homepageModel);
	}
 
}