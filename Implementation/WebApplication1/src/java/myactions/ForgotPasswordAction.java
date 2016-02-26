/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

/**
 *
 * @author Somesh Mishra
 */
import com.opensymphony.xwork2.ActionSupport;
import mybeans.UserTable;
import mydatabase.UserDAO;
import mydatabase.AdminDAO;
import mydatabase.DistributorDAO;
import mydatabase.MessageOutDAO;
public class ForgotPasswordAction extends ActionSupport{
    UserTable user;
    String errormsg;

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }
    
    public String sendPassword (){
        UserDAO dao= new UserDAO();
        DistributorDAO ddao=new DistributorDAO();
        AdminDAO adao = new AdminDAO();
        if (dao.checkUsername(user.getUsername())){
        MessageOutDAO mdao= new MessageOutDAO();
        user.setPassword(dao.getUserPassword(user.getUsername()));
        user.setMobile_no(dao.getMobileNo(user.getUsername()));
        mdao.sendForgotPassword(user.getUsername(), user.getPassword(), user.getMobile_no());
        return "success";
        }
        else if (ddao.checkUsername(user.getUsername())){
        MessageOutDAO mdao= new MessageOutDAO();
        user.setPassword(ddao.getDisPassword(user.getUsername()));
        user.setMobile_no(ddao.getMobileNo(user.getUsername()));
        mdao.sendForgotPassword(user.getUsername(), user.getPassword(), user.getMobile_no());
        return "success";
        }
        else if (adao.checkUsername(user.getUsername())){
           MessageOutDAO mdao= new MessageOutDAO();
        user.setPassword(adao.getAdminPassword(user.getUsername()));
        user.setMobile_no(adao.getMobileNo(user.getUsername()));
        mdao.sendForgotPassword(user.getUsername(), user.getPassword(), user.getMobile_no());
        return "success"; 
        }
        else{
            setErrormsg("User Does Not Exist");
            user.setUsername("");
            return "invalid";
        }
    }
    
}
