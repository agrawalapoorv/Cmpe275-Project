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
public class CategoryController {
 
    
    
   
    
   
    
    private user userModel;
    
    private Book bookModel;
    private Category categoryModel;
    HttpSession session;
    
    
    
    
    //ex ends
  //1.Creating the u.i for user sign up page
    
    @RequestMapping(value = "/category",method = RequestMethod.GET)
    public ModelAndView uploadCategory() {
    	categoryModel = new Category();
    	
		
       return new ModelAndView("category", "categorydetails", categoryModel);
    }
    
    
    @RequestMapping(value = "/category",method = RequestMethod.POST)
    public ModelAndView recieveCategory(@ModelAttribute("categorydetails")Category categoryModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response) 
    {
        try 
        {
        	String msg=null;
           
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"name","name", "Name can't be empty");
            
            
            
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
                return new ModelAndView("category", "categorydetails", categoryModel1);
            }
            else
            {
            	
            	
            	categoryModel1.setActive(1);
            	
            	JPACategoryDAO obj= new JPACategoryDAO();
            	long l =obj.insert(categoryModel1);
            	System.out.println(l);
            	
            	msg="Your Category is entered successfully";
            	ModelAndView model = new ModelAndView("category");
            	categoryModel = new Category();
            	
            	model.addObject("categoryDetails", categoryModel);
           	 	model.addObject("Message", msg);
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("category", "categorydetails", categoryModel1);
        }
        
    }
    
   

    
   

}