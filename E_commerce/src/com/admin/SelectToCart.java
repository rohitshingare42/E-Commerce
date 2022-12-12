package com.admin;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class SelectToCart {
		
		public void GetSelectproduct(int product_id, String product_name, int product_price,int product_quantity, String product_discription) throws SQLException {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root");
				
				PreparedStatement pps= connection.prepareStatement("insert into cart(product_id,product_name,product_price,product_quantity,product_discription)values(?,?,?,?,?,)");
						pps.setInt(1, product_id );	
						pps.setString(2, product_name);
						pps.setInt(3, product_price);
						pps.setInt(4, product_quantity);
						pps.setString(5, product_discription);
					  pps.executeUpdate();	
					  
					  
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
}
