/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;

/**
 *
 * @author Somesh Mishra
 */
import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.internet.MailDateFormat;
import mybeans.CustomerOrder;
import mybeans.Order;

public class OrderDAO extends BaseDAO {
    
    private String p;
    private int d;
    
    public Collection lpgOrderDis (String name){
       Vector custorder = new Vector ();               
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,c.address,c.landmark,c.city,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type,o.o_date,o.deliver_date,o.no_of_cylinders,o.o_id from crce.customer c, crce.ordertable o,crce.distributor d where o.d_id=d.d_id and o.c_id=c.c_id and o.status='delivered' and d.username='"+name+"'");
                        while(rs.next()){
                            CustomerOrder c=new CustomerOrder();
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
                            c.setO_date(rs.getString(17));
                            c.setDeliver_date(rs.getString(18));
                            c.setNo_of_cylinders(rs.getString(19));
                            c.setO_id(rs.getString(20));
                            c.setStatus("delivered");
                            custorder.add(c);
                        }
                        
                        rs=stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,c.address,c.landmark,c.city,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type,o.o_date,o.deliver_date,o.no_of_cylinders,o.o_id from crce.customer c, crce.ordertable o,crce.distributor d where o.d_id=d.d_id and o.c_id=c.c_id and o.status='undelivered' and d.username='"+name+"'");
                        
                        while(rs.next()){
                            CustomerOrder c=new CustomerOrder();
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
                            c.setO_date(rs.getString(17));
                            c.setDeliver_date(rs.getString(18));
                            c.setNo_of_cylinders(rs.getString(19));
                            c.setO_id(rs.getString(20));
                            c.setStatus("undelivered");
                            custorder.add(c);
                        }
                        
                         rs=stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,c.address,c.landmark,c.city,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type,o.o_date,o.deliver_date,o.no_of_cylinders,o.o_id from crce.customer c, crce.ordertable o,crce.distributor d where o.d_id=d.d_id and o.c_id=c.c_id and o.status='cancelled' and d.username='"+name+"'");
                        
                        while(rs.next()){
                            CustomerOrder c=new CustomerOrder();
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
                            c.setO_date(rs.getString(17));
                            c.setDeliver_date(rs.getString(18));
                            c.setNo_of_cylinders(rs.getString(19));
                            c.setO_id(rs.getString(20));
                            c.setStatus("cancelled");
                            custorder.add(c);
                        }
                        
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return custorder;
    }
    
    public Collection getDeliveredOrders (String name){
       Vector custorder = new Vector ();               
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,c.address,c.landmark,c.city,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type,o.o_date,o.deliver_date,o.no_of_cylinders,o.o_id from crce.customer c, crce.ordertable o,crce.distributor d where o.d_id=d.d_id and o.c_id=c.c_id and o.status='delivered' and d.username='"+name+"'");
                        while(rs.next()){
                            CustomerOrder c=new CustomerOrder();
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
                            c.setO_date(rs.getString(17));
                            c.setDeliver_date(rs.getString(18));
                            c.setNo_of_cylinders(rs.getString(19));
                            c.setO_id(rs.getString(20));
                            c.setStatus("delivered");
                            custorder.add(c);
                        }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return custorder;
    }
    
    public Collection getCancelledOrders (String name){
        Vector custorder = new Vector ();               
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,c.address,c.landmark,c.city,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type,o.o_date,o.cancel_date,o.no_of_cylinders,o.o_id from crce.customer c, crce.ordertable o,crce.distributor d where o.d_id=d.d_id and o.c_id=c.c_id and o.status='cancelled' and d.username='"+name+"'");
                        while(rs.next()){
                            CustomerOrder c=new CustomerOrder();
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
                            c.setO_date(rs.getString(17));
                            c.setCancel_date(rs.getString(18));
                            c.setNo_of_cylinders(rs.getString(19));
                            c.setO_id(rs.getString(20));
                            c.setStatus("cancelled");
                            custorder.add(c);
                        }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return custorder;
    }
    
