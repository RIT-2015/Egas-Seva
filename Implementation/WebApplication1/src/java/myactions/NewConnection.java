/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

import mybeans.*;
import mydatabase.CustomerDAO;

import com.opensymphony.xwork2.*;
import net.tanesha.recaptcha.*;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
/**
 *
 * @author shashi
 */
public class NewConnection extends ActionSupport implements ModelDriven<Customer>, ServletRequestAware {

    private Customer customer;
    static int id = 0;
    private HttpServletRequest request;
    String msg;
    
    public NewConnection() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
     @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getServletRequest() {
        return request;
    }
    
    @SkipValidation
    public String recaptchaTest() throws Exception {
        
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6Lfzq84SAAAAAGddksYEC0cdWnCu18qNE50Mf-sw");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (reCaptchaResponse.isValid()) {
          
            String result=insertConnectionAppln();
            return "success";
      } 
        else {
            return "input";
        }
    }
    @SkipValidation
    public String insertConnectionAppln() throws Exception {

        CustomerDAO dao = new CustomerDAO();
        
        String ans = dao.insertNewConnection(customer);
       
        if(ans.equalsIgnoreCase("distID_not_exists"))
        { 
             setMsg("Please enter correct distributor ID");
             return "input";
        }
        if(ans.equalsIgnoreCase("email_exists"))
        { 
             setMsg("We have already received Application from your E-mail ID");
             return "input";
        }
         
        MailCall m = new MailCall();
        try {
            m.sendMail(customer.getEmail(), "New LPG Connection Application Received","\n\n\n Your New Connection application has been received by e-gas sewa.\n Please submit your documents within 15 days to your selected Distributor office.\n\n\n Thank You,\n E-gas Sewa.");
        } catch (Exception e) {

            e.printStackTrace();
        }
        return "success";
    }

    
    
    
   public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Customer getModel() {
        return customer;
    }
    
    
}

