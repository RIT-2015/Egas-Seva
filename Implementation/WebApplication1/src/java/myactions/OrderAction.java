package myactions;


import mydatabase.*;
import mybeans.*;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.io.ObjectOutputStream.PutField;
import java.sql.*;
import java.text.SimpleDateFormat;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shirish
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>, Preparable ,SessionAware
{
     String date1;
     String date2;
    int oid=0;
    int cid;
     Collection c;
    Order ord;
    private boolean b;
    Map session;
    public String type,msg;
   /*
   public String viewOrder() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
   OrderDAO doa=new OrderDAO();
   //ResultSet rs1=doa.getBookedOrder();
   c=doa.getBookedOrder(user.c_id);
   setC(c);
   //Fname=c.toString();
    
            return "success";
   }
   
   
   
   
   
   
   

   public String delOrder() throws SQLException, ClassNotFoundException
    {
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
   OrderDAO doa=new OrderDAO();
   b=doa.deleteOrder(ord,user.c_id);
   
   setOrd(ord);
   
   
   if(b)
       return "delete";
   else
       return"fault";

   }
   
   
   public String generateOrder()
   {
       User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        int cid=user.getC_id();
        setCid(cid);
       CustomerDAO dao=new CustomerDAO();
       String type=dao.getType(cid);
       setType(type);
       Calendar cal = null;
    Calendar cldr = null;
    cal=Calendar.getInstance();
    cldr=Calendar.getInstance();
    SimpleDateFormat datefor=new SimpleDateFormat("dd/MM/yyyy");
    String mydate=datefor.format(cal.getTime());
       java.util.Date newdate;
       cldr.add(Calendar.DAY_OF_MONTH, +10);
    String deldate=datefor.format(cldr.getTime());
       setDate1(mydate);
       setDate2(deldate);
       
       return "generate";
   }
   
   
   public String addOrder()
   {
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
       
       
   OrderDAO doa=new OrderDAO();
   b=doa.insertOrder(user.getC_id());

   if(b)
   
          return "insert";
   else
       return"fault";
       
   }


   
   public void setOid(int oid)
   {this.oid=oid;}
   
   public int getOid()
   {return oid;}
   
public void setDate1(String date1)
    {
    System.out.println("setter");
    this.date1=date1;
    }

public String getDate1()
    {System.out.println("getter");
    return (this.date1);
    }

    public void setDate2(String date2)
    {
    System.out.println("setter");
    this.date2=date2;
    }

public String getDate2()
    {System.out.println("getter");
    return (this.date2);
    }



    public void setC(Collection c) {
        this.c=c;
    }

    public Collection getC()
    {return (this.c);}

    public void setOrd(Order ord)
    {this.ord=ord;}

    public Order getOrd()
    {return ord;}
    
    
    public void setCid(int cid)
    {this.cid=cid;}
    
    public int getCid()
    {return cid;}
    
    @Override
    public Order getModel() {
        return ord;
    }

    @Override
    public void prepare() throws Exception {
        ord=new Order();
    }

     @Override
    public void setSession(Map session) {
        this.session=session;
    }

    public void setType(String type) {
       this.type=type;
    }
    public String getType() {
       return type;
    }
*/

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
    
    public void setOid(int oid){
       this.oid=oid;
   }
   
   public int getOid(){
       return oid;
   }
   
public void setDate1(String date1){
    System.out.println("setter");
    this.date1=date1;
    }

public String getDate1(){
    System.out.println("getter");
    return (this.date1);
    }

    public void setDate2(String date2){
    System.out.println("setter");
    this.date2=date2;
    }

public String getDate2(){
    System.out.println("getter");
    return (this.date2);
    }

    public void setC(Collection c) {
        this.c=c;
    }

    public Collection getC(){
        return (this.c);
    }

    public void setOrd(Order ord){
        this.ord=ord;
    }

    public Order getOrd(){
        return ord;
    }
        
    public void setCid(int cid){
        this.cid=cid;
    }
    
    public int getCid(){
        return cid;
    }
    
    @Override
    public Order getModel() {
        return ord;
    }

    @Override
    public void prepare() throws Exception {
        ord=new Order();
    }

     @Override
    public void setSession(Map session) {
        this.session=session;
    }

    public void setType(String type) {
       this.type=type;
    }
    public String getType() {
       return type;
    }
    
    
    //---------- my methods ----------
    
    
   public String viewOrder() throws SQLException, ClassNotFoundException{
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
         OrderDAO doa=new OrderDAO();
         c=doa.getBookedOrder(user.c_id);
         setC(c);
         return "penOrd";
   }
   
   //---------------- 24/4/2012
    
   public String pendingOrder() throws SQLException, ClassNotFoundException{
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
         OrderDAO doa=new OrderDAO();
         c=doa.getBookedOrder(user.c_id);
         setC(c);
         
         return "penOrd";
   }
   
   
   
    public String viewDeliveredOrders () throws SQLException, ClassNotFoundException{
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        
        
        String username=user.getUsername();
       OrderDAO dao=new OrderDAO();
        setC(dao.getCDeliveredOrders(user.getC_id()));
        
    return "deliveredOrd";
}
          @SkipValidation
public String viewCancelledOrders () throws SQLException, ClassNotFoundException{
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        
        String username=user.getUsername();
       OrderDAO dao=new OrderDAO();
        setC(dao.getCCancelledOrders(user.getC_id()));
    
    return "cancelledOrd";
}
    
   
   public String delOrder() throws SQLException, ClassNotFoundException{
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
       OrderDAO doa=new OrderDAO();
       b=doa.deleteOrder(ord,user.c_id);
       setOrd(ord);
       if(b)
       {c=doa.getBookedOrder(user.c_id);
         setC(c);
         setMsg("Order cancelled successfully.....");
       return "success";}
       else
       return"fault";

   }
   
   
   public String generateOrder() throws SQLException, ClassNotFoundException{
       User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        int cid=user.getC_id();
        setCid(cid);
        CustomerDAO dao=new CustomerDAO();
        String type=dao.getType(cid);
        setType(type);
        Calendar cal = null;
        Calendar cldr = null;
        Calendar cal2 = null;
        
        cal=Calendar.getInstance();
        cldr=Calendar.getInstance();
        cal2=Calendar.getInstance();
        
        SimpleDateFormat datefor=new SimpleDateFormat("dd/MM/yyyy");
        String mydate=datefor.format(cal.getTime());
        
        cldr.add(Calendar.DAY_OF_MONTH, +10);
        String deldate=datefor.format(cldr.getTime());
        
        
        OrderDAO dao1=new OrderDAO();
        String lastdate= dao1.getLastOrder(user.getC_id());
        
        java.util.Date my=cal.getTime();
        String s[]=lastdate.split("/");
        int d=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        m=m-1;
        int y=Integer.parseInt(s[2]);
        cal2.set(y, m, d);
        java.util.Date last=cal2.getTime();
        String laststatus= dao1.getLastStatus(cid);
        
        
      /*  boolean allow=my.after(last);
        if(allow){  
        setDate1(mydate);
        setDate2(deldate);
        return "generate";
        } 
        */
         if(laststatus.equalsIgnoreCase("delivered")||laststatus.equalsIgnoreCase("cancelled"))
        {setDate1(mydate);
        setDate2(deldate);
        return "generate";}  
        
        else return "notallowed";
        
     }
   
   
   public String addOrder(){
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
       
       
     OrderDAO doa=new OrderDAO();
     b=doa.insertOrder(user.getC_id());

     if(b)
     return "insert";
     else
     return"fault";
   }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
