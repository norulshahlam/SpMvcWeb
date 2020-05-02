package com.shah;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shah.dao.FeedbackDao;
import com.shah.entity.Feedback;

@Controller
public class IndexController 
{
	
	@Autowired
	FeedbackDao fdao;

	Feedback feedback;
	
	@RequestMapping("/")
	public String home()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/feedback.htm")
	public String feedback()
	{
		return "feedback.jsp";
	}
	
	@RequestMapping("/addFeedback")
	//public String addFeedback(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("reg") String reg,@RequestParam("code") String code,@RequestParam("msg") String msg,@RequestParam("rating") int rating)
	
	public ModelAndView addFeedback(@ModelAttribute("feedback") Feedback feedback)
	{
		ModelAndView mv = new ModelAndView("welcome.jsp");
		//feedback = new Feedback(name,email,reg,code,rating);
		fdao.addFeedback(feedback);
		mv.addObject("feedback", feedback);
		return mv;
	}
	
	//view all feedback
	@RequestMapping("/viewFeedbacks")
	public ModelAndView viewFeedbacks() {
		ModelAndView mv = new ModelAndView("viewFeedback.jsp");
		mv.addObject("feedbacks",fdao.getFeedbacks());
		return mv;
	}
	
	/*//view all feedback (in json)
		@RequestMapping("/viewFeedbacks")
		@ResponseBody
		public List<Feedback> viewFeedbacks() {
			List<Feedback> feedback = fdao.getFeedbacks();
			return feedback;
		}*/
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}