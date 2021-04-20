package Booking;

import java.util.ArrayList;

import Database.AvailableTicketDb;
import Database.BookingTicketDb;

public class BookingTicketPart2 {
	
 public void BookingMethod(String id,String username) throws Exception
 {
	 int flag=0;
	 ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
      AvailableTicketDb avail_obj=new AvailableTicketDb();
      res=avail_obj.ticketDisplay();
      for(int i=0;i<res.size();i++)
      {
    	  //System.out.println(res.get(i).get(0));
    	  //System.out.println(res.get(i).get(2));
    	  String val_id=res.get(i).get(0);
    	  String val_status=res.get(i).get(2);
          if(val_id.equals(id)  && val_status.equals("available"))  
          {
        	  flag=1;
        	  CheckCustomerStatus cus_obj=new CheckCustomerStatus();
        	  boolean cus_status=cus_obj.CheckCustomerStatus(username);
        	  if(cus_status==true)
        	  {

            	  BookingTicketDb book_obj=new BookingTicketDb();
            	  book_obj.bookTicket(id,username);  
        	  }
        	  else
        	  {
        		  System.out.println("You have booked already***");
        		  break;
        	  }
        	  
        	  break;
          }
      }
      if(flag==0)
      {
    	  System.out.println("Please do enter the correct valid ticket id");
      }
    
 }
 
}
