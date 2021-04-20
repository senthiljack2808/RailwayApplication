package Booking;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Database.CancelTicketDb;
import Database.DBconnection;

public class CheckCustomerStatus {
    private static final String check_tickect="SELECT `ticket_id`, `Status` FROM `customer` WHERE username=? ";
   // private static final String tickect_id="SELECT `Status` FROM `customer` WHERE username=?";
	public boolean CheckCustomerStatus(String username) throws Exception
	{
		String status="";
		String ticket_id="";
		try
		{
		
	   Connection con=(Connection) DBconnection.getConnection();
	   PreparedStatement prep=(PreparedStatement) con.prepareStatement(check_tickect);
	   prep.setString(1,username);
	   ResultSet rs=prep.executeQuery();

	   
	   while(rs.next())
	   {
		  // System.out.println("val status "+rs.getString(1));
		   ticket_id=rs.getString(1); 
		   status=rs.getString(2);
		    
		    
	   }
	   if(status==null || status.equals("0"))
	   {
		  return true;
	   }
	   else if(status.equals("1"))
	   {
		  return false;
	   }
	   //return status;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("something went wrong"+e);
		}
		return true;

	}
}