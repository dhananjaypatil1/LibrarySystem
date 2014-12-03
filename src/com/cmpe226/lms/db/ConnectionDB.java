package com.cmpe226.lms.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	public static Connection getConnection(){
		String url = "jdbc:mysql://localhost:3306/";
		 String dbName = "library";
		 String driver = "com.mysql.jdbc.Driver";
		 String user = "root";
		 String password = "root";
		 Connection conn = null;
		
		 try{
		 Class.forName(driver).newInstance();
		 conn = DriverManager.getConnection(url+dbName, user, password);
		 System.out.println("connection successful");
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
		 return conn;
		 
	}
	
	

}
