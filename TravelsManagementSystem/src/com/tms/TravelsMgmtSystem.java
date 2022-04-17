package com.tms;

import java.util.*;

public class TravelsMgmtSystem {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------Welcome to GLOBETROTTER Travels--------------------");
		System.out.println();
		System.out.println("-----------------ACCOUNT LOGIN or ACCOUNT REGISTRATION-----------------");
		System.out.println();
		System.out.println("Press 1 for ACCOUNT LOGIN \nPress 2 for ACCOUNT REGISTRATION \nPress 0 to EXIT");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		int choice = sc.nextInt();
		switch(choice) {
			case 1 :
				Login log = new Login();
				log.login();
				break;
			case 2 :
				Register re = new Register();
				re.register();
				break;
			case 0:
				System.out.println("EXITED");
				break;
		}
		//sc.close();
	}

}
