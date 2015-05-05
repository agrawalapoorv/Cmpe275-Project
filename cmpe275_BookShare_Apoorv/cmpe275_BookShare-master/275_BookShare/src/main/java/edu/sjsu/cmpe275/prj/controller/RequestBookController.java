package edu.sjsu.cmpe275.prj.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
 














import edu.sjsu.cmpe275.prj.dao.*;
import edu.sjsu.cmpe275.prj.models.Book;
import edu.sjsu.cmpe275.prj.models.Category;
import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.models.RequestBook;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prjservices.UserRecordService;

@SuppressWarnings("unused")
@Controller
public class RequestBookController 
{
  
    private user userModel;
    private Book bookModel;
    private Category categoryModel;
    private RequestBook requestBookModel;
    HttpSession session;
    //ex ends
  //1.Creating the u.i for user sign up page
    
    @RequestMapping(value = "/requestbook",method = RequestMethod.GET)
    public ModelAndView uploadBook() {
    	requestBookModel = new RequestBook();
    	
		
       return new ModelAndView("requestbook", "requestbookdetails", requestBookModel);
    }
    @RequestMapping(value = "/requestbook",method = RequestMethod.POST)
	
    public ModelAndView initN1(@ModelAttribute("requestbookdetails")RequestBook requestbookModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response)
    {
        try 
        {
        	System.out.println("enter into ");
        	String msg=null;
        	JPAUserDAO objUser= new JPAUserDAO();
        	user tempuser = objUser.getUser(11);
        	if(!tempuser.equals(null))
        		requestbookModel1.setUserId(tempuser);
        	
        	System.out.println("in book controller    " + tempuser.getUserId() );  
        	System.out.println("7" );

        	
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "message", "message", "Message can't be empty");
            System.out.println("2" );
            
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
            	
            	/*if (!file.isEmpty()) {
                    try {
                        byte[] bytes = file.getBytes();
                        BufferedOutputStream stream =
                                new BufferedOutputStream(new FileOutputStream(new File(file.getName())));
                        stream.write(bytes);
                        stream.close();
                        System.out.println("Successfully uploaded " + file.getName() + ".");
                    } catch (Exception e) {
                    	System.out.println("Failed to upload " + file.getName() + " because some exception occured.");
                    }
                } else {
                	System.out.println("Failed to upload " + file.getName() + " because the file was empty.");
                }*/
            	
            	
            	System.out.println("3" );
            	List<ObjectError> t = bindingResult.getAllErrors();
            	
            	
            	for(ObjectError e : t)
            	{
            		System.out.println(e.getDefaultMessage() );
            		
            	}
            	

                return new ModelAndView("requestbook", "requestbookdetails", requestbookModel1);
            }
            else
            {
            	
            	System.out.println("4" );
            	requestbookModel1.setActive(1);
            	
            	
            	try
            	{
            		//session.setAttribute("userId", 11);
            	//System.out.println("returnd user id is"  + session.getAttribute("userId").toString());
            	}
            	catch(Exception ex)
            	{
            		ex.printStackTrace();
            		
            	}
            	System.out.println("6" );
            	//Integer.parseInt(session.getAttribute("userId").toString())
            	
            	
              	 
            	
            	
            	JPARequestBookDAO obj= new JPARequestBookDAO();
            	long l =obj.insert(requestbookModel1);
            	System.out.println(l);
            	
            	msg="Your Request is made successfully";
            	ModelAndView model = new ModelAndView("requestbook");
            	requestBookModel = new RequestBook();
            	model.addObject("requestbookdetails", requestBookModel);
           	 	model.addObject("Message", msg);
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("requestbook", "requestbookdetails", requestbookModel1);
        }
        
    }
    
	
	
	
	
	
	
}
