/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import mybeans.*;
/**
 *
 * @author NewPratik
 */
public class OrderProductDAO extends BaseDAO

{       String p;
    int d;
    
    public Collection getDisProduct(String name)throws SQLException, ClassNotFoundException
    {
        Vector orders=new Vector();
        try
        {
        con=getConnection();
        Statement stmt=con.createStatement();
       ResultSet rs= stmt.executeQuery("select o.status,o.p_id,o.op_id,o.c_id,o.order_date,o.quantity,o.price from crce.orderproduct o,crce.distributor d where d.d_id=o.d_id and d.username='"+name+"'");
        System.out.println("execute");
         while(rs.next())
        {
             Orderproduct order=new Orderproduct();

                p=rs.getString("status");
             System.out.println("OK!!!"+p);
             order.setStatus(p);
             p=""+rs.getInt("op_id");
             p.trim();
             order.setProdID(""+rs.getInt("p_id"));
             //int oid=Integer.parseInt(p);
             order.setOrderID(p);
             order.setOrderDate(rs.getString("order_date"));
            
             order.setPrice(rs.getString("price"));
             order.setQuantity(rs.getString("quantity"));
            ResultSet rs1=stmt.executeQuery("select name from CRCE.PRODUCT where P_ID="+rs.getInt("p_id"));
       
                rs1.next();
                order.setProductName(rs1.getString("name"));
          
                
                    
             orders.add(order);
             System.out.println("OK!!!OK!!!OK!!");
         }
        
        }
        catch(Exception e)
        {System.out.println("error in orderProductDOA  : "+e);}

        return orders;

    }
    
    public void deliverProduct (String id){
        int Id=Integer.parseInt(id);
        try{
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            int x=stmt.executeUpdate("update crce.orderproduct set status='delivered' where op_id="+Id);
        }
        catch(Exception e){
            System.out.println (e);
        }
    }
    
    
        public Collection getBookedProduct(int cid)throws SQLException, ClassNotFoundException
    {
        Vector orders=new Vector();
        try
        {
        con=getConnection();
        //stmt=con.createStatement();
System.out.println("cid"+cid);
          PreparedStatement pstmt=con.prepareStatement("select * from CRCE.ORDERPRODUCT where C_ID=? and status=? ORDER BY OP_ID DESC");
        pstmt.setInt(1, cid);
        pstmt.setString(2, "undelivered");
        System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
         while(rs.next())
        {
             Orderproduct order=new Orderproduct();

                p=rs.getString("status");
             System.out.println("OK!!!"+p);
             order.setStatus(p);
             p=""+rs.getInt("op_id");
             p.trim();
             order.setProdID(""+rs.getInt("p_id"));
             //int oid=Integer.parseInt(p);
             order.setOrderID(p);
             order.setOrderDate(rs.getString("order_date"));
             order.setDeliveryDate(rs.getString("delivery_date"));
             order.setCancelDate(rs.getString("cancel_date"));
             System.out.println("OK!!!OK!!!"+order.getStatus());
             order.setPrice(rs.getString("price"));
             order.setQuantity(rs.getString("quantity"));
             pstmt=con.prepareStatement("select name from CRCE.PRODUCT where P_ID=?");
        pstmt.setInt(1, rs.getInt("p_id"));
        ResultSet rs2=pstmt.executeQuery();
                rs2.next();
                order.setProductName(rs2.getString("name"));
          
                
                    
             orders.add(order);
             System.out.println("OK!!!OK!!!OK!!");
         }
        
        }
        catch(Exception e)
        {System.out.println("error in orderProductDOA  : "+e);}

        return orders;

    }
        
        
        public Collection getDProduct(int cid)throws SQLException, ClassNotFoundException
    {
        Vector orders=new Vector();
        try
        {
        con=getConnection();
        //stmt=con.createStatement();
System.out.println("cid"+cid);
          PreparedStatement pstmt=con.prepareStatement("select * from CRCE.ORDERPRODUCT where C_ID=? and status=? ORDER BY OP_ID DESC");
        pstmt.setInt(1, cid);
        pstmt.setString(2, "delivered");
        System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
         while(rs.next())
        {
             Orderproduct order=new Orderproduct();

                p=rs.getString("status");
             System.out.println("OK!!!"+p);
             order.setStatus(p);
             p=""+rs.getInt("op_id");
             p.trim();
             order.setProdID(""+rs.getInt("p_id"));
             //int oid=Integer.parseInt(p);
             order.setOrderID(p);
             order.setOrderDate(rs.getString("order_date"));
             order.setDeliveryDate(rs.getString("delivery_date"));
             order.setCancelDate(rs.getString("cancel_date"));
             System.out.println("OK!!!OK!!!"+order.getStatus());
             order.setPrice(rs.getString("price"));
             order.setQuantity(rs.getString("quantity"));
             pstmt=con.prepareStatement("select name from CRCE.PRODUCT where P_ID=?");
        pstmt.setInt(1, rs.getInt("p_id"));
        ResultSet rs2=pstmt.executeQuery();
                rs2.next();
                order.setProductName(rs2.getString("name"));
          
                
                    
             orders.add(order);
             System.out.println("OK!!!OK!!!OK!!");
         }
        
        }
        catch(Exception e)
        {System.out.println("error in orderProductDOA  : "+e);}

        return orders;

    }
        
        
        public Collection getCProduct(int cid)throws SQLException, ClassNotFoundException
    {
        Vector orders=new Vector();
        try
        {
        con=getConnection();
        //stmt=con.createStatement();
System.out.println("cid"+cid);
          PreparedStatement pstmt=con.prepareStatement("select * from CRCE.ORDERPRODUCT where C_ID=? and status=? ORDER BY OP_ID DESC");
        pstmt.setInt(1, cid);
        pstmt.setString(2, "cancelled");
        System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
         while(rs.next())
        {
             Orderproduct order=new Orderproduct();

                p=rs.getString("status");
             System.out.println("OK!!!"+p);
             order.setStatus(p);
             p=""+rs.getInt("op_id");
             p.trim();
             order.setProdID(""+rs.getInt("p_id"));
             //int oid=Integer.parseInt(p);
             order.setOrderID(p);
             order.setOrderDate(rs.getString("order_date"));
             order.setDeliveryDate(rs.getString("delivery_date"));
             order.setCancelDate(rs.getString("cancel_date"));
             System.out.println("OK!!!OK!!!"+order.getStatus());
             order.setPrice(rs.getString("price"));
             order.setQuantity(rs.getString("quantity"));
             pstmt=con.prepareStatement("select name from CRCE.PRODUCT where P_ID=?");
        pstmt.setInt(1, rs.getInt("p_id"));
        ResultSet rs2=pstmt.executeQuery();
                rs2.next();
                order.setProductName(rs2.getString("name"));
          
                
                    
             orders.add(order);
             System.out.println("OK!!!OK!!!OK!!");
         }
        
        }
        catch(Exception e)
        {System.out.println("error in orderProductDOA  : "+e);}

        return orders;

    }
        
        
        
        
        
    
    
    
    public boolean deleteOrderProduct(Orderproduct ordpro,int cid) throws SQLException, ClassNotFoundException
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

