/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;

import java.sql.*;
import java.util.*;
import mybeans.Faq;

/**
 *
 * @author shashi
 */
public class FaqDAO extends BaseDAO {

    public Collection getFaqs() {

        Vector faqVector = new Vector();
        Connection con = null;

        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from crce.faq");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Faq f = new Faq();
                f.setFaqID(rs.getString(1));
                f.setQuestion(rs.getString(2));
                f.setAnswer(rs.getString(3));

                faqVector.add(f);
            }
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }
        closeConnection();
        return faqVector;
    }
    
    
    public boolean addFaq(Faq f){
        
        Connection con=null;
        int i=0;
        try{
            con=getConnection();
            PreparedStatement ps=con.prepareStatement("insert into crce.faq(question,answer) values(?,?)");
          //  ps.setString(1, f.getFaqID());
            ps.setString(1, f.getQuestion());
            ps.setString(2, f.getAnswer());
            
            i=ps.executeUpdate();
            
        }
        catch(Exception e){
            System.out.println("error aaya: "+e);
        }
        closeConnection();
        
        if(i==0) return false;
        else return true;
    }
    
        public boolean deleteFaq(String id) {
                
        Connection con = null;
        int i = 0;
        try {            
            con = getConnection();                                  
            PreparedStatement ps = con.prepareStatement("delete from crce.faq where faq_id=?");  
                                                        
            ps.setString(1, id);
            i = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }

        closeConnection();
        
        if (i == 0) return false;
        else return true;        
        
    }
    
    
    
}
