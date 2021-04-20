package AvailabilityChecking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Database.AvailableTicketDb;
import Database.DBconnection;

public class AvailableTickets {
    
	public void ticket() throws Exception
    {
		ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
		AvailableTicketDb ticket_obj=new AvailableTicketDb();
		res=ticket_obj.ticketDisplay();
		System.out.println("Ticket_id  |"+"Ticket_name |"+"Ticket_status    ");
		for(int i=0;i<res.size();i++)
		{
			for(int j=0;j<res.get(i).size();j++)
			{
				System.out.print(res.get(i).get(j) + "         |" +" ");
			}
			System.out.println();
		}
       
    }
}
