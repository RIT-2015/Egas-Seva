package mydatabase;

import java.sql.*;

public class  BaseDAO
{    
     String driver_name="com.ibm.db2.jcc.DB2Driver";
     //String db_url="jdbc:db2://localhost:50000/project:retrieveMessagesFromServerOnGetMessage=true;";
     String db_url="jdbc:db2://localhost:50000/egassewa:retrieveMessagesFromServerOnGetMessage=true;";
     String username="db2admin";
     String password="a";
     
	Connection con;
	public Connection getConnection()
	{
		try
		{
                    Class.forName(driver_name);
                    con = DriverManager.getConnection(db_url,username,password);
	/*		
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    con = DriverManager.getConnection("jdbc:odbc:xyz");
         */
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
