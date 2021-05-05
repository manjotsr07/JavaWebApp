package ca.sheridancollege.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.Book;
import ca.sheridancollege.dao.DatabaseAccess;

@Controller
public class BookController {

	@GetMapping("/")
	public String index()
	{
		return "home.html";
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "home.html";
	}
	
	@GetMapping("/addNewBook")
	public String addNewBookForm(Model model)
	{
		model.addAttribute("book", new Book());
		return "addBook.html";
	}
	
	@GetMapping("/deleteBookInformation")
	public String deleteBookForm()
	{
		return "deleteBookInformation.html";
	}
	
	@GetMapping("/borrowBook")
	public String borrowBookForm()
	{
		return "borrowBook.html";
	}
	
	@Autowired
	private DatabaseAccess da;
	
	@PostMapping("/addNewBook")
	public String addNewBookSubmit(Model model, @ModelAttribute(value="book") Book book)
	{
		long numOfRows = da.addBook(book);
		return "addBookConfirmation.html";
	}
	
	@GetMapping("/viewBookList")
	public String viewBookList(Model model)
	{
		List<Book> bookList = da.selectBooks();
		model.addAttribute("bookList", bookList);
		return "viewBookList.html";
	}
	
	@PostMapping("/deleteBookInformation")
	public String deleteBookSubmit(Model model, @ModelAttribute(value="authorName") String authorName)
	{
		long numOfRows = da.deleteBooks(authorName);
		
		if(numOfRows>=1)
		{
			return "deleteBookConfirmationSuccessful.html";
		}
	
		else
		{
			return "deleteBookConfirmationUnsuccessful.html";
		}
		
	}
	
	@PostMapping("/borrowBook")
	public String borrowBookSubmit(Model model, @ModelAttribute(value="bookTitle") String bookTitle, @ModelAttribute(value="bookStatus") String bookStatus)
	{
		
		long numOfRows = da.updateBook(bookTitle, bookStatus);
		
		if(numOfRows==1)
		{
			return "borrowBookConfirmationSuccessful.html";
		}
	
		else
		{
			return "borrowBookConfirmationUnsuccessful.html";
		}
		
	}
	
}
