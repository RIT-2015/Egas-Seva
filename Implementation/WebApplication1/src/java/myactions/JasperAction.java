/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

/**
 *
 * @author Acer
 */
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JasperCompileManager;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Collection;
import java.util.Map;
import mybeans.*;
import mydatabase.OrderDAO;
import org.apache.struts2.interceptor.SessionAware;

public class JasperAction extends ActionSupport implements SessionAware {

    Map session;
    Collection lpgOrders;

    public Collection getLpgOrders() {
        return lpgOrders;
    }

    public void setLpgOrders(Collection lpgOrders) {
        this.lpgOrders = lpgOrders;
    }

    

 @Override
    public void setSession(Map session) {
        this.session=session;
    }
 
    @Override
    public String execute() throws Exception {
        User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
       try {
            JasperCompileManager.compileReportToFile(
                   "C:/Users/Acer/BE Project/Implementation/WebApplication1/web/reports/LPGOrderDis.jrxml",
                   "C:/Users/Acer/BE Project/Implementation/WebApplication1/web/reports/our_compiled_template.jasper");
        } catch (Exception e) {
            System.out.println ("Error in class");
            e.printStackTrace();
            return "error";
        }

        return "success";
    }
    
      
    public String lpgOrder(){
        User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        OrderDAO dao=new OrderDAO();
        setLpgOrders(dao.lpgOrderDis(user.getUsername()));
       
         try {
            JasperCompileManager.compileReportToFile(
                   "C:/Documents and Settings/Somesh Mishra/My Documents/NetBeansProjects/Implementation/WebApplication1/web/reports/LPGOrderDis.jrxml",
                   "C:/Documents and Settings/Somesh Mishra/My Documents/NetBeansProjects/Implementation/WebApplication1/web/reports/LPGOrderDis.jasper");
        } catch (Exception e) {
            System.out.println ("Error in class");
            e.printStackTrace();
            return "error";
        }
        
         
        return "success";
    }
}
