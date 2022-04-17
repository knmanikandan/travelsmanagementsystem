package com.tms;

import java.util.*;
import java.sql.*;

public class Login {
	
	public static String USERNAME = "manikandan";
	public static String PASSWORD = "101010";
	public static String CONN = "jdbc:mysql://localhost/travelsmgmtsystem";
	
	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Phone Number : ");
		long logphnno = sc.nextLong();
		System.out.println();
		long phn = logphnno;
		try {
			Connection con = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
			String stmnt = "select * from registration where mobile_number = "+ logphnno;
			Statement s = con.createStatement();
			ResultSet re = s.executeQuery(stmnt);
	        re.next();
	        String res = re.getString("password");
	        sc.nextLine();
	        System.out.print("Enter password : \n");
	        String password = sc.nextLine();
	        System.out.println();
	        while(!(res.equals(password)))
	        {
	            System.out.println("Incorrect Password");
	            System.out.print("ReEnter Password : ");
	            password = sc.nextLine();
	            System.out.println();
	        }
	        if(res.equals(password))
	        {
	            System.out.println("Login Successful");
	            System.out.println();
	        }
	        System.out.println("Do you need to Book Tickets : Y or N");
	        char c = sc.next().charAt(0);
	        switch(c) {
				case 'Y' :
					Booking book = new Booking();
					book.booking(phn);
					break;
				case 'N' :
					System.out.println("EXITED");
					break;
	        }
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
