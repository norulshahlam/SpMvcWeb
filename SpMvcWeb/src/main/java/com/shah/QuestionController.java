package com.shah;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.shah.dao.QuestionDao;
import com.shah.entity.Question;
import com.shah.entity.QuestionsTaken;

@Controller
@EnableWebMvc
public class QuestionController {
	
	@Autowired
	QuestionDao qDao;
	
	//saving data of question. all data in jsp is saved in object q
	@RequestMapping("addQuestion.htm")
	public String question() {
	
		return "question.jsp";
	}
	
	@RequestMapping("saveQuestion.htm")
	public String saveQuestion (@ModelAttribute Question q) {
		
		qDao.saveQuestion(q); 
		return "question.jsp";
	}
	
	
	//get all q
	@RequestMapping("/getQuestions")
	@ResponseBody
	public List<Question> getQuestions() {
		
		List<Question> questions = qDao.getQuestions();
		System.out.println(questions);
		
		return questions; 
		
	}
	
	//get random 5 q
	@RequestMapping("/getTestQuestions") //remove.htm to enable json
	@ResponseBody //must include if you are not returning page?
	public List<Question> test() {
		
		List<Question> questions = qDao.getTestQuestions();
		System.out.println(questions);
		return questions;
	}
	
	//go to test page
	@RequestMapping("/takeTest")
	public ModelAndView takeTest() {
		ModelAndView mv = new ModelAndView("test.jsp");
		return mv;
	}
	
	//verify test questions
	@RequestMapping("/verify.htm")
	public ModelAndView verify(@ModelAttribute QuestionsTaken qt) {
		
		int result = qDao.verify(qt); //sent qt to verify for correct answers.no of ans corrects is stored in result
		ModelAndView mv = new ModelAndView("result.jsp"); //redirect to this page
		System.out.println("questions taken: "+qt+ "\n\n result: "+result);
		mv.addObject("result",result); 
		mv.addObject("percent", result*20);
		return mv;
	}
}














