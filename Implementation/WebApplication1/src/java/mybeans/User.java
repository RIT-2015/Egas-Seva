/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

/**
 *
 * @author Somesh Mishra
 */
public class User {
    String username;
    String password;
    String logintype;
    public int c_id;

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
    
    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
