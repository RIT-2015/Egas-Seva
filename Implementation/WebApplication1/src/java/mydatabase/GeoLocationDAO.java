/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mydatabase;
import java.sql.*;
import java.util.Collection;
import java.util.Vector;
import mybeans.Maphelp;

/**
 *
 * @author Acer
 */
public class GeoLocationDAO extends BaseDAO{

    public String[][] getLocations (String city){
        String a[][]=null;
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select count(*) from crce.distributor d, crce.geolocation g where lower(d.city) like '"+city.toLowerCase()+"' and d.d_id=g.d_id"); 
            rs.next();
            int len=Integer.parseInt(rs.getString(1));
            a=new String [len][3];
            rs=stmt.executeQuery("select * from crce.distributor d, crce.geolocation g where lower(d.city) like '"+city.toLowerCase()+"' and d.d_id=g.d_id");
            int i=0;
            while(rs.next()){
                /*
                Maphelp m=new Maphelp();
                    m.setLattitude(Double.parseDouble(rs.getString("lattitude")));
                    m.setLongitude(Double.parseDouble(rs.getString("longitude")));
                   */ 
                String add=rs.getString("address")+"\n"+rs.getString("landmark")+"\n"+rs.getString("city")+"\n"+rs.getString("state")+"\n"+rs.getString("pin_code");
                 /*   
                 m.setAddress(address);
                    v.add(m);
                 * 
                 */
                 for (int j=0; j<3; j++){
                     a[i][j]=new String();
                 }
                a[i][0]=rs.getString("lattitude");
                a[i][1]=rs.getString("longitude");
                a[i][2]=add;
                i++;
                }
        }

    catch (Exception e){
    System.out.println (e);
    }
                return a;
}
    
    public static void main (String args[]){
        GeoLocationDAO g= new GeoLocationDAO();
        String a[][]= g.getLocations("mumbai");
        int len=a.length;
        for (int i=0; i<len; i++){
            //Maphelp m=(Maphelp) v.get(i);
           // System.out.println (m.getLattitude()+""+m.getLongitude()+""+m.getAddress());
        System.out.println(a[i][0]+" "+a[i][1]+" "+"\n"+a[i][2]);
        }
    }
    
    public void addLocation (String lat, String lon, String did){
        int d_id=Integer.parseInt(did);
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from crce.geolocation where d_id="+d_id);
            if (rs.next()){
             int x=stmt.executeUpdate("update crce.geolocation set lattitude='"+lat+"', longitude='"+lon+"' where d_id="+d_id);   
            }
            else {
            int x=stmt.executeUpdate("insert into crce.geolocation (d_id, lattitude, longitude) values ("+d_id+",'"+lat+"','"+lon+"')");
            }
            }
        catch (Exception e){
    System.out.println (e);
    }
    }
}