    public Collection getPendingOrders (String name){
        Vector custorder = new Vector ();               
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,c.address,c.landmark,c.city,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type,o.o_date,o.cancel_date,o.no_of_cylinders,o.o_id from crce.customer c, crce.ordertable o,crce.distributor d where o.d_id=d.d_id and o.c_id=c.c_id and o.status='undelivered' and d.username='"+name+"'");
                        while(rs.next()){
                            CustomerOrder c=new CustomerOrder();
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
                            c.setO_date(rs.getString(17));
                            c.setCancel_date(rs.getString(18));
                            c.setNo_of_cylinders(rs.getString(19));
                            c.setO_id(rs.getString(20));
                            c.setStatus("pending");
                            custorder.add(c);
                        }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return custorder;
    }
    
    
    public void deliverLPG (String oid){
        int o_id=Integer.parseInt(oid);
         try
        {
        con=getConnection();
        Statement stmt=con.createStatement();
        
        Calendar c=Calendar.getInstance();
        SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
        String ddate=s.format(c.getTime());
        
        int x=stmt.executeUpdate("update crce.ordertable set deliver_date='"+ddate+"', status='delivered' where o_id="+o_id);
        }
        catch (Exception e){
            System.out.println(e);
        }
         closeConnection();
    }
  /*  
    public List<Order> reportOrders (String did){
        try
        {
        con=getConnection();
        Statement stmt=con.createStatement();
        stmt.executeQuery("select")
        }
        catch (Exception){
            System.out.println(e);
        }
        closeConnection();
    }
    
    */
    //Pratik//
    
    /*
    
     public Collection getBookedOrder(int cid)throws SQLException, ClassNotFoundException
    {
        Vector orders=new Vector();
        try
        {
        con=getConnection();
        //stmt=con.createStatement();

          PreparedStatement pstmt=con.prepareStatement("select * from CRCE.ORDERTABLE where C_ID=?");
        pstmt.setInt(1, cid);
        System.out.println("create");
        ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
         while(rs.next())
        {
             Order order=new Order();

                p=rs.getString("status");
             System.out.println("OK!!!"+p);
             order.setStatus(p);
             p=""+rs.getInt("o_id");
             p.trim();
             //int oid=Integer.parseInt(p);
             order.setO_id(p);
             order.setO_date(rs.getString("o_date"));
             order.setDeliver_date(rs.getString("deliver_date"));
             order.setCancel_date(rs.getString("cancel_date"));
             System.out.println("OK!!!OK!!!"+order.getStatus());
             orders.add(order);
             System.out.println("OK!!!OK!!!OK!!");
         }
        
        }
        catch(Exception e)
        {System.out.println("error in orderDOA  : "+e);}

        return orders;

    }

    public boolean deleteOrder(Order order,int cid) throws SQLException, ClassNotFoundException
    {
    boolean delete = false;
    Calendar cal = null;
    
   
   // Date date=cal.getInstance().getTime();
    cal=Calendar.getInstance();
    
    SimpleDateFormat datefor=new SimpleDateFormat("dd/MM/yyyy");
    String mydate=datefor.format(cal.getTime());
    

    try
        {
        con=getConnection();
        //stmt=con.createStatement();

          PreparedStatement pstmt=con.prepareStatement("UPDATE CRCE.ORDERTABLE SET STATUS='C', CANCEL_DATE='"+mydate+"' WHERE C_ID=? AND O_ID=?");
        pstmt.setInt(1, cid);
        pstmt.setInt(2, Integer.parseInt(order.getO_id()) );
        System.out.println("create");
       // rs= pstmt.executeQuery();
        System.out.println("execute");
        d= pstmt.executeUpdate();

        if(d>0)
            delete=true;
        else delete=false;
        }
    catch(Exception e)
    {System.out.println("error in delete : "+e);}
    
    return delete;
    }

    
    public boolean insertOrder(int c_id)
    {
     boolean add=false;
        try
        {
        con=getConnection();
        Calendar cal = null;
    Calendar cldr = null;
    boolean insert = false;
   // Date date=cal.getInstance().getTime();
    cal=Calendar.getInstance();
    cldr=Calendar.getInstance();
    SimpleDateFormat datefor=new SimpleDateFormat("dd/MM/yyyy");
    String mydate=datefor.format(cal.getTime());
    System.out.println(mydate);
    java.util.Date newdate;
   // cldr=(Calendar)date.clone();
    cldr.add(Calendar.DAY_OF_MONTH, +10);
    String deldate=datefor.format(cldr.getTime());
    System.out.println(deldate);
        
        
        
        
        

          PreparedStatement pstmt=con.prepareStatement("INSERT INTO CRCE.ORDERTABLE (C_ID,D_ID,O_DATE,NO_OF_CYLINDERS,DELIVER_DATE,CANCEL_DATE,STATUS) VALUES(?,11,?,1,?,'--','U')");
   
        pstmt.setInt(1, c_id);
         /* pstmt.setString(2, "1");
        pstmt.setString(2, mydate);
        pstmt.setString(3, deldate);
        /*pstmt.setString(5, "U");
        pstmt.setString(6, "15-3-2012");
        pstmt.setString(7, "U");
        pstmt.setString(8, "U");
        pstmt.setString(9, "U");
        pstmt.setString(10, "U");
        pstmt.setString(11, "U");
        pstmt.setString(12, "U");
        System.out.println("create");
       // rs= pstmt.executeQuery();
        
        d= pstmt.executeUpdate();
        System.out.println("execute");
        if(d>0)
            add=true;
        else add=false;
        }
    catch(Exception e)
    {System.out.println("error in insert : "+e);}
    return add;
        
    }
    
    */
    
    
     public Collection getBookedOrder(int cid)throws SQLException, ClassNotFoundException
    {
        Vector orders=new Vector();
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select * from CRCE.ORDERTABLE where C_ID=? and status=? ORDER BY O_ID DESC");
        pstmt.setInt(1, cid);
        pstmt.setString(2, "undelivered");
        System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
        while(rs.next())
        {
             Order order=new Order();
             p=rs.getString("status");
             //System.out.println("OK!!!"+p);
             order.setStatus(p);
             p=""+rs.getInt("o_id");
             p.trim();
             order.setO_id(p);
             order.setO_date(rs.getString("o_date"));
             order.setDeliver_date(rs.getString("deliver_date"));
             order.setCancel_date(rs.getString("cancel_date"));
             System.out.println("OK!!!OK!!!"+order.getStatus());
             orders.add(order);
             //System.out.println("OK!!!OK!!!OK!!");
         }
        
        }
        catch(Exception e)
        {System.out.println("error in orderDOA  : "+e);}

