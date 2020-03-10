package com.springimplant.complaint_manager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    	Complaint complaint=new Complaint("Hello","Gaurav","gaurav@mail.com");
    	Complaint complaint1=new Complaint("Test Message","Test","test@test.com");
    	ComplaintDao complaintDao=new ComplaintDao(sessionFactory);
    	complaintDao.insertComplaint(complaint);
    	complaintDao.insertComplaint(complaint1);
    	return "fileComplaint";
    }
    
    @RequestMapping("/submitComplaint")
    public String submitComplaint(@RequestParam("complaint") String complaint)
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