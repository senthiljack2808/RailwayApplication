package Main;

import java.sql.SQLException;
import java.util.Scanner;

import AvailabilityChecking.AvailableTickets;
import Booking.BookTicket;
import Cancel.CancelTicket;
import Database.LoginDb;
import Database.RegisterDb;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          Scanner sc=new Scanner(System.in);
          System.out.println("1. Enter to login");
          System.out.println("2. Enter to register");
          String loginOrRes=sc.nextLine();
          
          if(Integer.parseInt(loginOrRes)==1)
          {
        	  System.out.println("Enter username :");
        	  String username=sc.nextLine();
        	  System.out.println("Enter password:");
        	  String password=sc.nextLine();
        	  
        	  LoginDb obj=new LoginDb();
        	 boolean status= obj.checkLoginDb(username, password);
        	 if(status==true)
        	 {
        		 System.out.println("Welcome to Indian Railways");
        		 System.out.println("Press 1 for available seats");
        		 System.out.println("Press 2 for book ticket");
        		 System.out.println("Press 3 to cancel");
        		 System.out.println("Press 4 to Logout");
        		 while(true)
        		 {
        		 String op=sc.nextLine();
        		 if(Integer.parseInt(op)==1)
        		 {
        			AvailableTickets ticket_obj=new AvailableTickets();
        			ticket_obj.ticket();
        			
        		 }
        		 else if(Integer.parseInt(op)==2)
        		 {
        			 BookTicket book_obj=new BookTicket();
        			 book_obj.book(username,password);
        		 }
        		 else if(Integer.parseInt(op)==3)
        		 {
        			 CancelTicket cancel_ob=new CancelTicket();
        			String statusval= cancel_ob.cancel(username);
        		 }
        		 else if(Integer.parseInt(op)==4)
        		 {
        			 System.out.println("You have successfully logged out");
        			 break;
        		 }
        		 else
        		 {
        			 System.out.println("!!!!Invalid entry ********!!!!!please check option");
        		 }
        		 }
        	 }
        	 else
        	 {
        		 System.out.println("Invalid username or Password");
        	 }
        	 
          }
          else if(Integer.parseInt(loginOrRes)==2)
          {
        	  System.out.println("Enter email_id");
        	  String email=sc.nextLine();
        	  System.out.println("Enter password");
        	  String password =sc.nextLine();
        	  System.out.println("Enter phone number");
        	  String phonenumber =sc.nextLine();
        	  
        	  RegisterDb obj=new RegisterDb();
        	  obj.makeRegisteration(email, password, phonenumber);
        	  
          }
          else
          {
        	  System.out.println("Invalid entry ********!!!!!please check");
          }
	}

}
