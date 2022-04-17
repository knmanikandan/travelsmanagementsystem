package com.tms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bus {

	public static String USERNAME = "manikandan";
	public static String PASSWORD = "101010";
	public static String CONN = "jdbc:mysql://localhost/travelsmgmtsystem";
	
	public void bus(int notickets, String bsno) {
		try {
			Connection con = DriverManager.getConnection(CONN, USERNAME, PASSWORD);
			PreparedStatement stmt = null;
			//System.out.println("DB Connected");
						
			String ins = "insert into "+bsno+"(booked_seats) values("+notickets+")";
			stmt = con.prepareStatement(ins);
			stmt.executeUpdate();
			
			String cap = "select * from "+bsno+" where booked_seats = "+notickets;
			Statement s = con.createStatement();
			ResultSet re = s.executeQuery(cap);
	        re.next();
	        int res = re.getInt("capacity");
			
			int ava = res-notickets;
			
			String cpins = "update "+bsno+" set avai_seats = "+ava+" where booked_seats = "+notickets;
			stmt = con.prepareStatement(cpins);
			stmt.executeUpdate();
			
			//ALTER TABLE `bus1` CHANGE `capacity` `capacity` INT(2) NOT NULL DEFAULT '20';
			
			String avalt = "ALTER TABLE `"+bsno+"` CHANGE `avai_seats` `avai_seats` INT(2) NULL DEFAULT '"+ava+"'";
			stmt = con.prepareStatement(avalt);
			stmt.executeUpdate();
			
			String alt = "ALTER TABLE `"+bsno+"` CHANGE `capacity` `capacity` INT(2) NOT NULL DEFAULT '"+ava+"'";
			stmt = con.prepareStatement(alt);
			stmt.executeUpdate();
			
			String prt = "select * from "+bsno;
			Statement p = con.createStatement();
			ResultSet rs = p.executeQuery(prt);
	        while(rs.next())
	        {
	        	int capacity = re.getInt("capacity");
	        	System.out.print(capacity+"\t");
	        	int booked = re.getInt("booked_seats");
	        	System.out.print(booked+"\t");
	        	int availability = re.getInt("avai_seats");
	        	System.out.println(availability);
	        }
			
//			
//			String pr = "update registration set price = "+price+" where mobile_number = "+phn;
//			stmt = con.prepareStatement(pr);
//			stmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
