package com.admin;
	 import java.sql.Connection;
	 import java.sql.DriverManager;
	 import java.sql.PreparedStatement;
	 import java.sql.SQLException;
	 import java.util.Scanner;

	 public class Admin{
			
			
		 public void getProductDetails( String product_name, int product_price, int product_quantity, String product_discription) throws SQLException {
			 
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root");
				
				 PreparedStatement   pps = connection.prepareStatement("insert into product(product_name,product_price,product_quantity,product_discription)values(?,?,?,?)");
		           pps.setString(1, product_name);
		           pps.setInt(2, product_price);
		           pps.setInt(3, product_quantity);
		           pps.setString(4, product_discription);
		           
		           pps.executeUpdate();
		           
		           
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	 public void  InputProductDetails() throws SQLException {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter product_name");
	      String product_name=sc.next();
	   System.out.println("Enter product_price");
	   int product_price =sc.nextInt();
	   System.out.println("Enter product_quantity");
	            int product_quantity= sc.nextInt();
	    System.out.println("Enter product_discription");
	    String product_discription=sc.next();
	    Admin ad=new Admin();
	    ad.getProductDetails(product_name, product_price, product_quantity, product_discription);
	     System.out.println("Succsfull");
	}
}
