  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import mydatabase.FeedbackDAO;
import java.util.Collection;
import java.util.Map;
import mybeans.Feedback;
import mybeans.MailCall;
import mybeans.User;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

/**
 *
 * @author shashi
 */
public class FeedbackAction extends ActionSupport implements SessionAware {

    private Feedback fb;
    Collection fbColln,c;
    Map session;
    String msg;

    public Collection getC() {
        return c;
    }

    public void setC(Collection c) {
        this.c = c;
    }

    
    
    
    
    public FeedbackAction() {
    }
    @SkipValidation
    public String insertFeedback() throws Exception {

        FeedbackDAO dao = new FeedbackDAO();
        boolean res = dao.insertFeedback(fb);
        
        MailCall m = new MailCall();
        try {
            m.sendMail(fb.getEmail(), "Feedback Received","\n\n\n Your feedback has been received by E-gas Sewa.\nwe will reply soon.\nHave a nice day. \n\n\n Thank You,\n E-gas Sewa.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @SkipValidation
    public String getFeedbacks() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        FeedbackDAO dao = new FeedbackDAO();
        fbColln = dao.getFeedbacks();
        setFbColln(fbColln);
        return "success";
    }
    
     @SkipValidation
    public String getFeedbacksD() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("distributor")) {
            return "home";
        }

        FeedbackDAO dao = new FeedbackDAO();
        fbColln = dao.getFeedbacksD();
        setFbColln(fbColln);
        return "success";
    }

    @SkipValidation
    public String feedbackDetails() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }

        FeedbackDAO dao = new FeedbackDAO();
        fbColln = dao.feedbackDetails(fb.getFbID());
        setFbColln(fbColln);
        return "success";
    }
    
    @SkipValidation
    public String deleteFeedback() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        FeedbackDAO dao = new FeedbackDAO();
        boolean res = dao.deleteFeedback(fb.getFbID());
        
        fbColln = dao.getFeedbacks();
        setFbColln(fbColln);
        setMsg("Feedback deleted Successfully...");
        return "success";
    }

    @SkipValidation
    public String reply() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }

        FeedbackDAO dao = new FeedbackDAO();
        boolean res = dao.reply(fb);
        
        fbColln = dao.feedbackDetails(fb.getFbID());
        setFbColln(fbColln);        
        
        MailCall m = new MailCall();
        try {
            m.sendMail(fb.getEmail(),"Feedback/Complaint Reply", "\n\n\n feedback Reply:\n\n"+fb.getReply()+"\n\n\n Thank You,\n E-gas Sewa.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setMsg("Reply send successfully...");
        return "success";
    }
    
    
    

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public Collection getFbColln() {
        return fbColln;
    }

    public void setFbColln(Collection fbColln) {
        this.fbColln = fbColln;
    }

    public Feedback getFb() {
        return fb;
    }

    public void setFb(Feedback fb) {
        this.fb = fb;
    }


    @Override
    public void setSession(Map session) {
        this.session = session;
    }
    @SkipValidation
    public String feedback()
    {
        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        
        return "feedback1";
        
        
    }
    @SkipValidation
    public String viewReply() throws  ClassNotFoundException, SQLException{
        
        User user=(User)session.get("user");
        if(user==null){
            return "home";}
        
         FeedbackDAO doa=new FeedbackDAO();
        Collection c=doa.getFReply(user.c_id);
         setC(c);
         return "success";
   }
}
