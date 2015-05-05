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
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class BookController {
	
    private user userModel;
    private Book bookModel;
    private Category categoryModel;
    HttpSession session;
    //ex ends
  //1.Creating the u.i for user sign up page
    @RequestMapping(value = "/bookhome",method = RequestMethod.GET)
    public ModelAndView uploadBook() {
    	bookModel = new Book();
    	
		
       return new ModelAndView("bookhome", "bookdetails", bookModel);
    }
    
    
    @RequestMapping(value = "/bookhomeUpdate",method = RequestMethod.GET)
    public ModelAndView updateBook() {
    	bookModel = new Book();
    	JPABookDAO obj= new JPABookDAO();
    	bookModel = obj.getBook(1);
		
       return new ModelAndView("bookhomeUpdate", "bookdetails", bookModel);
    }
    
    @RequestMapping(value = "/bookhome",method = RequestMethod.POST)
    public ModelAndView initN1(@ModelAttribute("bookdetails")Book bookModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response,
             @RequestParam(value="categoryX") int  categoryId) 
    {
        try 
        {
        	String msg=null;
           
        	System.out.println("in book controller" + categoryId );
        	JPAUserDAO objUser= new JPAUserDAO();
        	user tempuser = objUser.getUser(11);
        	if(!tempuser.equals(null))
        		bookModel1.setUserId(tempuser);
        	
        	System.out.println("in book controller    " + tempuser.getUserId() );  
        	System.out.println("7" );
        	
        	JPACategoryDAO objCat= new JPACategoryDAO();
        	Category tempCat = objCat.getCategory( categoryId);
        	if(!tempCat.equals(null))
        		bookModel1.setCategoryId(tempCat);
        	
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "title", "title", "Title can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"author","author", "Author can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "isbn", "isbn", "ISBN can't be empty");
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"condition","condition", "Condition can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "pickupAddress", "pickupAddress", "Pickup Address can't be empty");
            
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
            	
            	
            	
            	
            	
            	
            	
            	
                return new ModelAndView("bookhome", "bookdetails", bookModel1);
            }
            else
            {
            	
            	System.out.println("4" );
            	bookModel1.setActive(1);
            	bookModel1.setStatus("New");
            	
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
            	
            	System.out.println("returnd cat id is"  + tempCat.getCategoryId());
              	 
            	
            	
            	JPABookDAO obj= new JPABookDAO();
            	long l =obj.insert(bookModel1);
            	System.out.println(l);
            	
            	msg="Your Book is uploaded successfully";
            	ModelAndView model = new ModelAndView("bookhome");
            	bookModel = new Book();
            	model.addObject("bookDetails", bookModel);
           	 	model.addObject("Message", msg);
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("bookhome", "bookdetails", bookModel1);
        }
        
    }
    
    
    @RequestMapping(value = "/bookhomeUpdate",method = RequestMethod.POST)
    public ModelAndView updateBook(@ModelAttribute("bookdetails")Book bookModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response,
             @RequestParam(value="categoryX") int  categoryId) 
    {
        try 
        {
        	String msg=null;
           
        	System.out.println("in book update controller" + categoryId );
        	JPAUserDAO objUser= new JPAUserDAO();
        	user tempuser = objUser.getUser(11);
        	if(!tempuser.equals(null))
        		bookModel1.setUserId(tempuser);
        	
        	System.out.println("in book controller    " + tempuser.getUserId() );  
        	System.out.println("7" );
        	
        	JPACategoryDAO objCat= new JPACategoryDAO();
        	Category tempCat = objCat.getCategory( categoryId);
        	if(!tempCat.equals(null))
        		bookModel1.setCategoryId(tempCat);
        	
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "title", "title", "Title can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"author","author", "Author can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "isbn", "isbn", "ISBN can't be empty");
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"condition","condition", "Condition can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "pickupAddress", "pickupAddress", "Pickup Address can't be empty");
            
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
            	
                return new ModelAndView("bookhome", "bookdetails", bookModel1);
            }
            else
            {
            	
            	System.out.println("4" );
            	bookModel1.setActive(1);
            	bookModel1.setStatus("New");
            	
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
            	
            	System.out.println("returnd cat id is"  + tempCat.getCategoryId());
              	 
            	
            	
            	JPABookDAO obj= new JPABookDAO();
            	Book updateBookObj = obj.getBook(bookModel1.getBookId());
            	
            	
            	updateBookObj.setActive(bookModel1.getActive());
            	updateBookObj.setAuthor(bookModel1.getAuthor());
            	updateBookObj.setCategoryId(bookModel1.getCategoryId());
            	updateBookObj.setCondition(bookModel1.getCondition());
            	updateBookObj.setDescription(bookModel1.getDescription());
            	updateBookObj.setIsbn(bookModel1.getIsbn());
            	updateBookObj.setKeywords(bookModel1.getKeywords());
            	updateBookObj.setPickupAddress(bookModel1.getPickupAddress());
            	updateBookObj.setPictureId(bookModel1.getPictureId());
            	updateBookObj.setPrice(bookModel1.getPrice());
            	updateBookObj.setStatus(bookModel1.getStatus());
            	updateBookObj.setTitle(bookModel1.getTitle());
            	obj= new JPABookDAO();
            	obj.update(updateBookObj);
            	
            	msg="Your Book is uploaded successfully";
            	ModelAndView model = new ModelAndView("bookhome");
            	bookModel = new Book();
            	model.addObject("bookDetails", bookModel);
           	 	model.addObject("Message", msg);
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("bookhome", "bookdetails", bookModel1);
        }
        
    }

    
   

}