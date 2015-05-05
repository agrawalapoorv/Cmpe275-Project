package edu.sjsu.cmpe275.prjservices;

import edu.sjsu.cmpe275.prj.models.HomePageModel;

/**
 * UserRecordService Interface
 * @author Karan
 *
 */
public interface UserRecordService {
 
	public int insertUser(HomePageModel homepageModel);
	public HomePageModel getUser(HomePageModel homepageModel);
	public boolean deleteUser(HomePageModel homepageModel);
	public int updateUser(HomePageModel homepageModel);
}