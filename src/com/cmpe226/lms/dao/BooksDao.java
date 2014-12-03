package com.cmpe226.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cmpe226.lms.db.ConnectionDB;
import com.mysql.jdbc.StringUtils;


public class BooksDao {

	private static final String SELECT_QUERY = "SELECT * from book";
	private static final String WHERE_CLAUSE = "WHERE";
	private static final String AUTHOR_CLAUSE = "author = ?";
	private static final String BOOK_NAME_CLAUSE = "book_name = ?";
	private static final String PUBLICATION_CLAUSE = "publication_id IN (SELECT publication_id FROM publication where publication_name = ?)";
	
	private static final String QUERY_END = ";";
	

	

	public List<Book> getBooksByCriteria(String criteria, String param){
		List<Book> books = new ArrayList<Book>();
		//remove this if to show all the books by default
		if(StringUtils.isNullOrEmpty(criteria)){
			return books;
		}
		Book book = null;
	//	List<Books> b = new ArrayList<Books>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs;
		conn = ConnectionDB.getConnection();

		
	
		try { 
			String query = SELECT_QUERY+" ";
			
			System.out.println(param);
			if(StringUtils.isNullOrEmpty(criteria)){
				query +=QUERY_END;
			} else if("author".equalsIgnoreCase(criteria)){
				query+=WHERE_CLAUSE+" "+AUTHOR_CLAUSE+" "+QUERY_END;
			} else if("publisher".equalsIgnoreCase(criteria)){
				query+=WHERE_CLAUSE+" "+PUBLICATION_CLAUSE+" "+QUERY_END;
			} else if("book".equalsIgnoreCase(criteria)){
				query+=WHERE_CLAUSE+" "+BOOK_NAME_CLAUSE+" "+QUERY_END;
			}
			System.out.println(query);
			ps  = conn.prepareStatement(query);
			if(!StringUtils.isNullOrEmpty(criteria)){
				ps.setString(1, param);
			} 
		   rs = ps.executeQuery();
		    System.out.println(rs.getStatement());
			while(rs.next()){
		    book = new Book();
			book.setBookId(rs.getInt("book_id"));
			book.setBookName(rs.getString("book_name"));
			book.setBookAuthor(rs.getString("author"));
			book.setBookEdition(rs.getString("edition"));
			book.setPublicationYear(rs.getInt("publication_year"));
			book.setBookQuantity(rs.getInt("quantity"));
			book.setBookEdition(rs.getString("edition"));
			book.setFloor(rs.getInt("floor"));
			System.out.println(book);
			books.add(book);
			} 
		
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return books;
	}
	
	public static void main(String[] args) {
	BooksDao booksDao = new BooksDao();
	booksDao.getBooksByCriteria("author","barney");
		
	}
	
	

}
