package com.shah.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shah.entity.Question;
import com.shah.entity.QuestionsTaken;

@Repository
public class QuestionDao {

	@Autowired
	SessionFactory sessionFactory;
	
	//this is for saving the data in question.jsp
	@Transactional
	public void saveQuestion (Question q) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(q);
		session.save(q);
	}
	
	//get all q
	@Transactional
	public List<Question> getQuestions() {
		
		Session session = sessionFactory.getCurrentSession();
		//is hql, not sql
		Query<Question> q = session.createQuery("from Question", Question.class); //execute query giving results of type Question, from Question.class
		List<Question> qq = q.list(); //convert Query to List
		return qq;
	}
	
	//get random 5 q
	@Transactional
	public List<Question> getTestQuestions() {
		
		Session session = sessionFactory.getCurrentSession();
		NativeQuery<Question> q = session.createNativeQuery("select * from Question order by rand() limit 5", Question.class);
		List<Question> qq = q.list(); //convert Query to List
		return qq;
	}
	
	//check the questions for answers
	@Transactional
	public int verify(QuestionsTaken qt) {
		
		//get all the q&a taken from test
		int qid[]= {qt.getQid1(),qt.getQid2(),qt.getQid3(),qt.getQid4(),qt.getQid5()};
		int ans[]= {qt.getAns1(),qt.getAns2(),qt.getAns3(),qt.getAns4(),qt.getAns5()};
		
		int score=0;
		
		/*how to check for results?
		  by using a simple query using qid and ans. suppose for qid=1, ans is 3.
		  so query will return 1 result. else null. this will be stored in q.
		  query is stored in 'sql'. this query will be repeated 5 times using for loop.
		  checking of asnwers will be done in db to save memory and bandwidth
		  */
		for(int i=0; i<qid.length; i++) {
			
			String sql = "select * from Question where qid="+qid[i]+" and answer='"+ans[i]+"'";
			Session session = sessionFactory.getCurrentSession();
			
			//q will contain value if answer is right. else null
			NativeQuery<Question> q = session.createNativeQuery(sql, Question.class);
			Question qq = q.uniqueResult(); //uniqueResult means return only 1 row
			if(qq!=null) //if question is correct, then qq is not null. then add to score
				score++;
		}
		System.out.println("score: "+score);
		return score;
	}
}