        return orders;

    }
     
     
     
      public Collection getCDeliveredOrders(int cid)throws SQLException, ClassNotFoundException
    {
        Vector orders=new Vector();
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select * from CRCE.ORDERTABLE where C_ID=? and status=? ORDER BY O_ID DESC");
        pstmt.setInt(1, cid);
        pstmt.setString(2, "delivered");
        System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
        while(rs.next())
        {
             Order order=new Order();
             p=rs.getString("status");
             //System.out.println("OK!!!"+p);
             order.setStatus(p);
             p=""+rs.getInt("o_id");
             p.trim();
             order.setO_id(p);
             order.setO_date(rs.getString("o_date"));
             order.setDeliver_date(rs.getString("deliver_date"));
             //order.setCancel_date(rs.getString("cancel_date"));
             System.out.println("OK!!!OK!!!"+order.getStatus());
             orders.add(order);
             //System.out.println("OK!!!OK!!!OK!!");
         }
        
        }
        catch(Exception e)
        {System.out.println("error in orderDOA  : "+e);}

        return orders;

    }
      
      
      
      
       public Collection getCCancelledOrders(int cid)throws SQLException, ClassNotFoundException
    {
        Vector orders=new Vector();
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select * from CRCE.ORDERTABLE where C_ID=? and status=? ORDER BY O_ID DESC");
        pstmt.setInt(1, cid);
        pstmt.setString(2, "cancelled");
        System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
        while(rs.next())
        {
             Order order=new Order();
             p=rs.getString("status");
             //System.out.println("OK!!!"+p);
             order.setStatus(p);
             p=""+rs.getInt("o_id");
             p.trim();
             order.setO_id(p);
             order.setO_date(rs.getString("o_date"));
             //order.setDeliver_date(rs.getString("deliver_date"));
             order.setCancel_date(rs.getString("cancel_date"));
             System.out.println("OK!!!OK!!!"+order.getStatus());
             orders.add(order);
             //System.out.println("OK!!!OK!!!OK!!");
         }
        
        }
        catch(Exception e)
        {System.out.println("error in orderDOA  : "+e);}

        return orders;

    }
     
     
     
     
     
     
     
     

    public boolean deleteOrder(Order order,int cid) throws SQLException, ClassNotFoundException
    {
        boolean delete = false;
        Calendar cal = null;
        cal=Calendar.getInstance();
        SimpleDateFormat datefor=new SimpleDateFormat("dd/MM/yyyy");
        String mydate=datefor.format(cal.getTime());
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("UPDATE CRCE.ORDERTABLE SET STATUS='cancelled', CANCEL_DATE='"+mydate+"' WHERE C_ID=? AND O_ID=?");
        pstmt.setInt(1, cid);
        pstmt.setInt(2, Integer.parseInt(order.getO_id()) );
        System.out.println("create");
        System.out.println("execute");
        d= pstmt.executeUpdate();

        if(d>0)
            delete=true;
        else delete=false;
        }
        catch(Exception e){
            System.out.println("error in delete : "+e);
        }
    
        return delete;
    }

    
    public boolean insertOrder(int c_id)
    {
     boolean add=false;
        try
        {
        con=getConnection();
       
        Calendar cal = null;
        Calendar cldr = null;
        boolean insert = false;
        cal=Calendar.getInstance();
        cldr=Calendar.getInstance();
        SimpleDateFormat datefor=new SimpleDateFormat("dd/MM/yyyy");
        String mydate=datefor.format(cal.getTime());
        System.out.println(mydate);
        java.util.Date newdate;
        cldr.add(Calendar.DAY_OF_MONTH, +10);
       String deldate=datefor.format(cldr.getTime());
       System.out.println(deldate);
       
       CustomerDAO dao=new CustomerDAO();
       int did=dao.getDid(c_id);
       
       PreparedStatement pstmt=con.prepareStatement("INSERT INTO CRCE.ORDERTABLE (C_ID,D_ID,O_DATE,NO_OF_CYLINDERS,DELIVER_DATE,CANCEL_DATE,STATUS) VALUES(?,?,?,1,?,'--','undelivered')");
       pstmt.setInt(1, c_id);
       pstmt.setInt(2,did);
       pstmt.setString(3, mydate);
       pstmt.setString(4, deldate);
       //System.out.println("create");
       d= pstmt.executeUpdate();
       //System.out.println("execute");
       
       if(d>0)
            add=true;
        else add=false;
        }
        catch(Exception e){
            System.out.println("error in insert : "+e);
        }
    return add;
        
    }

    public String getLastOrder(int cid) throws SQLException, ClassNotFoundException{
        String lastdate = null;
        
        con=getConnection();
        
        PreparedStatement pstmt=con.prepareStatement("SELECT ORDERTABLE.O_ID, ORDERTABLE.DELIVER_DATE FROM CRCE.ORDERTABLE AS ORDERTABLE WHERE ORDERTABLE.C_ID = ? ORDER BY ORDERTABLE.O_ID DESC");
        pstmt.setInt(1, cid);
       // System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        //System.out.println("execute");
        if(rs.next())
        {lastdate=rs.getString("deliver_date");
        System.out.append("Last date ;"+lastdate);
        }
        else lastdate="11/11/11";
        
        return lastdate;
    
    }
 
    public String getLastStatus(int cid) throws SQLException, ClassNotFoundException{
        String laststatus = null;
        
        con=getConnection();
        
        PreparedStatement pstmt=con.prepareStatement("SELECT ORDERTABLE.O_ID, ORDERTABLE.STATUS FROM CRCE.ORDERTABLE AS ORDERTABLE WHERE ORDERTABLE.C_ID = ? ORDER BY ORDERTABLE.O_ID DESC");
        pstmt.setInt(1, cid);
       // System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        
        if(rs.next())
        {laststatus=rs.getString("status");
          }
        else laststatus="delivered";
        
        return laststatus;
        
    }
 
    
    
    
    
    
    
    
    
}
