/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

import mybeans.Faq;
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import mybeans.User;
import mydatabase.FaqDAO;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author shashi
 */
public class FaqAction extends ActionSupport implements ModelDriven<Faq>, SessionAware {

    private Faq faq;
    Collection faqColln;
    Map session;
    String msg;

    public FaqAction() {
    }

    public String getFaqs() throws Exception {
        
        FaqDAO dao = new FaqDAO();
        faqColln = dao.getFaqs();
        setFaqColln(faqColln);
        return "success";
    }

    public String addFaq() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        FaqDAO dao = new FaqDAO();
        boolean res = dao.addFaq(faq);

        faqColln = dao.getFaqs();
        setFaqColln(faqColln);

        setMsg("FAQ added successfully...");
        return "success";
    }

    public String deleteFaq() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        FaqDAO dao = new FaqDAO();
        boolean res = dao.deleteFaq(faq.getFaqID());

        faqColln = dao.getFaqs();
        setFaqColln(faqColln);
        setMsg("FAQ deleted successfully...");
        return "success";
    }

    
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void setFaqColln(Collection faqColln) {
        this.faqColln = faqColln;
    }

    public Collection getFaqColln() {
        return faqColln;
    }

    public void setFaq(Faq faq) {
        this.faq = faq;
    }

    public Faq getFaq() {
        return faq;
    }

    @Override
    public Faq getModel() {
        return faq;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
}
