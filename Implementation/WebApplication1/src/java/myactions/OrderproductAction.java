/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

import mybeans.*;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.io.ObjectOutputStream.PutField;
import java.sql.*;
import java.text.SimpleDateFormat;
import mydatabase.OrderProductDAO;
import mydatabase.ProductDAO;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Somesh Mishra
 */
public class OrderproductAction extends ActionSupport implements ModelDriven<Orderproduct>, Preparable ,SessionAware{
    private Map session;
    private Orderproduct ordpro;
    Collection c;
    private boolean b;
    String pid,cid,pname,quan,pprice,msg;
    
    public void setC(Collection c) {
        this.c=c;
    }

    public Collection getC()
    {return (this.c);}

    public void setOrdpro(Orderproduct ordpro)
    {this.ordpro=ordpro;}

    public Orderproduct getOrdpro()
    {return ordpro;}
    
      public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
    
     @Override
    public Orderproduct getModel() {
        return ordpro;
    }

    @Override
    public void prepare() throws Exception {
        ordpro=new Orderproduct();
    }

     @Override
    public void setSession(Map session) {
        this.session=session;
    }
    
    
    /*
    
    public String viewProductOrder() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
   OrderProductDAO doa=new OrderProductDAO();
   //ResultSet rs1=doa.getBookedOrder();
   c=doa.getBookedProduct(user.c_id);
   setC(c);
   //Fname=c.toString();
    
            return "productorder";
   }
   
   
   public String delOrderProduct() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
   OrderProductDAO doa=new OrderProductDAO();
   b=doa.deleteOrderProduct(ordpro,user.c_id);
   
   setOrdpro(ordpro);
   
   
   if(b)
       return "deleteproduct";
   else
       return"fault";

   }
    
    */
     
     
     public String viewProductOrder() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
   OrderProductDAO doa=new OrderProductDAO();
   //ResultSet rs1=doa.getBookedOrder();
   c=doa.getBookedProduct(user.c_id);
   setC(c);
   //Fname=c.toString();
    
            return "Pprod";
   }
     
     
      public String viewPProductOrder() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
   OrderProductDAO doa=new OrderProductDAO();
   //ResultSet rs1=doa.getBookedOrder();
   c=doa.getBookedProduct(user.c_id);
   setC(c);
   //Fname=c.toString();
    
            return "Pprod";
   }
     
     
     public String viewDProductOrder() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
   OrderProductDAO doa=new OrderProductDAO();
   //ResultSet rs1=doa.getBookedOrder();
   c=doa.getDProduct(user.c_id);
   setC(c);
   //Fname=c.toString();
    
            return "Dprod";
   }
     
     
     public String viewCProductOrder() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
   OrderProductDAO doa=new OrderProductDAO();
   //ResultSet rs1=doa.getBookedOrder();
   c=doa.getCProduct(user.c_id);
   setC(c);
   //Fname=c.toString();
    
            return "Cprod";
   }
   
   
   public String delOrderProduct() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
   OrderProductDAO doa=new OrderProductDAO();
   b=doa.deleteOrderProduct(ordpro,user.c_id);
   
   setOrdpro(ordpro);
   
   
   if(b){c=doa.getBookedProduct(user.c_id);
   setC(c);
   //Fname=c.toString();
    setMsg("Order cancelled successfully....");
            return "productorder";
       
       }
   else
       return"fault";

   }

   public String orderproduct() throws SQLException, ClassNotFoundException
    {
        ProductDAO dao=new ProductDAO();
        c=dao.getAllProduct();
    
        setC(c);
    
        return "product";
    }  

    
    public String generateProOrder() throws SQLException, ClassNotFoundException
    {   
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        setPid(ordpro.getProdID());
        setCid(""+(user.getC_id()));
        
        ProductDAO dao=new ProductDAO();
        String name=dao.findName(Integer.parseInt(pid));
        
        
        setPname(dao.findName(Integer.parseInt(pid)));
       // setPrice(Integer.parseInt(pro.getPrice()));
        System.out.println("ppppp  "+dao.findPrice(Integer.parseInt(pid)));
       setPprice(dao.findPrice(Integer.parseInt(pid)));
        
           return "generate";
    
    }
    
     public String placeOrder() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
    
        
        
       // System.out.println("Quantity ; "+getQuan());
        
      
       
        
  //      ProductDAO dao2=new ProductDAO();
//        String km=dao2.findPrice(Integer.parseInt(ordpro.getProdID()));
            
    //    System.err.println("KM   :" +km);
        
        
        OrderProductDAO pdao=new OrderProductDAO();
        
        boolean b=pdao.insertorder(ordpro,user.getC_id());
        
                
        if(b)
        
        return "proOrder";
        
        else return "error";
    
    
    
    
    }

    
}
