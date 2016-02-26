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
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;
import java.util.Vector;
import mybeans.Distributor;
import mybeans.MailCall;

public class DistributorDAO extends BaseDAO{
    
    public String getDisPassword (String name){
            String pass="";
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select password from  crce.distributor where username='"+name+"'");
			rs.next();
                        pass=rs.getString(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return pass;
        }
    
    public boolean checkCredentials (String name, String password) {
		boolean result=false;
		try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from  crce.distributor where username='"+name+"'and password='"+password+"'");
			if (rs.next()){
				result=true;
			}
			else{
				result=false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
		
		return result;
	}
    
    public String getMobileNo (String name) {
            String mobile="";
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from  crce.distributor where username='"+name+"'");
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
    
    public boolean checkUsername (String name){
            boolean result=false;
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from  crce.distributor where username='"+name+"'");
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
 
    public Distributor getProfile  (String name){
        Distributor d=new Distributor();
         try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from  crce.distributor where username='"+name+"'");
			rs.next();
                        
                        d.setAddress(rs.getString("address"));
                        d.setAge(rs.getString("age"));
                        d.setAgencyName(rs.getString("agency_name"));
                        d.setCity(rs.getString("city"));
                        d.setDistID(rs.getString("d_id"));
                        d.setDob(rs.getString("date_of_birth"));
                        d.setEmail(rs.getString("email"));
                        d.setFname(rs.getString("f_name"));
                        d.setGender(rs.getString("gender"));
                        d.setLandline(rs.getString("landline_no"));
                        d.setLandmark(rs.getString("landmark"));
                        d.setLname(rs.getString("l_name"));
                        d.setMname(rs.getString("m_name"));
                        d.setMobile(rs.getString("mobile_no"));
                        d.setPassword(rs.getString("password"));
                        d.setPin(rs.getString("pin_code"));
                        d.setState(rs.getString("state"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return d;
    }
   
    public void updateProfile(Distributor d, String name){
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			int x=stmt.executeUpdate("update crce.distributor set password='"+d.getPassword()+"', mobile_no='"+d.getMobile()+"' , landline_no='"+d.getLandline()+"' , email='"+d.getEmail()+"' where username='"+name+"'");
		}
		catch(Exception e){
		
			System.out.println(e);
		}
		closeConnection();
		
    }

    
    
    
    
    // shashi
    
    
    
  public String insertDistributorAppln(Distributor d) {

        Connection con = null;
        int i = 0;
        try {
            
             String dob=d.getDob();
             String array[]=dob.split("/");
             int day=Integer.parseInt(array[0]);
             int month=Integer.parseInt(array[1]);
             int year=Integer.parseInt(array[2]);
             
             java.util.Date date=new java.util.Date();
             Calendar cal=Calendar.getInstance();
             cal.setTime(date);
             int y=cal.get(Calendar.YEAR);

             int age1=y-year;
             String age=""+age1;
            
            con = getConnection();                                              System.out.println("0");
           
                   
            PreparedStatement ps3=con.prepareStatement("select * from crce.distributor where email=?");
            ps3.setString(1, d.getEmail());
            ResultSet rs3=ps3.executeQuery();
            if(rs3.next())
               return "email_exists";           
            
            PreparedStatement ps4=con.prepareStatement("select * from crce.usertable where email=?");
            ps4.setString(1, d.getEmail());
            ResultSet rs4=ps4.executeQuery();
            if(rs4.next())
               return "email_exists";
            
            PreparedStatement ps6=con.prepareStatement("select * from crce.customer where email=?");
            ps6.setString(1, d.getEmail());
            ResultSet rs6=ps6.executeQuery();
            if(rs6.next())
               return "email_exists";
            
            PreparedStatement ps5=con.prepareStatement("select * from crce.admin where email=?");
            ps5.setString(1, d.getEmail());
            ResultSet rs5=ps5.executeQuery();
            if(rs5.next())
               return "email_exists";
            
            
            
            PreparedStatement ps = con.prepareStatement("insert into crce.distributor(f_name,m_name,l_name,date_of_birth,age,gender,address,landmark,pin_code,city,state,mobile_no,landline_no,email,id1,id2,id3,city_service,verified,agency_name,username,password,reg_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      //      ps.setString(1, d.getDistID());
            ps.setString(1, d.getFname());
            ps.setString(2, d.getMname());
            ps.setString(3, d.getLname());
            ps.setString(4, d.getDob());
            ps.setString(5, age);
            ps.setString(6, d.getGender());
            ps.setString(7, d.getAddress());
            ps.setString(8, d.getLandmark());
            ps.setString(9, d.getPin());
            ps.setString(10, d.getCity());
            ps.setString(11, d.getState());
            ps.setString(12, d.getMobile());
            ps.setString(13, d.getLandline());
            ps.setString(14, d.getEmail());
            ps.setString(15, "na");
            ps.setString(16, "na");
            ps.setString(17, "na");
            ps.setString(18, d.getServiceCity());
            ps.setString(19, d.getVerified());
            ps.setString(20, d.getAgencyName());
            ps.setString(21, d.getEmail());
            ps.setString(22, d.getPassword());
            ps.setString(23, d.getRegDate());System.out.println("888");
            
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

   
    
    public Collection getApplications() {

        Vector distVector = new Vector();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement ps1 = con.prepareStatement("select * from crce.distributor where verified='false' or username='null'");
            ResultSet rs1 = ps1.executeQuery();

            while (rs1.next()) {
                Distributor d = new Distributor();

                d.setDistID(rs1.getString(1));
                d.setFname(rs1.getString(2));
                d.setMname(rs1.getString(3));
                d.setLname(rs1.getString(4));
                d.setDob(rs1.getString(5));
                d.setAge(rs1.getString(6));
                d.setGender(rs1.getString(7));
                d.setAddress(rs1.getString(8));
                d.setLandmark(rs1.getString(9));
                d.setPin(rs1.getString(10));
                d.setCity(rs1.getString(11));
                d.setState(rs1.getString(12));
                d.setMobile(rs1.getString(13));
                d.setLandline(rs1.getString(14));
                d.setEmail(rs1.getString(15));
                d.setId1(rs1.getString(16));
                d.setId2(rs1.getString(17));
                d.setId3(rs1.getString(18));
                d.setServiceCity(rs1.getString(19));
                d.setVerified(rs1.getString(20));
                d.setAgencyName(rs1.getString(21));
                d.setUserName(rs1.getString(22));
                d.setPassword(rs1.getString(23));
                d.setRegDate(rs1.getString(24));

                distVector.add(d);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return distVector;
    }

     public Collection distApplnDetails(String id) {

        Vector distVector = new Vector();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from crce.distributor where d_id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Distributor d = new Distributor();

                d.setDistID(rs.getString(1));
                d.setFname(rs.getString(2));
                d.setMname(rs.getString(3));
                d.setLname(rs.getString(4));
                d.setDob(rs.getString(5));
                d.setAge(rs.getString(6));
                d.setGender(rs.getString(7));
                d.setAddress(rs.getString(8));
                d.setLandmark(rs.getString(9));
                d.setPin(rs.getString(10));
                d.setCity(rs.getString(11));
                d.setState(rs.getString(12));
                d.setMobile(rs.getString(13));
                d.setLandline(rs.getString(14));
                d.setEmail(rs.getString(15));
                d.setId1(rs.getString(16));
                d.setId2(rs.getString(17));
                d.setId3(rs.getString(18));
                d.setServiceCity(rs.getString(19));
                d.setVerified(rs.getString(20));
                d.setAgencyName(rs.getString(21));
                d.setUserName(rs.getString(22));
                d.setPassword(rs.getString(23));
                d.setRegDate(rs.getString(24));

                distVector.add(d);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return distVector;
    }
    
    public Distributor approveAppln(Distributor d){
        
        Connection con=null;
        int i=0;
        ResultSet rs=null;
        String username=null,password=null;
        try{          
             Random r=new Random();
             int p=r.nextInt(9999);
            
            password=""+p;
            d.setPassword(password);
            
            con=getConnection();
            PreparedStatement ps=con.prepareStatement("update crce.distributor set verified=?, password=?, agency_name=?,id1=?,id2=?,id3=? where d_id=?");
            ps.setString(1, "true");
     //       ps.setString(2, email);
            ps.setString(2, password); 
            ps.setString(3, "na");
            ps.setString(4, d.getId1());
            ps.setString(5, d.getId2());
            ps.setString(6, d.getId3());
            ps.setString(7, d.getDistID());
            i=ps.executeUpdate();
  /*                
            PreparedStatement ps1=con.prepareStatement("select email from crce.distributor where d_id=?");
            ps1.setString(1, d.getDistID());
            rs=ps1.executeQuery();
            rs.next();
            email = rs.getString("email");
            System.out.println("email id: " + email);  */
        }
        catch(Exception e){
            System.out.println("error aaya: "+e);
        }
        
      //MessageOutDAO mdao = new MessageOutDAO();
      //mdao.sendMessage(get, email)
        
        closeConnection();
        return d;
    }
    
    
    
    public boolean rejectAppln(Distributor d){
        
        Connection con=null;
        int i=0;
        ResultSet rs=null;
        try{            
            con=getConnection();
            PreparedStatement ps=con.prepareStatement("delete from crce.distributor where d_id=?");
            ps.setString(1, d.getDistID());
            i=ps.executeUpdate();
       
        }
        catch(Exception e){
            System.out.println("error aaya: "+e);
        }
        closeConnection();
               
        if(i==0)return false;
        else return true;
    }
    
    public Collection getDistributors() {

        Vector distVector = new Vector();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from crce.distributor where verified='true'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Distributor d = new Distributor();

                d.setDistID(rs.getString(1));
                d.setFname(rs.getString(2));
                d.setMname(rs.getString(3));
                d.setLname(rs.getString(4));
                d.setDob(rs.getString(5));
                d.setAge(rs.getString(6));
                d.setGender(rs.getString(7));
                d.setAddress(rs.getString(8));
                d.setLandmark(rs.getString(9));
                d.setPin(rs.getString(10));
                d.setCity(rs.getString(11));
                d.setState(rs.getString(12));
                d.setMobile(rs.getString(13));
                d.setLandline(rs.getString(14));
                d.setEmail(rs.getString(15));
                d.setId1(rs.getString(16));
                d.setId2(rs.getString(17));
                d.setId3(rs.getString(18));
                d.setServiceCity(rs.getString(19));
                d.setVerified(rs.getString(20));
                d.setAgencyName(rs.getString(21));
                d.setUserName(rs.getString(22));
                d.setPassword(rs.getString(23));
                d.setRegDate(rs.getString(24));

                distVector.add(d);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return distVector;
    }

    
    public Collection distributorDetails(String id){
        
        Connection con=null;
        Vector distVector = new Vector();
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from crce.distributor where d_id=?");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();          System.out.println("111");

           while (rs.next()) {
                Distributor d = new Distributor();

                d.setDistID(rs.getString(1));
                d.setFname(rs.getString(2));
                d.setMname(rs.getString(3));
                d.setLname(rs.getString(4));
                d.setDob(rs.getString(5));
                d.setAge(rs.getString(6));
                d.setGender(rs.getString(7));
                d.setAddress(rs.getString(8));
                d.setLandmark(rs.getString(9));
                d.setPin(rs.getString(10));
                d.setCity(rs.getString(11));
                d.setState(rs.getString(12));
                d.setMobile(rs.getString(13));
                d.setLandline(rs.getString(14));
                d.setEmail(rs.getString(15));
                d.setId1(rs.getString(16));
                d.setId2(rs.getString(17));
                d.setId3(rs.getString(18));
                d.setServiceCity(rs.getString(19));
                d.setVerified(rs.getString(20));
                d.setAgencyName(rs.getString(21));
                d.setUserName(rs.getString(22));
                d.setPassword(rs.getString(23));
                d.setRegDate(rs.getString(24)); System.out.println("2");

                distVector.add(d);System.out.println("4");
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return distVector;
        
    }  
        
        
        
    public boolean deleteDistributor(String id) {

        Connection con = null;
        int i = 0;
        String email=null;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from crce.distributor where d_id=?");
            ps.setString(1, id);
            i = ps.executeUpdate();
            
            PreparedStatement ps1=con.prepareStatement("select email from crce.distributor where d_id=?");
            ps1.setString(1, id);
            ResultSet rs=ps1.executeQuery();
            rs.next();
            email=rs.getString("email");System.out.println("email id: " + email);

        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }

        closeConnection();
         
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }    
    
    
}
