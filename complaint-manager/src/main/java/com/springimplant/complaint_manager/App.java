package com.springimplant.complaint_manager;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springimplant.complaint_manager.dao.ComplaintDao;
import com.springimplant.complaint_manager.entities.Complaint;
import com.springimplant.complaint_manager.entities.Utils;

@Controller
@PropertySource({"classpath:admin-properties.properties"})
public class App 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private Environment env;
	
	@Autowired
	Utils utils;
	
    @RequestMapping("/helloWorld")
    public String helloWorld()
    {
    	return "HelloWorld";
    }
    
    @RequestMapping("/fileComplaint")
    public String fileComplaint()
    {
    	Complaint complaint=new Complaint("Hello","Gaurav","gaurav@mail.com");
    	Complaint complaint1=new Complaint("Test Message","Test","test@test.com");
    	ComplaintDao complaintDao=new ComplaintDao(sessionFactory);
    	complaintDao.insertComplaint(complaint);
    	complaintDao.insertComplaint(complaint1);
    	return "fileComplaint";
    }
    
    @RequestMapping("/submitComplaint")
    public String submitComplaint(
    		@RequestParam("complaint") String complaint,
    		@RequestParam("name") String name, 
    		@RequestParam("email") String email)
    {
    	//System.out.println(complaint);
    	ComplaintDao dao=new ComplaintDao(sessionFactory);
    	Complaint comp=new Complaint(complaint,name,email);
    	dao.insertComplaint(comp);
    	return "submitComplaint";
    }
    
    @RequestMapping(name="/showComplaints",method=RequestMethod.GET)
    public String showComplaints()
    {
    	return "showEnterPassword";
    }
    
    @RequestMapping(name="/showComplaints",method=RequestMethod.POST)
    public ModelAndView showComplaintsPost(@RequestParam("pass") String pass,ModelAndView modelAndView)
    {
    	String syspass=env.getProperty("admin.password");
    	String encodedPass=utils.md5Java(pass);
    	if(encodedPass.equals(syspass))
    	{
         	ComplaintDao complaintDao=new ComplaintDao(sessionFactory);
         	List<Complaint> complaints=complaintDao.getAllComplaints();
         	modelAndView.addObject("complaints", complaints);
         	modelAndView.setViewName("showComplaints");
        	for(Complaint c:complaintDao.getAllComplaints())
        	{
        		System.out.println(c);
        	}
    	}
    	else
    	{
    		modelAndView.setViewName("showEnterPassword");
    	}
    	
    	return modelAndView;
    	
    }
}