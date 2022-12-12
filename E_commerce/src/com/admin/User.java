package com.admin;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class User {
		
		public void getUserlogin() throws SQLException {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root");
				
			String  sql ="select* from login";
			   Statement   stmt= connection.createStatement();
			    
			  ResultSet log = stmt.executeQuery(sql);
			  Scanner sc=new Scanner(System.in);
			  System.out.println("enter login id");
			      String login_id=sc.next();
			   System.out.println("enter login password");
			   String login_password=sc.next();
			  int count =0;
			  while(log.next()) {
				  
				 String s=log.getString(2);
				 
				 if(login_id.equals(s)){
					 count++;
					 System.out.println("login sucessful");
					 ShowProduct sp=new ShowProduct();
					 sp.getProductTable();
					 
				 }
				  } 
				  if(count==0) {
					  System.out.println("please enter valid login id & password if you not register then please ragister your self first");
					  UserRgister user=new UserRgister();
					   user.InputUserRegister();
				  }
				  
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				
				
			}
			
			
		}

