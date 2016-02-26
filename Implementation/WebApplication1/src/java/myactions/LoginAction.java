package myactions;
/**
 *
 * @author Somesh Mishra
 */

import EncryptionMaster.DESEncryptionMaster;
import com.opensymphony.xwork2.ActionSupport;
import java.security.InvalidKeyException;
import java.util.Map;
import javax.crypto.IllegalBlockSizeException;
import org.apache.struts2.interceptor.SessionAware;
import mybeans.User;
import mydatabase.MessageOutDAO;
import mydatabase.UserDAO;
import mydatabase.DistributorDAO;
import mydatabase.AdminDAO;

public class LoginAction extends ActionSupport implements SessionAware{
 
Map session;    
String msg;
User user;
String pinvalue;
String errormsg;

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }


    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getMsg() {
        return msg;
    }

    public  void setMsg(String msg) {
        this.msg = msg;
    }


    public String getPinvalue() {
        return pinvalue;
    }

    public void setPinvalue(String pinvalue) {
        this.pinvalue = pinvalue;
    }


public String authenticate () throws InvalidKeyException, IllegalBlockSizeException{
    if (user.getLogintype().equalsIgnoreCase("user")){
	UserDAO dao= new UserDAO ();
	if (dao.checkCredentials(user.getUsername(), user.getPassword())){
            String mverify=dao.getMVerify(user.getUsername());
            if (mverify.equalsIgnoreCase("yes")){
                String mobileno=(dao.getMobileNo(user.getUsername()));
                MessageOutDAO mdao= new MessageOutDAO();
                DESEncryptionMaster des=new DESEncryptionMaster();
                String mes=mdao.sendLoginMeassage(mobileno);
                mes=des.encrypt(mes);
                setMsg(mes);
                return "mverify";
            }
            else{
               UserDAO udao= new UserDAO();
               user.setC_id(udao.getCID(user.getUsername()));
                session.put("user", user);
                return "userhome";
            }
	}
	else{
            setErrormsg("Incorrect Username or Password");
            user.setPassword("");
            user.setUsername("");
		return"userlogin";
	}
    }
    else if (user.getLogintype().equalsIgnoreCase("distributor")){
        DistributorDAO dao = new DistributorDAO();
        if (dao.checkCredentials(user.getUsername(), user.getPassword())){
            String mobileno=dao.getMobileNo(user.getUsername());
            MessageOutDAO mdao=new MessageOutDAO();
            DESEncryptionMaster des=new DESEncryptionMaster();
                String mes=mdao.sendLoginMeassage(mobileno);
                   mes=des.encrypt(mes);
                setMsg(mes);
            
            return "mverify";
        }
        else{
           setErrormsg("Incorrect Username or Password");
            user.setUsername("");
            user.setPassword("");
            return "dislogin";
        }
    }
    else {
        AdminDAO dao =new AdminDAO();
        if (dao.checkCredentials(user.getUsername(), user.getPassword())){
            String mobileno=dao.getMobileNo(user.getUsername());
            MessageOutDAO mdao=new MessageOutDAO();
            DESEncryptionMaster des=new DESEncryptionMaster();
                String mes=mdao.sendLoginMeassage(mobileno);
           mes=des.encrypt(mes);
                setMsg(mes);
           
            return "mverify";
        }
        else{
            setErrormsg("Incorrect Username or Password");
            user.setUsername("");
            user.setPassword("");
            return "adminlogin";
        }
    }

}

public String pinCheck() throws InvalidKeyException {
    DESEncryptionMaster des = new DESEncryptionMaster();
    String mes=getMsg();
    mes=des.decrypt(mes);
   String pin=mes.substring(20);
   if (pin.equals(getPinvalue()+".")){
        if (user.getLogintype().equalsIgnoreCase("user")){
            UserDAO udao= new UserDAO();
               user.setC_id(udao.getCID(user.getUsername()));
            session.put("user", user);
            return "userhome";
        }
        else if (user.getLogintype().equalsIgnoreCase("distributor")){
            session.put("user", user);
            return "dishome";
        }
        else{
            session.put("user", user);
            return "adminhome";
        }
   }
   else {
       setErrormsg("Incorrect Pin");
       setPinvalue("");
      return "wrong";
    }
    
}

}

