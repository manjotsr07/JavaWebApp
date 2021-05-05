package ca.sheridancollege.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Book;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public long addBook(Book book)
	{
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String insert="INSERT INTO booktb(title, author, edition, yearPublished, status) VALUES(:title, :author, :edition, :yearPublished, :status);";
		namedParameters.addValue("title", book.getTitle());
		namedParameters.addValue("author", book.getAuthor());
		namedParameters.addValue("edition", book.getEdition());
		namedParameters.addValue("yearPublished", book.getYearPublished());
		namedParameters.addValue("status", book.getStatus());
		long numOfRows = jdbc.update(insert, namedParameters);
		return numOfRows;
	}
	
	public List<Book> selectBooks()
	{
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String selectQuery="SELECT * FROM booktb;";
		List<Book> list = jdbc.query(selectQuery, namedParameters, new BeanPropertyRowMapper<Book>(Book.class));
 		return list;
	}
	
	public long deleteBooks(String authorName)
	{
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String delete="DELETE FROM booktb WHERE author=:author";
		namedParameters.addValue("author", authorName);
		long numOfRowsDeleted = jdbc.update(delete, namedParameters);
		return numOfRowsDeleted;
	}
	
	public long updateBook(String bookTitle, String bookStatus)
	{
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String updateRows="UPDATE booktb SET status=:status WHERE title=:title;";
		namedParameters.addValue("title", bookTitle);
		namedParameters.addValue("status", bookStatus);
		long numOfRows = jdbc.update(updateRows, namedParameters);
		return numOfRows;
	}
	
}
