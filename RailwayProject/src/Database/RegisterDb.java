package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RegisterDb {
	  
	   private static final String insert_details="INSERT INTO `customer` ( `username`, `password`, `phoneNo`) VALUES ( ?, ?, ?);";
	   
      public void makeRegisteration(String username,String password,String phoneNum) throws SQLException
      {
    	  try
    	  {
    	  Connection con =(Connection) DBconnection.getConnection();
    	  PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(insert_details);
    	 // pstmt.setInt(1,0);
    	  pstmt.setString(1, username);
    	  pstmt.setString(2, password);
    	  pstmt.setString(3, phoneNum);
    	  pstmt.executeUpdate();
    	  System.out.println("Registeration Sucess");
    	  }
    	  catch(Exception e)
  		   {
  			System.out.println("Something went wrong: "+e);
  		    }
    	  
    	  
    	  
      }
      
}
