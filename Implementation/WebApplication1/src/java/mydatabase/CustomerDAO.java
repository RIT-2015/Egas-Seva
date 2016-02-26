/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;

/**
 *
 * @author Somesh Mishra
 */
import mydatabase.BaseDAO;
import java.sql.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.Vector;
import mybeans.Customer;
import mybeans.MailCall;
public class CustomerDAO extends BaseDAO {

    private String p;
    boolean b;
    
    private int t;
    
    
    public Collection getDisCustomers (String name){
        Vector customers =new Vector();
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,c.address,c.landmark,c.city,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type from crce.customer c, crce.distributor d where c.d_id=d.d_id and c.status='approved' and d.username='"+name+"'");
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
    
    public Customer getCustomerDetail (String cus){
        int cid=Integer.parseInt(cus);
        Customer c=new Customer();
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CRCE.customer where c_id="+cid);
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
    
    public void deleteCustomer (String cus){
        
        int cid=Integer.parseInt(cus);
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        stmt.executeUpdate("delete from crce.customer where c_id="+cid);
                }
        catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
               
    }
    
    public Collection newApplications (String name){
        Vector customers =new Vector();
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select c.c_id, c.d_id,c.f_name,c.m_name,c.l_name,c.date_of_birth,c.age,c.address,c.landmark,c.city,c.contact_no1,c.contact_no2,c.mobile_no,c.email,c.no_of_cylinders,c.customer_type from crce.customer c, crce.distributor d where c.d_id=d.d_id and c.status='waited' and d.username='"+name+"'");
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
    
    public void approveCustomer (String cid){
        int c_id=Integer.parseInt(cid);
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        int x=stmt.executeUpdate("update crce.customer set status='approved' where c_id="+c_id);
                }
        catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
    }
    
    
    public String getMobileNo (String cid) {
        int c_id=Integer.parseInt(cid);
            String mobile="";
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from  crce.customer where c_id="+c_id);
			rs.next();
                        mobile=rs.getString("mobile_no");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
		return mobile;
        }
    
    public void disapproveCustApplication (String cid){
        int c_id=Integer.parseInt(cid);
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        int x=stmt.executeUpdate("delete from crce.customer where c_id="+cid);
                }
        catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
    }
    