          PreparedStatement pstmt=con.prepareStatement("UPDATE CRCE.ORDERPRODUCT SET STATUS='cancelled', CANCEL_DATE='"+mydate+"' WHERE C_ID=? AND OP_ID=?");
        pstmt.setInt(1, cid);
        pstmt.setInt(2, Integer.parseInt(ordpro.getOrderID()) );
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
 
    public boolean insertorder(Orderproduct ordpro,int cid) throws SQLException, ClassNotFoundException
    {
        boolean b = false;
        
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
       int did=dao.getDid(cid);
        
       
       
       
       ProductDAO dao2=new ProductDAO();
       
       
       
        int price=Integer.parseInt(dao2.findPrice(Integer.parseInt(ordpro.getProdID())));        
        int q=Integer.parseInt(ordpro.getQuantity());
        int price2=price*q;
        System.err.println("new ordproDAO  :" +price+"   "+q);
        
        
        
        PreparedStatement pstmt=con.prepareStatement("INSERT INTO CRCE.ORDERPRODUCT (C_ID, D_ID, P_ID, ORDER_DATE, DELIVERY_DATE, CANCEL_DATE, STATUS,QUANTITY,PRICE)   VALUES (?, ?, ?, ?, ?, '--', 'undelivered',?,?)");
        pstmt.setInt(1,cid);
        pstmt.setInt(2,did );
        pstmt.setInt(3, Integer.parseInt(ordpro.getProdID()));
        pstmt.setString(4, mydate);
        pstmt.setString(5, deldate);
        pstmt.setInt(6,Integer.parseInt(ordpro.getQuantity()));
        pstmt.setInt(7, price2);
       // pstmt.setInt(6,Integer.parseInt(quant));
        
        int pk=pstmt.executeUpdate();
        
        if(pk>0)b=true;
        else b=false;
        
        return b;
    }
    
    
}
