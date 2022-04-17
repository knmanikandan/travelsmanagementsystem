package com.tms;

import java.util.*;
import java.sql.*;

public class Register {
	
	public static String USERNAME = "manikandan";
	public static String PASSWORD = "101010";
	public static String CONN = "jdbc:mysql://localhost/travelsmgmtsystem";
	

	public void register() {
				Scanner sc = new Scanner(System.in);
				System.out.println("----------Registration----------");
				System.out.println("Name : ");
				String name = sc.nextLine();
				System.out.println();
				System.out.println("Mobile Number : ");
				long phnum = sc.nextLong();
				System.out.println();
				System.out.println("Aadhar Number : ");
				long aadhnum = sc.nextLong();
				sc.nextLine();
				System.out.println();
				System.out.println("Address : ");
				String address = sc.nextLine();
				System.out.println();
				System.out.println("Enter Password : ");
				String pass = sc.next();
				System.out.println();
				System.out.println("ReEnter Password : ");
				String repass = sc.next();
				while(!(repass.equals(pass))) {
					System.out.println();
					System.out.println("Incorrect Password (ReEnter) : ");
					repass = sc.next();
				}
				if(repass.equals(pass)) {
					System.out.println();
					System.out.println("Password Matched");
					System.out.println();
					System.out.println("Registration Successful");
				}
				
			  //Class.forName(com.mysql.jdbc.Driver);
			  //Connection con = null;
				
				try {
					Connection con = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
					PreparedStatement stmt = con.prepareStatement("INSERT INTO registration(name,mobile_number,aadhar_number,address,password,reentered_password,no_tickets,location,price)"+"VALUES(?,?,?,?,?,?,0,0,0)");
					//System.out.println("DB Connected");
					stmt.setString(1,name);
					stmt.setLong(2,phnum);
					stmt.setLong(3,aadhnum);
					stmt.setString(4,address);
					stmt.setString(5,pass);
					stmt.setString(6,repass);
					
					stmt.execute();
					System.out.println();
					System.out.println("Press C to CONTINUE or E to EXIT");
					char c = sc.next().charAt(0);
					//sc.close();
					switch(c) {
						case 'C' :
							TravelsMgmtSystem.main(null);
							break;
						case 'E' :
							System.out.println("EXITED");
							break;
					}
				} catch(Exception e) {
					System.out.println(e);
				}
				/*finally {
					if(con != null){
						con.close();
					}
				}*/

	}

}
