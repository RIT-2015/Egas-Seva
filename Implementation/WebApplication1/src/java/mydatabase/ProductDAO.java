/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;
import mybeans.Distributor;
import mybeans.Orderproduct;
import mybeans.Product;

/**
 *
 * @author shashi
 */
public class ProductDAO extends BaseDAO {

      
  public Collection getProducts() {

        Vector prodVector = new Vector();
        Connection con = null;
        try {
            con = getConnection();

            PreparedStatement ps = con.prepareStatement("select * from crce.product");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product p = new Product();

                p.setProdID(rs.getString(1));
                p.setName(rs.getString(2));
                p.setDetails(rs.getString(3));
                p.setPrice(rs.getString(4));
                p.setAvailQuantity(rs.getString(5));
                p.setSoldPieces(rs.getString(6));

                prodVector.add(p);
            }
            
        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }

        closeConnection();
        return prodVector;

    }
    
    
    public boolean addProduct(Product p){
        
        int i=0;
        Connection con=null;
        try{
            con=getConnection();
            PreparedStatement ps=con.prepareStatement("insert into crce.product(name,details,price,quantity,sold_pieces) values(?,?,?,?,?)");
       //     ps.setString(1, p.getProdID());
            ps.setString(1, p.getName());
            ps.setString(2, p.getDetails());
            ps.setString(3, p.getPrice());
            ps.setString(4, p.getAvailQuantity());
            ps.setString(5, p.getSoldPieces());
            
            i=ps.executeUpdate();
            
        }
        catch(Exception e){
            System.out.println("error aaya : "+e);
        }
        
        closeConnection();        
        if(i==0) return false;
        else return true;
    }
    
        public boolean deleteProduct(String id) {
                
        Connection con = null;
        int i = 0;
        try {            
            con = getConnection();                                  
            PreparedStatement ps = con.prepareStatement("delete from crce.product where p_id=?");  
                                                        
            ps.setString(1, id);
            i = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error aaya: " + e);
        }

        closeConnection();
        
        if (i == 0) return false;
        else return true;        
        
    }
       
    
    
  
    /*
    
    
    public String getproduct()
    {   String img = null;
        try
        {
            con=getConnection();
            
            PreparedStatement pstmt=con.prepareStatement("select img from CRCE.PRODUCT where P_ID=11");
            ResultSet rs=pstmt.executeQuery();
            System.out.println("execute");
            rs.next();
             img=rs.getString(1);
                    
            
        }
        
        catch(Exception e)
        {System.out.println("error in ProductDAO :"+e);}
        
        return img;  
    }
    
         * */
          
         
    public Collection getAllProduct() throws SQLException, ClassNotFoundException
    {   Vector pros=new Vector();
    
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select * from CRCE.PRODUCT");
       ResultSet rs=pstmt.executeQuery();
        
        while(rs.next())
        {
            Orderproduct ordpro=new Orderproduct();
               ordpro.setProductName(rs.getString("name"));
               ordpro.setPrice(rs.getString("price"));
               ordpro.setProdID(""+rs.getInt("p_id"));
               pros.add(ordpro);
               
            
            
        }
    
        return pros;
    
    }
    
     public String findName(int pid) throws SQLException, ClassNotFoundException
    {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select * from CRCE.PRODUCT WHERE P_ID=?");
        pstmt.setInt(1, pid);
       ResultSet rs=pstmt.executeQuery();
        
        rs.next();
        String name=rs.getString("name");
        System.out.println("name :"+name);
        
        return name;
        
    }
     
     
public String findPrice(int pid) throws SQLException, ClassNotFoundException
    {
        con=getConnection();
        PreparedStatement pstmt=con.prepareStatement("select * from CRCE.PRODUCT WHERE P_ID=?");
        pstmt.setInt(1, pid);
       ResultSet rs=pstmt.executeQuery();
        
        rs.next();
        String price=rs.getString("price");
        System.err.println("Price   : "+price);
        
        return price;
        
    }

}