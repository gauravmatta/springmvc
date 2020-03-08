package com.springimplant.complaint_manager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.springimplant.complaint_manager.entities.Complaint;

public class ComplaintDao {
	
	private Session session;
	
	public ComplaintDao(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
	}

	public void insertComplaint(Complaint complaint)
	{
		session.save(complaint);
		session.flush();
	}
	
	public List<Complaint> getAllComplaints()
	{
		Query<Complaint> q=session.createQuery("from Complaint",Complaint.class);
		List<Complaint> complaints=q.list();
		return complaints;
	}
	
	public void deleteComplaint(Integer ComplaintId)
	{
		Query<Complaint> q=session.createQuery("delete form Complaint where id=" + ComplaintId,Complaint.class);
		q.executeUpdate();
	}
	
	public void close()
	{
		session.close();
	}
}