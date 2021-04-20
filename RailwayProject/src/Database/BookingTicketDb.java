package Database;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BookingTicketDb {
	private static final String bookTicket="UPDATE `ticket` SET `status`='booked' WHERE ticket_id=?";
	private static final String customerStatus="UPDATE `customer` SET `ticket_id`=? ,`Status`='1' WHERE username=?";
	public void bookTicket(String Ticket_id,String username) throws Exception
	{
		Connection con=(Connection) DBconnection.getConnection();
		PreparedStatement psmt=(PreparedStatement) con.prepareStatement(bookTicket);
		psmt.setString(1, Ticket_id);
		psmt.executeUpdate();
		PreparedStatement prep=(PreparedStatement) con.prepareStatement(customerStatus);
		prep.setString(1, Ticket_id);
		prep.setString(2, username);
		prep.executeUpdate();
		System.out.println("Booking sucessful");
	}

}
