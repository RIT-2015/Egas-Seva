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
import mybeans.Proof;

public class ProofDAO extends BaseDAO{
    
   public Proof getCusProof (String cus){
       Proof p= new Proof();
       int cid=Integer.parseInt(cus);
    try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CRCE.PROOF where c_id="+cid);
                        rs.next();
                        p.setC_id(cus);
                        p.setD_id(rs.getString(3));
                        p.setP_id(rs.getString(1));
                        p.setProofdetails1(rs.getString(4));
                        p.setProofdetails2(rs.getString(5));
                        p.setProofdetails3(rs.getString(6));
                }
    catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                return p;
   }
   
   public void insertProof (Proof p,String cid){
       int c_id=Integer.parseInt(cid);
           try
		{
                        Connection con = getConnection();
			Statement stmt = con.createStatement();
                        int x=stmt.executeUpdate("insert into crce.proof (c_id,proof_details1,proof_details2,proof_details3) values ("+c_id+",'"+p.getProofdetails1()+"','"+p.getProofdetails2()+"','"+p.getProofdetails3()+"')");
                        
                }
           catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
   }
   
   public void updateProof (Proof p,String cid){
       int c_id=Integer.parseInt(cid);
           try
		{
                        Connection con = getConnection();
			Statement stmt = con.createStatement();
                        int x=stmt.executeUpdate("update crce.proof set proof_details1='"+p.getProofdetails1()+"' , proof_details2='"+p.getProofdetails2()+"' , proof_details3='"+p.getProofdetails3()+"' where c_id="+cid);
                        
                }
           catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
   }
}