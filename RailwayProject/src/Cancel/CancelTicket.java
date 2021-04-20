package Cancel;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Database.AvailableTicketDb;
import Database.CancelTicketDb;
import Database.DBconnection;

public class CancelTicket {
       private static final String check_tickect="SELECT `ticket_id`, `Status` FROM `customer` WHERE username=? ";
      // private static final String tickect_id="SELECT `Status` FROM `customer` WHERE username=?";
	public String cancel(String username) throws Exception
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
		   System.out.println("No booking available for this username--so u cant cancel");
	   }
	   else if(status.equals("1"))
	   {
		  // System.out.println("hi");
		   //System.out.println(status);
		   //System.out.println(ticket_id);
		   CancelTicketDb cancel_obj=new CancelTicketDb();
		   cancel_obj.canceling(username,ticket_id);
	   }
	   //return status;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("No booking available for this username");
		}
		return status;
	   
	      
	}
	
	
}
