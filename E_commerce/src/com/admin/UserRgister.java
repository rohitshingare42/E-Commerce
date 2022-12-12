package com.admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRgister { 
	
	public void  getUserRgister(String login_id,String login_password) throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root");
			
			 
		     PreparedStatement   pps = connection.prepareStatement("insert into login(login_id,login_password)values(?,?)");
		           pps.setString(1, login_id);
		           pps.setString(2, login_password);
		       
		           
		           pps.executeUpdate();
} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}
	 public void  InputUserRegister() throws SQLException {
		   Scanner sc=new Scanner(System.in);   
		   System.out.println("Enter  new login_id");
		      String login_id=sc.next();
		   System.out.println("Enter  new login_password");
		   String login_password =sc.next();
		   UserRgister ul=new UserRgister();
		      ul.getUserRgister(login_id, login_password);
		      System.out.println("Regitration succesful");
		      System.out.println("to login enter id & password ");
		      User user=new User();
		       user.getUserlogin();
	 }
}
	