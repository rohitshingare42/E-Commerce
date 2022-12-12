package com.admin;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class ShowProduct {
	public void getProductTable() throws SQLException {
			
			
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root");
					
					String  sql ="select* from product";
					   Statement   stmt= connection.createStatement();
					    
					  ResultSet log = stmt.executeQuery(sql);
					//  System.out.println("product_id    product_name     product_price       product_quantity      product_description ");
					   while(log.next()) {
					        //	 System.out.println(log.getInt(1)+"       "+log.getString(2)+"               "+log.getInt(3)+"              "+log.getInt(4)+"             "+log.getString(5));
					        	  System.out.println("product_id  = "+log.getInt(1));
					        	  System.out.println();
					        	  System.out.println("product_name  = "+log.getString(2));
					        	  System.out.println();
					        	  System.out.println("product_price  = "+log.getInt(3));
					        	  System.out.println();
					        	  System.out.println("product_quantity  = "+log.getInt(4));
					        	  System.out.println();
					        	  System.out.println("product_description  = "+log.getString(5));
					        	  System.out.println();
					        	  System.out.println("***************************************************");
					        	  System.out.println();
					           }
					  
					       
							
						} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
							
						}
						
					  Scanner sc=new Scanner(System.in);
					  System.out.println("Enter 0 for Accending order");
					  System.out.println("Enter 1 for select the product ");
					              String  input =sc.next();
					              
					              switch(input) {
					              case("0"):{
					           AccendingOrder ac=new AccendingOrder();
					               ac.getAccendingOrder();
					              }
					              case("1"):{
					            	  BuyProduct Bp= new BuyProduct();
					    			  Bp.getCartProduct();  
					              }
					              }
					              
					              
					              
					
				
			}	 

}
