/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;

import java.util.*;
import java.sql.*;
import mybeans.*;

/**
 *
 * @author shashi
 */
public class FeedbackDAO extends BaseDAO {
    
      public boolean insertFeedback(Feedback f) {

        Connection con = null;
        boolean rs = false;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into crce.feedback(type, category, description, email, c_id, d_id, reference_no, reply) values(?,?,?,?,?,?,?,?)");
     //       ps.setString(1, f.getFbID());
            ps.setString(1, f.getType());
            ps.setString(2, f.getCategory());
            ps.setString(3, f.getDescription());
            ps.setString(4, f.getEmail());
            ps.setString(5, f.getCustID());
            ps.setString(6, f.getDistID());
            ps.setString(7, f.getReferenceNo());
            ps.setString(8, "na");           
            rs = ps.execute();                /////////////////////////////////////////////////////////
            
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        
        closeConnection();
        return rs;
    }
      
      
    public Collection getFeedbacks() {

        Vector faqVector = new Vector();
        Connection con = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from crce.feedback");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Feedback f = new Feedback();
                f.setFbID(rs.getString(1));
                f.setType(rs.getString(2));
                f.setCategory(rs.getString(3));
                f.setDescription(rs.getString(4));
                f.setEmail(rs.getString(5));
                f.setCustID(rs.getString(6));
                f.setDistID(rs.getString(7));
                f.setReferenceNo(rs.getString(8));
                f.setReply(rs.getString(9));

                faqVector.add(f);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return faqVector;
    }
    
    
    
    public Collection getFeedbacksD() {

        Vector faqVector = new Vector();
        Connection con = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from crce.feedback where category=?");
            ps.setString(1, "Service-related");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Feedback f = new Feedback();
                f.setFbID(rs.getString(1));
                f.setType(rs.getString(2));
                f.setCategory(rs.getString(3));
                f.setDescription(rs.getString(4));
                f.setEmail(rs.getString(5));
                f.setCustID(rs.getString(6));
                f.setDistID(rs.getString(7));
                f.setReferenceNo(rs.getString(8));
                f.setReply(rs.getString(9));

                faqVector.add(f);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return faqVector;
    }

  public Collection feedbackDetails(String id)throws Exception{
      
      Vector faqVector = new Vector();
        Connection con = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from crce.feedback where f_id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

               Feedback f = new Feedback();
                f.setFbID(rs.getString(1));
                f.setType(rs.getString(2));
                f.setCategory(rs.getString(3));
                f.setDescription(rs.getString(4));
                f.setEmail(rs.getString(5));
                f.setCustID(rs.getString(6));
                f.setDistID(rs.getString(7));
                f.setReferenceNo(rs.getString(8));
                f.setReply(rs.getString(9));

                faqVector.add(f);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return faqVector;
  }
  

  public boolean reply(Feedback f) {

        Connection con = null;
        int i = 0;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("update crce.feedback set reply=? where f_id=?");
            ps.setString(1, f.getReply());
            ps.setString(2, f.getFbID());
            i=ps.executeUpdate();   

        } catch (Exception e) {
            System.out.println(("error aaya: " + e));
        }
         
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

  public boolean deleteFeedback(String id) {

        Connection con = null;
        int i = 0;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from crce.feedback where f_id=?");
            ps.setString(1, id);
            i = ps.executeUpdate();

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
  
  
  // ------pratik------
  
  public Collection getFReply(int cid)throws SQLException, ClassNotFoundException
    {
        Vector feedback=new Vector();
        try
        {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("SELECT * FROM CRCE.FEEDBACK where c_id=?");
        pstmt.setInt(1, cid);
        System.out.println("create");
       ResultSet rs= pstmt.executeQuery();
        System.out.println("execute");
        
        Feedback f=new Feedback();
        
        rs.next();
        
        f.setFbID(""+rs.getInt("f_id"));
        f.setDescription(rs.getString("description"));
        f.setReply(rs.getString("reply"));
        f.setReferenceNo(rs.getString("reference_no"));
        
        feedback.add(f);
        
            }
    catch(Exception e){
    System.out.println("error in feedback :"+e);    
    }
        
        return feedback;
    
}
  
  
}
