package com.admin;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class AccendingOrder {
		
		public void getAccendingOrder() throws SQLException {
			
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root");
			
			String  sql ="select* from product order by product_price asc";
			   Statement   stmt= connection.createStatement();
			    
			  ResultSet log = stmt.executeQuery(sql);
			//  System.out.println("product_id    product_name     product_price       product_quantity      product_discription ");
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
			        	  System.out.println("product_discription  = "+log.getString(5));
			        	  System.out.println();
			        	  System.out.println("***************************************************");
			        	  System.out.println();
			           }
			  
			       
					
				} catch (ClassNotFoundException e) {
					
					
					e.printStackTrace();
				}

		}
		
}
