package com.admin;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class MakePayment {
		public void getPayment(int payment) throws SQLException {
			
			
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your Amount");
			 int Amount = sc.nextInt();
			if(payment==Amount) {
				System.out.println("payment sucessful");   
				System.out.println("your order is place ");
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root");
					String sql = "Truncate table cart ";
					  Statement  stmt =connection.createStatement();
				         stmt.execute(sql);
						
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					}
				}else {
					System.out.println("please Enter valid Amount");
					MakePayment ap=new MakePayment();
					  ap.getPayment(payment);
				}
			}

	
}
