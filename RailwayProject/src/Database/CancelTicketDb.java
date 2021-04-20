package Database;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CancelTicketDb {
	private static final String cancelTicket="UPDATE `ticket` SET `status`='available' WHERE ticket_id=?";
	private static final String cancelcustomer="UPDATE `customer` SET `ticket_id`='0' ,`Status`='0' WHERE username=?";
        public void canceling(String username,String ticket_id) throws SQLException {
        	Connection con=(Connection) DBconnection.getConnection();
    		PreparedStatement psmt=(PreparedStatement) con.prepareStatement(cancelTicket);
    		psmt.setString(1, ticket_id);
    		psmt.executeUpdate();
    		PreparedStatement prep=(PreparedStatement) con.prepareStatement(cancelcustomer);
    		//prep.setString(1, ticket_id);
    		prep.setString(1, username);
    		prep.executeUpdate();
    		System.out.println("Cancellation successfully done");
		}
}