    public void approveTransferCustomer (String cid){
         int c_id=Integer.parseInt(cid);
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        ResultSet rs=stmt.executeQuery("select newaddress, newcity, newlandmark, newstate from crce.transfer where c_id="+c_id);
                        rs.next();
                        String add=rs.getString(1);
                        String city=rs.getString(2);
                        String land=rs.getString(3);
                        String state=rs.getString(4);
                        int x=stmt.executeUpdate("update crce.customer set address='"+add+"' , landmark='"+land+"' , city='"+city+"' , state='"+state+"'  where c_id="+c_id);
                         x=stmt.executeUpdate("delete from crce.transfer where c_id="+c_id);
                }
        catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
    }
    
    public String getEmail (String cid){
        int c_id=Integer.parseInt(cid);
        String email=null;
         try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        ResultSet rs=stmt.executeQuery("select email from crce.customer where c_id="+c_id);
                        rs.next();
                        email=rs.getString(1);
                }
          catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
        
        return email;
    }
  
    
    // Pratik//
    
    
   /* 
    public Customer getCustDetails(int cid) throws SQLException, ClassNotFoundException
    {   
        Customer cust=new Customer();
        //Vector custs=new Vector();
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select * from CRCE.CUSTOMER where C_ID=?");
        pstmt.setInt(1,cid);

         System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");

        rs.next();
        
            

                p=rs.getString("f_name");
                System.out.println("OK!!!"+p);
                cust.setFname(p);
                cust.setLname(rs.getString("l_name"));
                cust.setMname(rs.getString("m_name"));
                cust.setAddress(rs.getString("address"));
                cust.setCity(rs.getString("city"));
                cust.setLandmark(rs.getString("landmark"));
                cust.setState(rs.getString("state"));
                cust.setDob(rs.getString("date_of_birth"));
                cust.setAge(""+rs.getInt("age"));
                cust.setD_id(""+rs.getInt("d_id"));
                cust.setContactno1(rs.getString("contact_no1"));
                cust.setContactno2(rs.getString("contact_no2"));
                cust.setMobile(rs.getString("mobile_no"));
                cust.setEmail(rs.getString("email"));
                cust.setCus_type(rs.getString("customer_type"));
                cust.setC_id(""+rs.getInt("c_id"));
             
                System.out.println("OK!!!OK!!!"+cust.getFname());
//             custs.add(cust);
             System.out.println("OK!!!OK!!!OK!!");
        

        }
        catch(Exception e)
        {System.out.println("error in orderDOA  : "+e);}
           
        closeConnection();
        return cust;
    }
    
    public String getType(int c_id)
    {String type = null;
    
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select CUSTOMER_TYPE from CRCE.CUSTOMER where C_ID=?");
        pstmt.setInt(1,c_id);
        ResultSet rs=pstmt.executeQuery();
        rs.next();
        type=rs.getString("customer_type");
        if(type.equalsIgnoreCase(null))type="PPP";
        
        
        }
        catch(Exception e)
        {System.out.println("error in type  "+e);}
   
    
    
        return type;
    
    }
    

    public boolean updateCust(Customer cust,int cid) throws SQLException, ClassNotFoundException
    {
     try
        {
        con=getConnection();
        
       PreparedStatement pstmt=con.prepareStatement("UPDATE CRCE.CUSTOMER SET DATE_OF_BIRTH='"+cust.getDob()+"',EMAIL='"+cust.getEmail()+"', CONTACT_NO1='"+cust.getContactno1()+"', CONTACT_NO2='"+cust.getContactno2()+"', MOBILE_NO='"+cust.getMobile()+"'  WHERE C_ID=?");
        pstmt.setInt(1, cid);
       
       
        
       
         System.out.println("create");
        t=pstmt .executeUpdate();
         
        System.out.println("execute");

        if(t>0)b=true;
        else b=false;
        }

     catch(Exception e)
        {System.out.println("error in CustomerDOA  : "+e);}
    
     return b;
     
    }
    
    */
    
    
    
    
    
    
    //Pratik
    
    
    public Customer getCustDetails(int cid) throws SQLException, ClassNotFoundException
    {   
        Customer cust=new Customer();
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select * from CRCE.CUSTOMER where C_ID=?");
        pstmt.setInt(1,cid);
        System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
        rs.next();
  
        p=rs.getString("f_name");
                System.out.println("OK!!!"+p);
                cust.setFname(p);
                cust.setLname(rs.getString("l_name"));
                cust.setMname(rs.getString("m_name"));
                cust.setAddress(rs.getString("address"));
                cust.setCity(rs.getString("city"));
                cust.setLandmark(rs.getString("landmark"));
                cust.setState(rs.getString("state"));
                cust.setDob(rs.getString("date_of_birth"));
                cust.setAge(""+rs.getInt("age"));
                cust.setD_id(""+rs.getInt("d_id"));
                cust.setContactno1(rs.getString("contact_no1"));
                cust.setContactno2(rs.getString("contact_no2"));
                cust.setMobile(rs.getString("mobile_no"));
                cust.setEmail(rs.getString("email"));
                cust.setCus_type(rs.getString("customer_type"));
                cust.setC_id(""+rs.getInt("c_id"));
             
                
                

        //System.out.println("OK!!!OK!!!"+cust.getFname());
        //custs.add(cust);
        //System.out.println("OK!!!OK!!!OK!!");
        
        }
        catch(Exception e){
            System.out.println("error in orderDOA  : "+e);
        }
           
        closeConnection();
        return cust;
    }
    
    
     
    
    public String getType(int c_id){
        String type = null;
    
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select CUSTOMER_TYPE from CRCE.CUSTOMER where C_ID=?");
        pstmt.setInt(1,c_id);
       ResultSet rs=pstmt.executeQuery();
        rs.next();
        type=rs.getString("customer_type");
        //if(type.equalsIgnoreCase(null))type="PPP";
        }
        catch(Exception e)
        {System.out.println("error in type  "+e);}
       
        return type;
    
    }
    
    
    
    public int getDid(int cid){
        int did = 0;
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select D_ID from CRCE.CUSTOMER where C_ID=?");
        pstmt.setInt(1,cid);
       ResultSet rs=pstmt.executeQuery();
        rs.next();
        did =rs.getInt("d_id");
        
        }
        catch(Exception e){
        System.out.println("error in getDid :"+e);
                }
    
        return did;
    
    }
    
    

    public boolean updateCust(Customer cust,int cid) throws SQLException, ClassNotFoundException
    {
     try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("UPDATE CRCE.CUSTOMER SET DATE_OF_BIRTH='"+cust.getDob()+"',EMAIL='"+cust.getEmail()+"', CONTACT_NO1='"+cust.getContactno1()+"', CONTACT_NO2='"+cust.getContactno2()+"', MOBILE_NO='"+cust.getMobile()+"'  WHERE C_ID=?");
        pstmt.setInt(1, cid);
        System.out.println("create");
        t=pstmt .executeUpdate();
        System.out.println("execute");
        if(t>0)b=true;
        else b=false;
        }

        catch(Exception e)
        {System.out.println("error in CustomerDOA  : "+e);}
    
        return b;
     
    }

    
    
    
    
    
    
    
