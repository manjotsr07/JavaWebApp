package ca.sheridancollege.beans;

public class QuestionAndAnswer {

	private String question = " ";
	private String answer = " ";
	
	public QuestionAndAnswer()
	{
		
	}
	
	public QuestionAndAnswer(String question, String answer)
	{
		this.question = question;
		this.answer = answer;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	public void setQuestion(String question)
	{
		this.question = question;
	}
	
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	@Override
	public String toString()
	{
		return "QuestionAndResponse [ Question: " + getQuestion() + ", Response: " + getAnswer() + ".]";
	}
	
}
