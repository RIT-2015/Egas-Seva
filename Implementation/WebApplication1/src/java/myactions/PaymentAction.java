/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author Somesh Mishra
 */
public class PaymentAction extends ActionSupport {
    OrderProduct ordpro;

    public OrderProduct getOrdpro() {
        return ordpro;
    }

    public void setOrdpro(OrderProduct ordpro) {
        this.ordpro = ordpro;
    }
    @SkipValidation
    public String execute(){
        return "input";
    } 
}
