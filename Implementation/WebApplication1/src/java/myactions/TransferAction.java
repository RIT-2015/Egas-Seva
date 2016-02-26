/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myactions;
import mydatabase.*;
import myBeans.*;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.io.ObjectOutputStream.PutField;
import java.sql.*;
import mybeans.Transfer;
import mybeans.User;
import org.apache.struts2.interceptor.SessionAware;
/**
 *
 * @author Shirish
 */
public class TransferAction extends ActionSupport implements ModelDriven<Transfer>,Preparable,SessionAware
{
     Transfer t;
     Transfer ttemp=new Transfer();
    private boolean b;
    Map session;
    private int cid;
    String newaddr,newcity,newstate;
    int newdid;

    
    @Override
    public Transfer getModel() {
        return t;
    }

    @Override
    public void prepare() throws Exception {
        t=new Transfer();
    }

     @Override
    public void setSession(Map session) {
        this.session=session;
    }

    public void setCid(int cid) {
       this.cid=cid;
    }
    
    public int getCid() {
       return cid;
    }
    
    
    public void setNewdid(int did) {
       this.newdid=did;
    }
    
    public int getNewdid() {
       return newdid;
    }
    
    
    
    
    
    public void setNewaddr(String Newaddr) {
       this.newaddr=newaddr;
    }
    
    public void setNewcity(String newcity) {
       this.newcity=newcity;
    }
    
    public void setNewstate(String newstate) {
       this.newstate=newstate;
    }
    
    public String getNewaddr() {
       return newaddr;
    }
    public String getNewCity() {
       return newcity;
    }
    public String getNewstate() {
       return newstate;
    }
    
    
    
    
    public void setT(Transfer t)
    {System.out.println("Inside setter"); this.t=t;}

    public Transfer getT()
    {System.out.println("Inside getter");return t;}

    
    /*
    public String changereq()
    { 
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        Transfer t=new Transfer();
        t.setC_id(""+user.c_id);
        setT(t);
        
        return "success";}

        
        
        
        public String generateReq()
   {
       User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
        
        
        int cid=user.getC_id();
        setCid(cid);
        setNewaddr(t.getNewaddr());
        setNewcity(t.getNewcity());
        setNewstate(t.getNewstate());
        setNewdid(Integer.parseInt(t.getD_id()));
        
        /*t.setC_id(""+user.getC_id());
        t.setNewaddr(t.getNewaddr());
        t.setNewcity(t.getNewcity());
        t.setNewstate(t.getNewstate());
        t.setD_id(t.getD_id());
        
        Transfer t=new Transfer();
        this.t.setC_id(""+cid);
        this.t.setD_id(""+newdid);
       this.t.setNewaddr(newaddr);
       this.t.setNewcity(newcity);
       this.t.setNewstate(newstate);
        setT(this.t);
        
        
        
        System.out.println(this.t.getNewcity());
        
        return"generate";
   }
        
  
        
        
        public String changeAddr() throws SQLException
        {
            User user=(User)session.get("user");
        if(user==null){
            return "home";}
            
        
            
            
            TransferDAO dao=new TransferDAO();
            b=dao.changeaddress(t,user.c_id);

            if(b)
            return "transfer";
            else return "error";
        }
       */
    
    
    
    
    
    public String changereq()
    { 
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        Transfer t=new Transfer();
        t.setC_id(""+user.c_id);
        setT(t);
        
        return "success";}

        
        
        
        public String generateReq()
   {
       User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
        
        
        int cid=user.getC_id();
        setCid(cid);
        setNewaddr(t.getNewaddr());
        setNewcity(t.getNewcity());
        setNewstate(t.getNewstate());
        setNewdid(Integer.parseInt(t.getD_id()));
        
        /*t.setC_id(""+user.getC_id());
        t.setNewaddr(t.getNewaddr());
        t.setNewcity(t.getNewcity());
        t.setNewstate(t.getNewstate());
        t.setD_id(t.getD_id());*/
        
        Transfer t=new Transfer();
        this.t.setC_id(""+cid);
        this.t.setD_id(""+newdid);
       this.t.setNewaddr(newaddr);
       this.t.setNewcity(newcity);
       this.t.setNewstate(newstate);
        setT(this.t);
        
        
        
        System.out.println(this.t.getNewcity());
        
        return"generate";
   }
        
  
        
        
       public String changeAddr() throws SQLException
        {
            User user=(User)session.get("user");
        if(user==null){
            return "home";}
            
        
            
            
            TransferDAO dao=new TransferDAO();
            
            if(dao.checkReq(user.getC_id()))
            {            
            b=dao.changeaddress(t,user.c_id);
            if(b)
            return "transfer";
            else return "error";
        }
            
            
            else return "Treqpending";
        }
   
    
    
    
    
    
    
    
}
