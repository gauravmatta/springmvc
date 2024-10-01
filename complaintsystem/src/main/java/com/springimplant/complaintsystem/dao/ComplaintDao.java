package com.springimplant.complaintsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springimplant.complaintsystem.entities.Complaint;

import jakarta.persistence.TypedQuery;

public class ComplaintDao {
	
	private Session session;
	
	public ComplaintDao(SessionFactory factory) {
		session = factory.openSession();
	}
	
	public void insertComplaint(Complaint complaint) {
		Transaction tx = session.beginTransaction();  
		session.persist(complaint);
		session.flush();
		tx.commit();
	}
	
	public List<Complaint> getAllComplaints(){
		TypedQuery<Complaint> q = session.createQuery("select c from Complaint c",Complaint.class);
		return q.getResultList();
	}
	
	public int deleteComplaint(Integer complaintId) {
		TypedQuery<Integer> q = session.createQuery("delete from Complaint c where id = :id",Integer.class);
		q.setParameter("id", complaintId);
		return q.executeUpdate();	
	}
	
	public void close() {
		session.close();
	}

}
