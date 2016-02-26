/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myactions;
import mydatabase.*;
import java.util.*;
import java.sql.*;
import mybeans.*;
import mydatabase.CustomerDAO;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.struts2.interceptor.SessionAware;



/**
 *
 * @author Shirish
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>,Preparable, SessionAware
{
    private Collection c;
    Customer cust;
    private boolean updt;
   Map session;
   String img;
    private HttpServletRequest request;
    static int id = 0;
    String msg,subject;
    String password2,pass1,pass2,oldpass,mv,mv2;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    private void setC(Collection c) {
        this.c=c;
    }

public Collection getC()
    {return c;}

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String getMv() {
        return mv;
    }

    public void setMv(String mv) {
        this.mv = mv;
    }

    public String getMv2() {
        return mv2;
    }

    public void setMv2(String mv2) {
        this.mv2 = mv2;
    }

    
    
    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    
    
    



    
public void setCust(Customer cust)
    { System.out.println("setting cust");this.cust=cust;System.out.println("cust"+this.cust.getFname());}

    public Customer getCust() {
        System.out.println("getting cust");
        return cust;
    }


    @Override
    public Customer getModel() {
        return cust;
    }

    @Override
    public void prepare() throws Exception {
        cust=new Customer();
    }
    
    @Override
    public void setSession(Map session) {
        this.session=session;
    }
    
    
    public void setImg(String img)
    {this.img=img;}
    
    public String getImg()
    {return img;}
    
    
    
    public String ok()
    {
    
    return "profile";
    }
    
    @SkipValidation
    public String viewCDetails() throws SQLException, ClassNotFoundException
    {
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
        CustomerDAO dao=new CustomerDAO();
       Customer cust=dao.getCustDetails(user.c_id);
       
       UserDAO dao2=new UserDAO();
       String usrnm=dao2.getUsrname(user.getC_id());
       String passwd=dao2.getPasswd(user.getC_id());
       cust.setUsername(usrnm);
       cust.setPassword(passwd);
        setCust(cust);
        
        String mv=dao2.getmsgv(user.getC_id());
        
        setMv(mv);
        
        
        return "success";
    }

    
    @SkipValidation
    public String update() throws SQLException, ClassNotFoundException
    {   
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        
        CustomerDAO dao=new CustomerDAO();
       Customer cust=dao.getCustDetails(user.c_id);
        setCust(cust);
        
        UserDAO dao2=new UserDAO();
       String usrnm=dao2.getUsrname(user.getC_id());
       String passwd=dao2.getPasswd(user.getC_id());
       cust.setUsername(usrnm);
       cust.setPassword(passwd);
        setCust(cust);
       
       String mv=dao2.getmsgv(user.getC_id());
        
        setMv(mv);
        
       
        
        return "update";
    }

@SkipValidation
     public String updateProfile() throws SQLException, ClassNotFoundException
    {  
       User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        String p=getMv2();
        System.out.print("msg verification :"+p);
        
        CustomerDAO dao=new CustomerDAO();
        boolean b=dao.updateCust(cust,user.c_id);
        
        UserDAO dao2=new UserDAO();
        boolean b2=dao2.updatemv(p,user.getC_id());
        
        
        if(b && b2){
        
            Customer cust=dao.getCustDetails(user.c_id);
       
       dao2=new UserDAO();
       String usrnm=dao2.getUsrname(user.getC_id());
       String passwd=dao2.getPasswd(user.getC_id());
       cust.setUsername(usrnm);
       cust.setPassword(passwd);
        setCust(cust);
        
        String mv=dao2.getmsgv(user.getC_id());
        
        setMv(mv);
        
        setMsg("Profile updated successfully....");
        
        return "success";
            
            
        }
        else
            return "error";
        
        
        
        
    }

@SkipValidation
    public String orderproduct() throws SQLException, ClassNotFoundException
    {
        ProductDAO dao=new ProductDAO();
        c=dao.getAllProduct();
    
        setC(c);
    
        return "product";
    }
    
    @SkipValidation
    public String invite() throws SQLException, ClassNotFoundException
   {
    User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
        CustomerDAO dao=new CustomerDAO();
        String cid=Integer.toString(user.getC_id());
        String sub=dao.getEmail(cid);
       sub="Egas invitation from "+sub;
    setSubject(sub);   
       return "invite";}
    
    
   
   
 public String inviteFriend()
 {
     
 return "invited";
 }
 
 @SkipValidation
 public String chng()
 {return "chng";}
 @SkipValidation
 public String chngpass() throws SQLException, ClassNotFoundException
 {
      User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
       boolean b;
        String pass1=getPass1();
        String pass2=getPass2();
        String oldpass=getOldpass();
        UserDAO dao2=new UserDAO();
        String oldpass2=dao2.getPasswd(user.getC_id());
        
        if(oldpass.equals(oldpass2)){
        
        if(pass1.equals(pass2))
        {
            
             b=dao2.updatepass(user.getC_id(),pass1);
             if(b)
             {
                 CustomerDAO dao=new CustomerDAO();
                 Customer cust=dao.getCustDetails(user.c_id);
       
       String usrnm=dao2.getUsrname(user.getC_id());
       String passwd=dao2.getPasswd(user.getC_id());
       cust.setUsername(usrnm);
       cust.setPassword(passwd);
        setCust(cust);
        
        String mv=dao2.getmsgv(user.getC_id());
        
        setMv(mv);
        
        setMsg("Password changed successfully....");
        
        return "success";
            
                 
                 
                 }
             else return "error";
        
        }
         
        else return "error";
        
        }
 else return "error";
 
 
 }
 
 
    
  /* 
     * Pratik
     * 
     * public String viewproduct()
    {
        ProductDAO dao=new ProductDAO();
      String img= dao.getproduct();
       setImg(img);
       Product pro=new Product();
       pro.setImg(img);
       System.out.print("img :"+getImg());
       
    return "viewproduct";
    }*/
   
    
    
    
// shashi
    
    
    public CustomerAction() {
    }

    
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getServletRequest() {
        return request;
    }
 /*   
    @SkipValidation
    public String recaptchaTest() throws Exception {
        
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6Lfzq84SAAAAAGddksYEC0cdWnCu18qNE50Mf-sw");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (reCaptchaResponse.isValid()) {
          
            String result=register();
            return "success";
      } 
        else {
            return "input";
        }
    }
*/    
    
   //customerAction   

 @SkipValidation 
    public String register() throws Exception {

        CustomerDAO dao = new CustomerDAO();
        
        String ans = dao.register(cust);
        
        if(ans.equalsIgnoreCase("not_found"))
        { 
             setMsg("Consumer no. does not exist.\n Please enter correct Consumer no.");
             return "input";
        }
        if(ans.equalsIgnoreCase("id_exists"))
        { 
             setMsg("Your consumer no. is already Registered");
             return "input";
        }
        if(ans.equalsIgnoreCase("email_exists"))
        { 
             setMsg("Your E-mail ID is already Registered");
             return "input";
        }
        if(ans.equalsIgnoreCase("username_exists"))
        { 
             setMsg("Username already exist.\n Please enter other Username");
             return "input";
        }
        
        MailCall m = new MailCall();
        try {
            m.sendMail(cust.getEmail(),"Customer Registration details", "\n\n\n You are successfully registered to E-Gas Sewa.\n Your Username: " + cust.getUsername() + "\nPassword: "+cust.getPassword()+"\n\n Thank You,\n E-gas Sewa.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

  


}
