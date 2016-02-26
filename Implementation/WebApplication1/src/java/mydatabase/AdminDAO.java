/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;

import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import myactions.LoginAction;
import mybeans.Admin;
import mybeans.Distributor;
import mybeans.MailCall;
import mybeans.User;

/**
 *
 * @author shashi
 */
public class AdminDAO extends BaseDAO {

    
     public String getAdminPassword (String name){
            String pass="";
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select password from  crce.admin where username='"+name+"'");
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
			ResultSet rs = stmt.executeQuery(" select * from  crce.admin where username='"+name+"'and password='"+password+"'");
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
			ResultSet rs = stmt.executeQuery(" select * from  crce.admin where username='"+name+"'");
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
			ResultSet rs = stmt.executeQuery(" select * from  crce.admin where username='"+name+"'");
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
    
    
    public Collection viewProfile(String id) {

        Vector adminVector = new Vector();
        Connection con = null;

        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement("select * from crce.admin where username=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Admin a = new Admin();

                a.setAdminID(rs.getString(1));
                a.setFname(rs.getString(2));
                a.setMname(rs.getString(3));
                a.setLname(rs.getString(4));
                a.setDob(rs.getString(5));
                a.setAge(rs.getString(6));
                a.setGender(rs.getString(7));
                a.setAddress(rs.getString(8));
                a.setLandmark(rs.getString(9));
                a.setPin(rs.getString(10));
                a.setCity(rs.getString(11));
                a.setState(rs.getString(12));
                a.setMobile(rs.getString(13));
                a.setLandline(rs.getString(14));
                a.setEmail(rs.getString(15));
                a.setUsername(rs.getString(16));
                a.setPassword(rs.getString(17));
                a.setRegDate(rs.getString(18));

                adminVector.add(a);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }

        closeConnection();
        return adminVector;
    }
    
    
     public Admin updatePage(String id) {

        Vector adminVector = new Vector();
        Connection con = null;
        Admin a = new Admin();
        
        try {
            con = getConnection();             

            PreparedStatement ps = con.prepareStatement("select * from crce.admin where username=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {               

                a.setAdminID(rs.getString(1));
                a.setFname(rs.getString(2));
                a.setMname(rs.getString(3));
                a.setLname(rs.getString(4));
                a.setDob(rs.getString(5));
                a.setAge(rs.getString(6));
                a.setGender(rs.getString(7));
                a.setAddress(rs.getString(8));
                a.setLandmark(rs.getString(9));
                a.setPin(rs.getString(10));
                a.setCity(rs.getString(11));
                a.setState(rs.getString(12));
                a.setMobile(rs.getString(13));
                a.setLandline(rs.getString(14));
                a.setEmail(rs.getString(15));
                a.setUsername(rs.getString(16));
                a.setPassword(rs.getString(17));
                a.setRegDate(rs.getString(18));

                adminVector.add(a);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }

        closeConnection();
        return a;
    }
     
     
     

    public boolean updateProfile(Admin a) {

        Vector adminVector = new Vector();
        Connection con = null;
        int i=0;
        try {
            con = getConnection();System.out.println("admin dao: 1");

            PreparedStatement ps = con.prepareStatement("update crce.admin set m_name=?, date_of_birth=?, address=?, landmark=?, pin_code=?, city=?, state=?, mobile_no=?, landline_no=?, email=?, password=? where username=?");
          
            ps.setString(1, a.getMname());           
            ps.setString(2, a.getDob());
            ps.setString(3, a.getAddress());
            ps.setString(4, a.getLandmark());
            ps.setString(5, a.getPin());
            ps.setString(6, a.getCity());
            ps.setString(7, a.getState());
            ps.setString(8, a.getMobile());
            ps.setString(9, a.getLandline());
            ps.setString(10, a.getEmail());
            ps.setString(11, a.getPassword());System.out.println("2");
            
            ps.setString(12,a.getUsername());

            i=ps.executeUpdate();System.out.println("3");

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
    
    
    

     
     

    // Giving problem in DistributorDAO class. Therefore added here :
    public Collection getApplications() {

        Vector distVector1 = new Vector();
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

                distVector1.add(d);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return distVector1;
    }
}
