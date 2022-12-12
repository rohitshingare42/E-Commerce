package com.admin;

	import java.sql.SQLException;
	import java.util.Scanner;

	public class Verify {
		
		public void InputLogin() throws SQLException {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the number 1 for ragistration");
			       
			System.out.println("enter the number 2 for login");
			             String condition=sc.next();
				
			             switch(condition) {
			             case ("1"):{
			          UserRgister ur=new UserRgister();
			           ur.InputUserRegister();
	break;
			           
			             }
			             case("2"):{
			           User user=new User();
			           user.getUserlogin();
			             }
			             }
			             
			
			
		}
}
