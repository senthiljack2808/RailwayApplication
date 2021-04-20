package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AvailableTicketDb {
	private static final String view_ticket="SELECT * FROM `ticket` WHERE STATUS='available' ";

     public ArrayList<ArrayList<String>> ticketDisplay() throws Exception
           {
       		ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
            Connection con=(Connection) DBconnection.getConnection();
            PreparedStatement psmt=(PreparedStatement) con.prepareStatement(view_ticket);
            ResultSet rs=psmt.executeQuery();
     	   	while(rs.next())
     		{
     			ArrayList<String> temp=new ArrayList<String>();
     			temp.add(rs.getString(1));
     			temp.add(rs.getString(2));
     			temp.add(rs.getString(3));

     			res.add(temp);
     		}
     	   	//System.out.println(res);
     	   	return res;
     	   	
           }
}
