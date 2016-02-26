/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import mybeans.*;
import mydatabase.DistributorDAO;
import mydatabase.GeoLocationDAO;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Acer
 */
public class MapAction extends ActionSupport implements SessionAware{
    Map session;
    String conmsg;
    String latt,longi;
    @Override
    public void setSession(Map session) {
        this.session=session;
    }

    public String getConmsg() {
        return conmsg;
    }

    public void setConmsg(String conmsg) {
        this.conmsg = conmsg;
    }

    public String getLatt() {
        return latt;
    }

    public void setLatt(String latt) {
        this.latt = latt;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }
    
    @Override
    public String execute (){
        User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        GeoLocationDAO gdao= new GeoLocationDAO();
        DistributorDAO dao=new DistributorDAO();
        Distributor d=dao.getProfile(user.getUsername());
        gdao.addLocation(latt, longi,d.getDistID());
        setConmsg("Location Updated Successfully");
        return "success";
    }
    
}
