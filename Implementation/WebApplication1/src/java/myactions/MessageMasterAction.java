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
import java.util.*;
import MessageMaster.*;
import com.googlecode.sslplugin.annotation.Secured;

@Secured
public class MessageMasterAction extends ActionSupport{
    private static boolean run=false;
    public String startTask (){
        if (run==false){
        Timer timer = new Timer();
       timer.schedule(MessageMasterTask.getM(), 3000, 3000);
       run=true;
        }
        return "success";
    }
}