// shashi -->   
    
    
   public String insertNewConnection(Customer c) {

        Connection con = null;
        int i = 0;
        try {
            
             String dob=c.getDob();
             String array[]=dob.split("/");
             int day=Integer.parseInt(array[0]);
             int month=Integer.parseInt(array[1]);
             int year=Integer.parseInt(array[2]);
             
             java.util.Date d=new java.util.Date();
             Calendar cal=Calendar.getInstance();
             cal.setTime(d);
             int y=cal.get(Calendar.YEAR);

             int age1=y-year;
             String age=""+age1;
             
            con = getConnection();                           
            
            PreparedStatement ps2=con.prepareStatement("select * from crce.distributor where d_id=? and verified='true'");
            ps2.setString(1, c.getD_id());
            ResultSet rs2=ps2.executeQuery();
            if(!rs2.next())
               return "distID_not_exists"; 
            
            PreparedStatement ps3=con.prepareStatement("select * from crce.customer where email=?");
            ps3.setString(1, c.getEmail());
            ResultSet rs3=ps3.executeQuery();
            if(rs3.next())
               return "email_exists"; 
            
            PreparedStatement ps6=con.prepareStatement("select * from crce.usertable where email=?");
            ps6.setString(1, c.getEmail());
            ResultSet rs6=ps6.executeQuery();
            if(rs6.next())
               return "email_exists"; 
            
            PreparedStatement ps4=con.prepareStatement("select * from crce.distributor where email=?");
            ps4.setString(1, c.getEmail());
            ResultSet rs4=ps4.executeQuery();
            if(rs4.next())
               return "email_exists";
            
            PreparedStatement ps5=con.prepareStatement("select * from crce.admin where email=?");
            ps5.setString(1, c.getEmail());
            ResultSet rs5=ps5.executeQuery();
            if(rs5.next())
               return "email_exists";
            
            
            PreparedStatement ps = con.prepareStatement("insert into crce.customer(d_id,f_name,m_name,l_name,date_of_birth,age,address,landmark,city,contact_no1,contact_no2,mobile_no,email,no_of_cylinders,customer_type,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, c.getD_id());
            ps.setString(2, c.getFname());
            ps.setString(3, c.getMname());
            ps.setString(4, c.getLname());
            ps.setString(5, c.getDob());
            ps.setString(6, age);
            ps.setString(7, c.getAddress());
            ps.setString(8, c.getLandmark());
            ps.setString(9, c.getCity());
            ps.setString(10, c.getContactno1());
            ps.setString(11, c.getContactno2());
            ps.setString(12, c.getMobile());
            ps.setString(13, c.getEmail());
            ps.setString(14, c.getNo_of_cylinder());
            ps.setString(15, c.getCus_type());
            ps.setString(16, c.getStatus()); System.out.println("11 ");

            i=ps.executeUpdate();System.out.println("2 ");
            
            
        } catch (SQLException e) {
            System.out.println("sql  error aaya: " + e);
        } catch (Exception e) {
            System.out.println("eror aaya: " + e);
        }

        closeConnection();
       
        if (i == 0) {
            return "false";
        } else {
            return "true";
        }
    }

    public String register(Customer c) {

        Connection con = null;
        int i = 0;
        try {
            con = getConnection();
           
            PreparedStatement ps1=con.prepareStatement("select * from crce.customer where c_id=?");
            ps1.setString(1, c.getC_id());
            ResultSet rs1=ps1.executeQuery();
            if(!rs1.next())
               return "not_found";  
            
            PreparedStatement ps2=con.prepareStatement("select * from crce.usertable where c_id=?");
            ps2.setString(1, c.getC_id());
            ResultSet rs2=ps2.executeQuery();
            if(rs2.next())
               return "id_exists"; 
            
            PreparedStatement ps3=con.prepareStatement("select * from crce.usertable where email=?");
            ps3.setString(1, c.getEmail());
            ResultSet rs3=ps3.executeQuery();
            if(rs3.next())
               return "email_exists"; 
            
            PreparedStatement ps4=con.prepareStatement("select * from crce.distributor where email=?");
            ps4.setString(1, c.getEmail());
            ResultSet rs4=ps4.executeQuery();
            if(rs4.next())
               return "email_exists";
            
            PreparedStatement ps5=con.prepareStatement("select * from crce.admin where email=?");
            ps5.setString(1, c.getEmail());
            ResultSet rs5=ps5.executeQuery();
            if(rs5.next())
               return "email_exists";
            
            PreparedStatement ps6=con.prepareStatement("select * from crce.usertable where username=?");
            ps6.setString(1, c.getUsername());
            ResultSet rs6=ps6.executeQuery();
            if(rs6.next())
               return "username_exists"; 
            
            PreparedStatement ps7=con.prepareStatement("select * from crce.admin where username=?");
            ps7.setString(1, c.getUsername());
            ResultSet rs7=ps7.executeQuery();
            if(rs7.next())
               return "username_exists";
            
            // in dist uname inserted at reg time
            
            PreparedStatement ps8=con.prepareStatement("select * from crce.distributor where username=?");
            ps8.setString(1, c.getUsername());
            ResultSet rs8=ps8.executeQuery();
            if(rs8.next())
               return "username_exists";
            
            
            PreparedStatement ps = con.prepareStatement("insert into crce.usertable(username, password, c_id, date_of_reg, mobile_no, m_verify, email) values(?,?,?,?,?,?,?)");
            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getC_id());
            ps.setString(4, c.getRegDate());
            ps.setString(5, c.getMobile());
            ps.setString(6, c.getmVerify());
            ps.setString(7, c.getEmail());

            i = ps.executeUpdate();

            
            PreparedStatement psUpdate = con.prepareStatement("update crce.customer set email=? and mobile_no=? where c_id=?");            
            psUpdate.setString(1, c.getEmail());
            psUpdate.setString(2, c.getMobile());
            psUpdate.setString(3, c.getC_id());

            i = psUpdate.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();

        if (i == 0) {
            return "false";
        } else {
            return "true";
        }
    }
    
    
}
