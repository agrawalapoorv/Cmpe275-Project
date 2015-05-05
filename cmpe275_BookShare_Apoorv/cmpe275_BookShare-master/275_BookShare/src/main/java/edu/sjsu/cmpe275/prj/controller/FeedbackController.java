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
import edu.sjsu.cmpe275.prj.models.Feedback;
import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.models.RequestBook;
import edu.sjsu.cmpe275.prj.models.Transaction;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prjservices.UserRecordService;

@SuppressWarnings("unused")
@Controller
public class FeedbackController 
{
	  private user userModel;
	    private Book bookModel;
	    private Category categoryModel;
	    HttpSession session;
	    private Feedback feedbackbuyerModel;
	    private Transaction transaction;
	    List<Feedback> str;
	    
	    @RequestMapping(value = "/feedbackbuyer/{buyerId}",method = RequestMethod.GET)
	    public ModelAndView uploadFeedback(@PathVariable int buyerId) 
	    {
	    	JPAFeedbackDAO j=new JPAFeedbackDAO();
	    	str=j.getFeedbackBuyer(buyerId);
	    	//feedbackbuyerModel = new FeedbackBuyer();
	       //return new ModelAndView("feedbackbuyer", "str", str);
	       ModelAndView model = new ModelAndView("feedbackbuyer");
	       if(str.size() > 0)
	       {
	    	   model.addObject("buyerName", str.get(0).getBuyerId().getName());
	    	   model.addObject("buyerId", str.get(0).getBuyerId().getUserId());
	       }
	       model.addObject("str", str);
			return model;

	    }
	    
	    @RequestMapping(value = "/feedbackseller/{sellerId}",method = RequestMethod.GET)
	    public ModelAndView uploadFeedbackSeller(@PathVariable int sellerId) 
	    {
	    	JPAFeedbackDAO j=new JPAFeedbackDAO();
	    	str=j.getFeedbackSeller(sellerId);
	    	//feedbackbuyerModel = new FeedbackBuyer();
	       //return new ModelAndView("feedbackbuyer", "str", str);
	       ModelAndView model = new ModelAndView("feedbackseller");
	       if(str.size() > 0)
	       {
	    	   model.addObject("sellerName", str.get(0).getSellerId().getName());
	    	   model.addObject("buyerId", str.get(0).getSellerId().getUserId());
	       }
	       model.addObject("str", str);
			return model;

	    }
}
