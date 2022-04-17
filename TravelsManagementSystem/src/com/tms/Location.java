package com.tms;

import java.sql.*;
import java.util.*;

public class Location {
	
	public static String USERNAME = "manikandan";
	public static String PASSWORD = "101010";
	public static String CONN = "jdbc:mysql://localhost/travelsmgmtsystem";
	
	public void location(long phn) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("-----AVAILABLE DESTINATIONS AND PRICE-----");
		System.out.println();
		System.out.println("1) CHENNAI      Rs 1000");
		System.out.println("2) COIMBATORE   Rs  800");
		System.out.println("3) TIRUNELVELI  Rs  100");
		System.out.println("4) NAGERKOVIL   Rs  250");
		System.out.println("5) VELLORE      Rs  800");
		System.out.println("6) MADURAI      Rs  400");
		System.out.println("7) TRICHY       Rs  600");
		System.out.println("8) KOVILPATTI   Rs   80");
		System.out.println("9) SIVAKASI     Rs  120");
		System.out.println("10) SATTUR      Rs  100");
		System.out.println("11) RAMESHWARAM Rs  350");
		System.out.println("12) OOTY        Rs 1200");
		
		
		try {
			Connection con = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
			/*String despre = "SELECT * FROM destination_price";
			PreparedStatement ps = con.prepareStatement(despre);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int colnum = rsmd.getColumnCount();
			//System.out.println("")
			while(rs.next()) {
				for(int i=1; i<=colnum;i++) {
					if(i>1) {
						System.out.print(",  ");
					}
					String colValue = rs.getString(i);
					System.out.print(colValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}*/
			System.out.println();
			System.out.println("Type Destination : ");
			String dest = sc.next();
			System.out.println();
			String stmnt = "select * from destination_price where destination = '"+dest+"'";
			Statement s = con.createStatement();
			ResultSet re = s.executeQuery(stmnt);
	        re.next();
	        String res = re.getString("destination");
	        sc.nextLine();
	        if(dest.equals(res)) {
	        	PreparedStatement stmt = con.prepareStatement("UPDATE registration SET location = '"+dest+"' where registration.mobile_number = '"+phn+"'");
	        	stmt.executeUpdate();
	        }
	        System.out.println("Enter the number of Tickets : ");
	        int notickets = sc.nextInt();
            System.out.println();
	        PreparedStatement stmt = con.prepareStatement("UPDATE registration SET no_tickets = '"+notickets+"' where registration.mobile_number = '"+phn+"'");
        	stmt.executeUpdate();
        	int priceCal;
        	int prires = re.getInt("price");
        	priceCal = notickets*prires;
        	PreparedStatement pristmt = con.prepareStatement("UPDATE registration SET price = '"+priceCal+"' where registration.mobile_number = '"+phn+"'");
        	pristmt.executeUpdate();
        	String despre = "SELECT * FROM registration where registration.mobile_number = '"+phn+"'";
			PreparedStatement ps = con.prepareStatement(despre);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int colnum = 9;
			//System.out.println("")
			while(rs.next()) {
				for(int i=7; i<=colnum;i++) {
					if(i>7) {
						System.out.print(",  ");
					}
					String colValue = rs.getString(i);
					System.out.print(colValue + " " + rsmd.getColumnName(i));
					System.out.println("");
				}
				System.out.println("");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
