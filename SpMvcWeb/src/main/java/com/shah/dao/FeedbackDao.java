package com.shah.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shah.entity.Feedback;

@Component
public class FeedbackDao 
{
	@Autowired
	private SessionFactory sessionFactory; //to connect to db
	
	
	@Transactional //somehow asks spring to do the query? & to achieve commit and rollback
	public void addFeedback(Feedback feedback)
	{
		System.out.println("in addFeedback " + feedback);
		
		Session session = sessionFactory.getCurrentSession();
		session.save(feedback);
	}

	//retrieve list of feedback
	@Transactional
	public List<Feedback> getFeedbacks() {
		System.out.println("hi");
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Feedback");
		List<Feedback> l = (List<Feedback>) q.list(); //convert Query type to List type
		System.out.println(l);
		return l;	 
	}
}