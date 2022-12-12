package com.admin;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class BuyProduct {
		public void getCartProduct() throws SQLException {
			
			System.out.println(" select the product");
			 Scanner sc=new Scanner(System.in);  
			 System.out.println("");
			 System.out.println("press 1 for buy a Mobile");
			 System.out.println("");
			 System.out.println("press 2 for buy a Tv");
			 System.out.println("");
			 System.out.println("press 3 for buy a fridge");
			 System.out.println("");
			 System.out.println("press 4 for buy a AC");
			 System.out.println("");
			 System.out.println("press 5 for buy a Laptop");
			 System.out.println("");
			 System.out.println("press 6 for buy a Washing Machine");
			 System.out.println("");
			 System.out.println(" press 7 for buy a Watch");
			 System.out.println("");
			 System.out.println("press 8 for buy a Microwave");
			 System.out.println(""); 
			 System.out.println("press 9 for buy a Camera");
			 System.out.println("");
			 System.out.println("press 10 for buy a Fan");
			  int addCart =sc.nextInt();
			   System.out.println("select the quantity of product");
			             int quantity =sc.nextInt();
			   
			             try {
			 				Class.forName("com.mysql.cj.jdbc.Driver");
			 				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root");
			 				
			 				String  sql ="select* from product";
			 				   Statement   stmt= connection.createStatement();
			 				    
			 				  ResultSet cart = stmt.executeQuery(sql);
			 				  String product_name= " " ;
			 				  int product_price = 0;
			 				  String product_discription=" ";
			 				  int product_quantity=0;
			 				  while(cart.next()) {
			 					if(cart.getInt(1)==addCart) {
			 					product_name = product_name+cart.getString(2);
			 					product_price = product_price+cart.getInt(3);
			 					product_quantity = product_quantity+cart.getInt(4);
			 					product_discription = product_discription+cart.getString(5);
								
								}
								
								  
							  }
							  int price = product_price*quantity;
							  
							  
						    PreparedStatement  pps= connection.prepareStatement("insert into cart ( product_id, product_name, product_price, product_quantity, product_description)values (?,?,?,?,?)");
						    
						         pps.setInt(1, addCart );
						         pps.setString(2, product_name );
						         pps.setInt(3, price );
						         pps.setInt(4, quantity);
						         pps.setString(5, product_discription );
						         
						         pps.executeUpdate();
						         PreparedStatement pu = connection.prepareStatement("update product set product_quantity =? where product_id= ? ");
								  int quReplace=product_quantity-quantity;
								  pu.setInt(1, quReplace);
								  pu.setInt(2, addCart);
								  pu.executeUpdate();
								  
								  		
						} catch (ClassNotFoundException e) {
							
							e.printStackTrace();
						}
						AddToCart AC=new AddToCart();
						AC.getCartTable();
		}
	}
	
