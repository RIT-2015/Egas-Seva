/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import mybeans.User;
import mydatabase.AdminDAO;
import java.util.Collection;
import mybeans.Admin;
import mybeans.GeoLocation;
import mybeans.MailCall;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author shashi
 */
public class AdminAction extends ActionSupport implements SessionAware {

    private Admin admin;
    private GeoLocation gl;
    Collection adminColln;
    Map session;
    String msg;

    public AdminAction() {
    }

    @SkipValidation
    public String viewProfile() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        String username = user.getUsername();

        AdminDAO dao = new AdminDAO();
        adminColln = dao.viewProfile(username);
        setAdminColln(adminColln);
        return "viewProfile";
    }

    @SkipValidation
    public String updatePage() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        String username = user.getUsername();

        AdminDAO dao = new AdminDAO();
        Admin a = dao.updatePage(username);
        setAdmin(a);
        return "updatePage";
    }
/*
    @SkipValidation
    public String checkUsername() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        String username = user.getUsername();

        AdminDAO dao = new AdminDAO();
        boolean res = dao.checkUsername(admin.getUsername());

        Admin a = dao.updatePage(username);
        setAdmin(a);

        if (res == true) {
            setMsg("Username is available.");
        } else {
            setMsg("Username is not available.");
        }

        return "updatePage";
    }
*/
    @SkipValidation
    public String updateProfile() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        String username = user.getUsername();

        AdminDAO dao = new AdminDAO();
  /*
        boolean res1 = dao.checkUsername(admin.getUsername());
        if (res1 == false) {
            setMsg("Username is not available.");
             return "updatePage";
        } 
   */    
        boolean res = dao.updateProfile(admin);

        adminColln = dao.viewProfile(username);
        setAdminColln(adminColln);
        setMsg("Profile updated successfully.....");
          
        return "viewProfile";

       
    }

    public GeoLocation getGl() {
        return gl;
    }

    public void setGl(GeoLocation gl) {
        this.gl = gl;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Collection getAdminColln() {
        return adminColln;
    }

    public void setAdminColln(Collection adminColln) {
        this.adminColln = adminColln;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
}
