package com.cmpe226.lms.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmpe226.lms.dao.BooksDao;
public class BooksSearchController extends HttpServlet {

	private BooksDao booksDao ;
	private static final String BOOKS_VIEW = "/showbooks.jsp";
	
	public BooksSearchController() {
		super();
		booksDao = new BooksDao();
	}
	
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward=BOOKS_VIEW;
	        String criteria = request.getParameter("criteria");
	            String param = request.getParameter("param");
	            request.setAttribute("books", booksDao.getBooksByCriteria(criteria, param));    
	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
