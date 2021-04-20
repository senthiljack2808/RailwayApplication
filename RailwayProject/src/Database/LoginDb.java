package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;



import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.*;
public class LoginDb {
	private final static String Login="select * from customer ";
	
    public boolean checkLoginDb(String username,String password) throws SQLException
    {
    	
    	Connection con=(Connection) DBconnection.getConnection();
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(Login);
		ResultSet rs=pstmt.executeQuery();
		 while(rs.next())
		   {
			   if(username.equals(rs.getString("username")))
			   {
				   if(password.equals(rs.getString("password")))
				   {
					
					  return true;
					
					   
				   }
			   }
		   }
		return false;
    }
}
