/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageMaster;

/**
 *
 * @author Somesh Mishra
 */
import mydatabase.*;
import mybeans.*;
import java.sql.*;

public class MasterMessageHelper extends BaseDAO{
    public boolean checkCID (int cid){
        boolean result=false;
		try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from crce.customer where c_id="+cid);
                        if (rs.next()){
                            result=true;
                        }
                }
                catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
		
		return result;
    }
    
    public int getDID (int cid){
        int did=-1;
        try{
            Connection con = getConnection();
			Statement stmt = con.createStatement();
                        ResultSet rs=stmt.executeQuery("select d_id from crce.customer where c_id="+cid);
                        rs.next();
                        did=Integer.parseInt(rs.getString(1));
        }
        catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return did;
    }
    
    public void insertOrder (String statement){
        try{
            Connection con = getConnection();
			Statement stmt = con.createStatement();
                        int x=stmt.executeUpdate(statement);
        }
        catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
    }
    
    public boolean checkPendingOrder (int cid){
        int c_id=cid;
        boolean result=false;
        try{
            Connection con = getConnection();
			Statement stmt = con.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from crce.ordertable where c_id="+c_id+" and status='undelivered'");
                        if (rs.next()){
                            result=true;
                        }
        }   
        catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return result;
    }
}
