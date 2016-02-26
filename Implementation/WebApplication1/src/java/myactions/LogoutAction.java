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
import org.apache.struts2.interceptor.SessionAware;
import java.util.*;
public class LogoutAction extends ActionSupport implements SessionAware {
    Map session;

	
	public void setSession(Map session)
	{
		this.session = session;
	}
	public String execute()
	{
		session.remove("user");
		return "success";
	} 
}
