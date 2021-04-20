package Booking;

import java.util.Scanner;

import AvailabilityChecking.AvailableTickets;


public class BookTicket {
	
	public void book(String username,String password) throws Exception
	{
	     System.out.print("Name: "+username+"     ");
	     
	     System.out.println();
	     System.out.println("****------Available Number of Tickects-----***");
	     System.out.println();
	     AvailableTickets obj=new AvailableTickets();
	     obj.ticket();
	     System.out.println();
	     System.out.println("Enter the ticket_Id to book the ticket");
	     Scanner sc=new Scanner(System.in);
	     String id=sc.nextLine();
	     BookingTicketPart2 book_obj=new BookingTicketPart2();
	     book_obj.BookingMethod(id,username);
	     
	}

}
