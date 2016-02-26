/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mydatabase;
import java.sql.*;
import java.util.Collection;
import java.util.Vector;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import myBeans.*;
import mybeans.Customer;
import mybeans.Transfer;
/**
 *
 * @author Somesh Mishra
 */


public class TransferDAO extends BaseDAO

{
     boolean b;
     int pk;
    
    public Collection newTransferApplications (String name){
        Vector customers =new Vector();
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,t.newaddress,t.newlandmark,t.newcity,t.newstate,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type from crce.customer c, crce.distributor d, crce.transfer t where t.d_id=d.d_id and c.c_id=t.c_id and t.verified='waited' and d.username='"+name+"'");
			while(rs.next()){
                            Customer c=new Customer();
                            c.setAddress(rs.getString(8));
                            c.setAge(rs.getString(7));
                            c.setC_id(rs.getString(1));
                            c.setCity(rs.getString(10));
                            c.setContactno1(rs.getString(11));
                            c.setContactno2(rs.getString(12));
                            c.setCus_type(rs.getString(16));
                            c.setD_id(rs.getString(2));
                            c.setDob(rs.getString(6));
                            c.setEmail(rs.getString(14));
                            c.setFname(rs.getString(3));
                            c.setLandmark(rs.getString(9));
                            c.setLname(rs.getString(5));
                            c.setMname(rs.getString(4));
                            c.setMobile(rs.getString(13));
                            c.setNo_of_cylinder(rs.getString(15));
                            customers.add(c);
                        }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return customers;
    }
    
    public Customer getCustomerDetail (String CID, String name){
        Customer c=new Customer();
        int c_id=Integer.parseInt(CID);
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,t.newaddress,t.newlandmark,t.newcity,t.newstate,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type from crce.customer c, crce.distributor d, crce.transfer t where t.d_id=d.d_id and c.c_id=t.c_id and t.verified='waited' and d.username='"+name+"' and t.c_id="+c_id);
                        rs.next();
                        
                         c.setAddress(rs.getString(8));
                            c.setAge(rs.getString(7));
                            c.setC_id(rs.getString(1));
                            c.setCity(rs.getString(10));
                            c.setContactno1(rs.getString(11));
                            c.setContactno2(rs.getString(12));
                            c.setCus_type(rs.getString(16));
                            c.setD_id(rs.getString(2));
                            c.setDob(rs.getString(6));
                            c.setEmail(rs.getString(14));
                            c.setFname(rs.getString(3));
                            c.setLandmark(rs.getString(9));
                            c.setLname(rs.getString(5));
                            c.setMname(rs.getString(4));
                            c.setMobile(rs.getString(13));
                            c.setNo_of_cylinder(rs.getString(15));
                
                }
        catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return c;
    }
    
    public void disapproveTransferApplication (String cid){
        int c_id=Integer.parseInt(cid);
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        int x= stmt.executeUpdate("delete from crce.transfer where c_id="+c_id);
                }
        catch(Exception e){
            System.out.println(e);
        }
        closeConnection();
    }
    
    /* //////   pratik 
    public boolean changeaddress(Transfer t,int cid) throws SQLException
    {
       try{
            
           con=getConnection();
           System.out.println(t.getNewstate());
        PreparedStatement pstmt=con.prepareStatement("INSERT INTO CRCE.TRANSFER (C_ID, D_ID, NEWADDRESS, NEWCITY, NEWSTATE, VERIFIED)   VALUES (?, ?, '"+t.getNewaddr()+"', '"+t.getNewcity()+"', '"+t.getNewstate()+"', 'U')");
        pstmt.setInt(1,cid);
        pstmt.setInt(2,Integer.parseInt(t.getD_id()));
         System.out.println("create");
        pk= pstmt.executeUpdate();
        System.out.println("execute");
        
        if(pk>0)b=true;
        else b=false;

        }
        catch(Exception e)
        {System.out.println("error in transferDAO :"+e);}

        
        return b;

    }
*/
    
    
    
    
    
    public boolean changeaddress(Transfer t,int cid) throws SQLException
    {
       try{
            
           con=getConnection();
           System.out.println(t.getNewstate());
        PreparedStatement pstmt=con.prepareStatement("INSERT INTO CRCE.TRANSFER (C_ID, D_ID, NEWADDRESS, NEWCITY, NEWSTATE, VERIFIED)   VALUES (?, ?, '"+t.getNewaddr()+"', '"+t.getNewcity()+"', '"+t.getNewstate()+"', 'waited')");
        pstmt.setInt(1,cid);
        pstmt.setInt(2,Integer.parseInt(t.getD_id()));
         System.out.println("create");
        pk= pstmt.executeUpdate();
        System.out.println("execute");
        
        if(pk>0)b=true;
        else b=false;

        }
        catch(Exception e)
        {System.out.println("error in transferDAO :"+e);}

        
        return b;

    }

    public boolean checkReq(int cid){
            
            boolean res = false;
            
            try{
            
           con=getConnection();
           
        PreparedStatement pstmt=con.prepareStatement("select * from crce.transfer where c_id=?");
        pstmt.setInt(1,cid);
        
         System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
            
        
        if(rs.next())
            res=false;
        else
            res=true;
        
        System.out.println("hai kya ? :"+res);
        
            }
            catch (Exception e)
            {System.out.println("Error in transferDAO :"+e);}
           
            return res;
        }
    
    
    

}
