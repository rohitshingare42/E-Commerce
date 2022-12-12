package com.admin;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class AddToCart {
		public void getCartTable() throws SQLException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root");
				 String Sql="select * from cart";
				 Statement  stmt= connection.createStatement();
				  
				              ResultSet cart = stmt.executeQuery(Sql);
				              int total = 0;
				              while(cart.next()) {
				            	  
				            	  System.out.println("cart_serialNo = "+cart.getInt(1));
				            	  System.out.println();
				            	  System.out.println("product_id  = "+cart.getInt(2));
					        	  System.out.println();
					        	  System.out.println("product_name  = "+cart.getString(3));
					        	  System.out.println();
					        	  System.out.println("product_price  = "+cart.getInt(4));
					        	  System.out.println();
					        	  System.out.println("product_quantity  = "+cart.getInt(5));
					        	  System.out.println();
					        	  System.out.println("product_description  = "+cart.getString(6));
					        	  System.out.println();
					        	  System.out.println("***************************************************");
					        	  System.out.println();
					        	  total= total+cart.getInt(4);
				              }
							     System.out.println("total price is ="+total);
							 	Scanner sc=new Scanner(System.in);
								System.out.println("enter the number 0 for buy the product");
								       
								System.out.println("enter the number 1 for payment");
								
								             String condition=sc.next();
									
								             switch(condition) {
								             case ("0"):{
								          ShowProduct sp=new ShowProduct();
								           sp.getProductTable();
								           break;
								             }
								             case("1"):{
								           MakePayment mp=new MakePayment();
								           mp.getPayment(total);
								            
								       
								             }
								             }
											    
						} catch (ClassNotFoundException e) {
						
							e.printStackTrace();
								}	
					}
					
}
