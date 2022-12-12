package com.admin;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class Purches {
		
		public void purches() throws SQLException {
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
			           Purches p=new Purches();
			            
			         Scanner scan=new Scanner(System.in);
			       	System.out.println("For make a payment enter Amount");
			       	int payment= scan.nextInt();
		            p.MakePayment(payment);
		             }
		             }
		             
		}
		
	public void MakePayment(int totalAmount) { 
		Scanner sc=new Scanner(System.in);
		System.out.println("make payment");
		int payment= sc.nextInt();
		
		
		
	}

}
