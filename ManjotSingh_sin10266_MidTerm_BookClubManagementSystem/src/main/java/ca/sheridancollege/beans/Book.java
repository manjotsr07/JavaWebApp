package ca.sheridancollege.beans;

public class Book {

	private String title;
	private String author;
	private String edition;
	private String yearPublished;
	private String status;
	
	public Book()
	{
		
	}
	
	public Book(String title, String author, String edition, String yearPublished, String status)
	{
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.yearPublished = yearPublished;
		this.status = status;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getEdition()
	{
		return edition;
	}
	
	public String getYearPublished()
	{
		return yearPublished;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public void setEdition(String edition)
	{
		this.edition = edition;
	}
	
	public void setYearPublished(String yearPublished)
	{
		this.yearPublished = yearPublished;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	@Override
	public String toString()
	{
		return "Book [ Title: " + getTitle() + ", Author: " + getAuthor() + ", Edition: " + getEdition() + 
				", Year Published: " + getYearPublished() + ", Status: " + getStatus() + ".]";
	}
	
}
