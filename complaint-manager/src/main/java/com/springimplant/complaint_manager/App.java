package com.springimplant.complaint_manager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springimplant.complaint_manager.dao.ComplaintDao;
import com.springimplant.complaint_manager.entities.Complaint;

@Controller
public class App 
{
	@Autowired
	SessionFactory sessionFactory;
	
    @RequestMapping("/helloWorld")
    public String helloWorld()
    {
    	return "HelloWorld";
    }
    
    @RequestMapping("/fileComplaint")
    public String fileComplaint()
    {
    	Complaint complaint=new Complaint(1,"Hello","Gaurav","gaurav@mail.com");
    	ComplaintDao complaintDao=new ComplaintDao(sessionFactory);
    	complaintDao.insertComplaint(complaint);
    	return "fileComplaint";
    }
    
    @RequestMapping("/submitComplaint")
    public String submitComplaint()
    {
    	return "submitComplaint";
    }
    
    @RequestMapping(name="/showComplaints",method=RequestMethod.GET)
    public String showComplaints()
    {
      	ComplaintDao complaintDao=new ComplaintDao(sessionFactory);
    	for(Complaint c:complaintDao.getAllComplaints())
    	{
    		System.out.println(c);
    	}
    	return "showEnterPassword";
    }
    
    @RequestMapping(name="/showComplaints",method=RequestMethod.POST)
    public String showComplaintsPost()
    {
    	return "showComplaints";
    }
}