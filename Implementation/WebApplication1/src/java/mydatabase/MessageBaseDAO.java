/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;
import java.sql.*;
/**
 *
 * @author Somesh Mishra
 */
public class MessageBaseDAO {
    Connection con;
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			con = DriverManager.getConnection("jdbc:db2://127.0.0.1:50000/OZEKI","db2admin","a");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public void closeConnection()
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
