package ca.sheridancollege.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Participant;
import ca.sheridancollege.beans.QuestionAndAnswer;

@Controller
public class SurveyController {

	@GetMapping("/")
	public String index()
	{
		return "EntryPage.html";
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "EntryPage.html";
	}
	
	@GetMapping("/ParticipantData")
	public String participantData(Model model)
	{
		model.addAttribute("participant", new Participant());
		return "ParticipantData.html";
	}
	
	@PostMapping("/SurveyInitialization")
	public String surveyInitialization(@ModelAttribute(value="participant") Participant participant, HttpSession session)
	{
		session.setAttribute("participant1", participant);
		
		QuestionAndAnswer question1 = new QuestionAndAnswer();
		String question_1 = "Which feature of the web application would you like the most?";
		question1.setQuestion(question_1);
		
		QuestionAndAnswer question2 = new QuestionAndAnswer();
		String question_2 = "What do you think the web application should improve on?";
		question2.setQuestion(question_2);
		
		QuestionAndAnswer question3 = new QuestionAndAnswer();
		String question_3 = "How often do you use this web application?";
		question3.setQuestion(question_3);
		
		QuestionAndAnswer question4 = new QuestionAndAnswer();
		String question_4 = "Would you recommend this web application to other people?";
		question4.setQuestion(question_4);
		
		session.setAttribute("question1", question1);
		session.setAttribute("question2", question2);
		session.setAttribute("question3", question3);
		session.setAttribute("question4", question4);
		
		return "Question1.html";
	}
	
	@PostMapping("/Answer1")
	public String answer1(@RequestParam(value="answer1") String answer, HttpSession session)
	{
		QuestionAndAnswer question1 = (QuestionAndAnswer) session.getAttribute("question1");
		question1.setAnswer(answer);
		return "Question2.html";
	}
	
	@PostMapping("/Answer2")
	public String answer2(@RequestParam(value="answer2") String answer, HttpSession session)
	{
		QuestionAndAnswer question2 = (QuestionAndAnswer) session.getAttribute("question2");
		question2.setAnswer(answer);
		return "Question3.html";
	}
	
	@PostMapping("/Answer3")
	public String answer3(@RequestParam(value="answer3") String answer, HttpSession session)
	{
		QuestionAndAnswer question3 = (QuestionAndAnswer) session.getAttribute("question3");
		question3.setAnswer(answer);
		return "Question4.html";
	}
	
	@PostMapping("/Answer4")
	public String answer4(@RequestParam(value="answer4") String answer, HttpSession session)
	{
		QuestionAndAnswer question4 = (QuestionAndAnswer) session.getAttribute("question4");
		question4.setAnswer(answer);
		return "FinalPage.html";
	}
	
}
