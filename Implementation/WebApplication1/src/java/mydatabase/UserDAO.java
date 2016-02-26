package mydatabase;

import java.sql.*;


public class UserDAO extends BaseDAO {
	
	public boolean checkCredentials (String name, String password) {
		boolean result=false;
		try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from  crce.usertable where username='"+name+"'and password='"+password+"'");
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
        public String getMVerify (String name){
            String mverify="";
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from  crce.usertable where username='"+name+"'");
			rs.next();
                        mverify=rs.getString("m_verify");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return mverify;
        }
        public String getMobileNo (String name) {
            String mobile="";
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from  crce.usertable where username='"+name+"'");
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
        
        public String getUserPassword(String name){
            String pass="";
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select password from  crce.usertable where username='"+name+"'");
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
        
        public boolean checkUsername (String name){
            boolean result=false;
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from  crce.usertable where username='"+name+"'");
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
        
        
        public int getCID (String username){
            int cid=0;
            try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT c_id FROM CRCE.USERTABLE where username='"+username+"'");
			rs.next();
                        cid=Integer.parseInt (rs.getString(1));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return cid;
        }
        
        
        
        
      //---------------------pratik 
        
        public int getCid(String username) throws SQLException, ClassNotFoundException
 {  int cid = 0;
    try
		{
			 con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select c_id from  crce.usertable where username='"+username+"'");
                            
                         rs.next();
                         cid=rs.getInt("c_id");
                }
    catch  (Exception e)
    {System.out.println("UserDao "+e);}
     
 
     return cid;
 }
         
 
 
 public String getUsrname(int cid) throws SQLException, ClassNotFoundException
 {
     String usrname;
      con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select username from  crce.usertable where c_id='"+cid+"'");
                            
                         rs.next();
                         usrname=rs.getString("username");
     
     return usrname;
     
 }
 
 public String getPasswd(int cid) throws SQLException, ClassNotFoundException
 {
     String passwd;
      con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select password from  crce.usertable where c_id='"+cid+"'");
                            
                         rs.next();
                         passwd=rs.getString("password");
     
     return passwd;
     
 }
 
 
 
 
 public String getmsgv(int cid) throws SQLException, ClassNotFoundException
 {
     String msgv;
      con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select m_verify from  crce.usertable where c_id='"+cid+"'");
                            
                         rs.next();
                         msgv=rs.getString("m_verify");
     
     return msgv;
     
 }
 
 public boolean updatemv(String mv,int cid) throws SQLException, ClassNotFoundException
 {
 
     boolean b2;
     
     String mv2;
     if(mv.equalsIgnoreCase("enable")) mv2="yes";
     else mv2="no";
     
     
     
      con = getConnection();
	  PreparedStatement pstmt=con.prepareStatement(" UPDATE CRCE.USERTABLE USERTABLE SET M_VERIFY = '"+mv2+"' WHERE USERTABLE.C_ID = ?");
        pstmt.setInt(1,cid);
        int p1=pstmt.executeUpdate();
        
        if(p1>0)b2=true;
        else b2=false;
 
 
        
        return b2;
 }
 
 
 public boolean updatepass(int cid,String pass) throws SQLException, ClassNotFoundException
 {
     boolean b;
     
     con = getConnection();
	  PreparedStatement pstmt=con.prepareStatement(" UPDATE CRCE.USERTABLE USERTABLE SET PASSWORD = '"+pass+"' WHERE USERTABLE.C_ID = ?");
        pstmt.setInt(1,cid);
        int p1=pstmt.executeUpdate();
 
        if(p1>0) b=true;
        else b=false;
 
        return b;
 
 
 }
 
 

}
