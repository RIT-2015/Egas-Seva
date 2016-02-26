/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactions;

/**
 *
 * @author Somesh Mishra
 */
import java.sql.SQLException;
import org.apache.struts2.interceptor.validation.SkipValidation;
import mybeans.Distributor;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import mybeans.User;
import mydatabase.DistributorDAO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import mydatabase.CustomerDAO;
import mybeans.Customer;
import mybeans.MailCall;
import mybeans.Proof;
import mydatabase.MessageOutDAO;
import mydatabase.ProofDAO;
import mybeans.Order;
import mydatabase.OrderDAO;
import mydatabase.OrderProductDAO;
import mydatabase.ProductDAO;
import mydatabase.TransferDAO;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.apache.struts2.interceptor.ServletRequestAware;

public class DistributorAction extends ActionSupport implements ServletRequestAware, SessionAware{
    Distributor distributor;
    Map session;
    Collection cus,orders,productorders;
    Customer customer;
    String c_id,o_id;
    Proof proof;
    String rej_reason,email_to,mail_message;
    Order order;
    Collection distColln;
    String msg,orderID;
    private HttpServletRequest request;
    
     Collection fbColln;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

     
     
    public Collection getProductorders() {
        return productorders;
    }

    public void setProductorders(Collection productorders) {
        this.productorders = productorders;
    }

     
     
     
    public Collection getFbColln() {
        return fbColln;
    }

    public void setFbColln(Collection fbColln) {
        this.fbColln = fbColln;
    }

    public String getEmail_to() {
        return email_to;
    }

    public void setEmail_to(String email_to) {
        this.email_to = email_to;
    }

    public String getMail_message() {
        return mail_message;
    }

    public void setMail_message(String mail_message) {
        this.mail_message = mail_message;
    }
    
    public Collection getDistColln() {
        return distColln;
    }

    public void setDistColln(Collection distColln) {
        this.distColln = distColln;
    }
    

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public Collection getOrders() {
        return orders;
    }

    public void setOrders(Collection orders) {
        this.orders = orders;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public String getRej_reason() {
        return rej_reason;
    }

    public void setRej_reason(String rej_reason) {
        this.rej_reason = rej_reason;
    }
    
    
    public Proof getProof() {
        return proof;
    }

    public void setProof(Proof proof) {
        this.proof = proof;
    }
    
    
    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection getCus() {
        return cus;
    }

    public void setCus(Collection cus) {
        this.cus = cus;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

  
    
      @Override
    public void setSession(Map session) {
        this.session=session;
    }
                   @SkipValidation  
    public String viewProfile (){
        User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        String username=user.getUsername();
        DistributorDAO dao= new DistributorDAO();
        setDistributor(dao.getProfile(username));
        return "success";
    }
   
            @SkipValidation
    public String updateProfile () {
        User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        DistributorDAO dao=new DistributorDAO();
        dao.updateProfile(getDistributor(),user.getUsername());
        return "success";
    }

          @SkipValidation
    public String viewCustomer () {
        User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        String username=user.getUsername();
       CustomerDAO dao=new CustomerDAO();
        setCus(dao.getDisCustomers(username));
        return "success";
    }
        @SkipValidation
    public String getCustomerDetails  (){
        User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        
        CustomerDAO dao = new  CustomerDAO();
        setCustomer(dao.getCustomerDetail(getC_id()));
        
        ProofDAO pdao= new ProofDAO();
        setProof(pdao.getCusProof(getC_id()));
        return "success";
    }
        
        @SkipValidation
        public String viewProductOrders () throws SQLException, ClassNotFoundException{
         User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        
        OrderProductDAO p=new OrderProductDAO();
        setProductorders(p.getDisProduct(user.getUsername()));
        
            return "success";
        }
        
        
        @SkipValidation
        public String deliverProduct () throws SQLException, ClassNotFoundException{
         User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        OrderProductDAO dao=new OrderProductDAO();
        dao.deliverProduct(getOrderID());
        String s=viewProductOrders();
        return "success";
        }
        
    @SkipValidation
public String deleteCustomer (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        CustomerDAO dao = new  CustomerDAO();
        dao.deleteCustomer(getC_id());
        return "success";
}
          @SkipValidation
public String newApplications (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        String username=user.getUsername();
       CustomerDAO dao=new CustomerDAO();
        setCus(dao.newApplications(username));
        return "success";
}
          @SkipValidation
public String getNewAppDetails (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        CustomerDAO dao = new  CustomerDAO();
        setCustomer(dao.getCustomerDetail(getC_id()));
        
                return "success";
}
          @SkipValidation
public String insertProof (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        ProofDAO pdao = new ProofDAO();
        pdao.insertProof(getProof(),getC_id());
        CustomerDAO dao=new CustomerDAO();
        dao.approveCustomer(getC_id());
        String number=dao.getMobileNo(getC_id()); 
        MessageOutDAO mdao = new MessageOutDAO();
        String message="Congratulations your application for new gas connection has been approved. We at E-gas Sewa welcome you.";
        mdao.sendMessage(message, number);
         MailCall m=new MailCall();
    try{
	m.sendMail(dao.getEmail(getC_id()),"Confirmation", "Congratulations your application for new gas connection has been approved. We at E-gas Sewa welcome you.\n This email is sent to you by: "+user.getUsername());
    } 
    catch (Exception e) {	            
		
         e.printStackTrace();
         return "failure";
    }
    return "success";
}

          @SkipValidation
public String disapproveCustomer (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        CustomerDAO dao=new CustomerDAO();
        MessageOutDAO mdao = new MessageOutDAO();
        String number=dao.getMobileNo(getC_id());
        String email=dao.getEmail(getC_id());
        dao.disapproveCustApplication(getC_id());
        String message="Sorry your LPG gas application has been rejected. The reason for rejection: "+getRej_reason();
        mdao.sendMessage(message, number);
        MailCall m=new MailCall();
    try{
	m.sendMail(email, "","Sorry your LPG gas application has been rejected. The reason for rejection: "+getRej_reason()+"\n This email is sent to you by: "+user.getUsername());
    } 
    catch (Exception e) {	            
		
         e.printStackTrace();
         return "failure";
    }
        return "success";
}
          @SkipValidation
public String getDeliveredOrders (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        String username=user.getUsername();
       OrderDAO dao=new OrderDAO();
        setOrders(dao.getDeliveredOrders(username));
        
    return "success";
}
          @SkipValidation
public String getCancelledOrders (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        String username=user.getUsername();
       OrderDAO dao=new OrderDAO();
        setOrders(dao.getCancelledOrders(username));
    
    return "success";
}
          @SkipValidation
public String generateReport (){
    return "success";
}
          @SkipValidation
public String getPendingOrders (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        String username=user.getUsername();
       OrderDAO dao=new OrderDAO();
        setOrders(dao.getPendingOrders(username));
    return "success";
}
                    @SkipValidation
          public String deliverLPG (){
              User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
         String username=user.getUsername();
         OrderDAO dao=new OrderDAO();
         dao.deliverLPG(getO_id());
         MessageOutDAO mdao=new MessageOutDAO();
         Calendar c=Calendar.getInstance();
         SimpleDateFormat s= new SimpleDateFormat("dd/MM/yyyy");
         String date=s.format(c.getTime());
         String m="Your order with ORDER ID: "+getO_id()+" will be delivered on "+date+" .";
         CustomerDAO cdao= new CustomerDAO();
               String number=cdao.getMobileNo(getC_id());
         mdao.sendMessage(m, number);
              return "success";
          }
                    
       @SkipValidation
       public String getTransferReqs (){
            User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        String username=user.getUsername();
       TransferDAO dao=new TransferDAO();
        setCus(dao.newTransferApplications(username));
       
           return "success";
       }
       
             @SkipValidation
             public String getNewTransferAppDetails (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        String username=user.getUsername();
        TransferDAO dao = new  TransferDAO();
        setCustomer(dao.getCustomerDetail(getC_id(), username));
        
                return "success";
}
       
     @SkipValidation
     public String mailSend (){
         User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        String username=user.getUsername();
      //mail call
       MailCall m=new MailCall();
    try{
	m.sendMail(getEmail_to(),"", getMail_message()+"\n This email is sent to you by: "+username+"");
    } 
    catch (Exception e) {	            
		
         e.printStackTrace();
         return "failure";
    }

        return "success";
     }
              
               @SkipValidation
public String updateProof (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        ProofDAO pdao = new ProofDAO();
        pdao.updateProof(getProof(),getC_id());
        CustomerDAO dao=new CustomerDAO();
        dao.approveTransferCustomer(getC_id());
        String number=dao.getMobileNo(getC_id());
        String email=dao.getEmail(getC_id());
        MessageOutDAO mdao = new MessageOutDAO();
        String message="Congratulations your transfer request application has been approved.";
        mdao.sendMessage(message, number);
       /*  MailCall m=new MailCall();
    try{
	m.sendMail(email, "Congratulations your transfer request application has been approved.\n This email is sent to you by: "+user.getUsername());
    } 
    catch (Exception e) {	            
		
         e.printStackTrace();
         return "failure";
    }
         * 
         */
    return "success";
}

         @SkipValidation
 public String disapproveTransfer (){
    User user=(User)session.get("user");
        if(user==null){
            return "home";
        }
        if(!user.getLogintype().equalsIgnoreCase("distributor")){
            return "home";
        }
        CustomerDAO dao=new CustomerDAO();
        TransferDAO tdao=new TransferDAO();
        MessageOutDAO mdao = new MessageOutDAO();
        String number=dao.getMobileNo(getC_id());
        String email=dao.getEmail(getC_id());
        tdao.disapproveTransferApplication(getC_id());
        String message="Sorry your address transfer request has been rejected. The reason for rejection : "+getRej_reason();
        mdao.sendMessage(message, number);
         /*MailCall m=new MailCall();
    try{
	m.sendMail(email, "Sorry your address transfer request has been rejected. The reason for rejection : "+getRej_reason()+"\n This email is sent to you by: "+user.getUsername());
    } 
    catch (Exception e) {	            
		
         e.printStackTrace();
         return "failure";
    }
         * 
         */
        return "success";
}    
         /*
         @SkipValidation
          public String getFeedbacks() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("distributor")) {
            return "home";
        }

        FeedbackDAO dao = new FeedbackDAO();
        fbColln = dao.getDisFeedbacks();
        setFbColln(fbColln);
        return "success";
    }
                    
   */              
         
         
         
         
         
//     shashi
                    
 
                    
       @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getServletRequest() {
        return request;
    }
/*
    @SkipValidation
    public String recaptchaTest() throws Exception {
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6Lfzq84SAAAAAGddksYEC0cdWnCu18qNE50Mf-sw");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (reCaptchaResponse.isValid()) {

            insertDistributorAppln();
            return "success";
        } else {
            return "input";
        }
    }*/
    @SkipValidation
    public String insertDistributorAppln() throws Exception {

        DistributorDAO dao = new DistributorDAO();
        
        String ans = dao.insertDistributorAppln(distributor);
               
        if(ans.equalsIgnoreCase("email_exists"))
        { 
             setMsg("We have already received Application from your E-mail ID");
             return "input";
        }
        
        MailCall m = new MailCall();
        try {
            m.sendMail(distributor.getEmail(),"New Distributor Application Received.","\n\n\n Your application received by E-Gas Sewa.\nSubmit your documents within 15 days.\n\n\n\n\n Thank You,\n E-gas Sewa.");
        } catch (Exception e) {
            e.printStackTrace();
        }     
        
        return "success";
    }
    
    
    
    

    @SkipValidation
    public String getApplications() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        DistributorDAO dao = new DistributorDAO();
        distColln = dao.getApplications();
        setDistColln(distColln);
        return "success";
    }
    
    
    @SkipValidation
    public String distApplnDetails() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        DistributorDAO dao = new DistributorDAO();
        distColln = dao.distApplnDetails(distributor.getDistID());
        setDistColln(distColln);
        return "success";
    }
    
    
    
    
    @SkipValidation
    public String approveAppln() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        DistributorDAO dao = new DistributorDAO();
        distributor = dao.approveAppln(distributor);
              
        setMsg("Application has been approved...");
        distColln = dao.getApplications();
        setDistColln(distColln);
        
        DistributorDAO ddao=new DistributorDAO(); 
        String number=ddao.getMobileNo("");
        MessageOutDAO mdao = new MessageOutDAO();
        String message="Congratulations your application for new distributor has been approved.";
        mdao.sendMessage(message, number);               
          
        MailCall m = new MailCall();
        try {
            m.sendMail(distributor.getEmail(),"Congratulations!!!","\n\nCongratulations your application for new distributor has been approved.\n\n\n\nYour Account details:\n\nUsername: "+distributor.getEmail()+"\n\nPassword: "+distributor.getPassword()+"\n\n\n\n\n Thank You,\n E-gas Sewa.");
        } catch (Exception e) {
            e.printStackTrace();
        }   
        
        return "success";
    }
    
    @SkipValidation
    public String rejectAppln() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        DistributorDAO dao = new DistributorDAO();
        boolean result = dao.rejectAppln(distributor);
        
        distColln = dao.getApplications();
        setDistColln(distColln);
        setMsg("Application is Rejected...");
        
        String number=distributor.getMobile(); 
        MessageOutDAO mdao = new MessageOutDAO();
        String message="Sorry your application for new distributor has been rejected.";
        mdao.sendMessage(message, number);
  /*      
        MailCall m = new MailCall();
        try {
            m.sendMail(distributor.getEmail(), "\n\n\n Your application rejected by E-Gas Sewa.\n\nReason:"+distributor.getRejReason()+" \n\n\n Thank You,\n E-gas Sewa.");
        } catch (Exception e) {
            e.printStackTrace();
        } 
  */      return "success";
    }
    
    
    
    @SkipValidation
    public String getDistributors() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        DistributorDAO dao = new DistributorDAO();
        distColln = dao.getDistributors();
        setDistColln(distColln);
        return "distributors";
    }

    
    
    
    @SkipValidation
    public String distributorDetails()throws Exception{
        
        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }
        
        DistributorDAO dao = new DistributorDAO();
        distColln = dao.distributorDetails(distributor.getDistID());
        setDistColln(distColln);
        return "success";
    }
    
    
    

    @SkipValidation
    public String deleteDistributor() throws Exception {

        User user = (User) session.get("user");
        if (user == null) {
            return "home";
        }
        if (!user.getLogintype().equalsIgnoreCase("admin")) {
            return "home";
        }

        DistributorDAO dao = new DistributorDAO();
        boolean result = dao.deleteDistributor(distributor.getDistID());
        
        distColln = dao.getDistributors();
        setDistColln(distColln);
        setMsg("Distributor has been deleted successfully...");
        
        String number=distributor.getMobile(); 
        MessageOutDAO mdao = new MessageOutDAO();
        String message="your distributor account has been deleted.";
        mdao.sendMessage(message, number);
    /*    
        MailCall m = new MailCall();
        try {
            m.sendMail(distributor.getEmail(), "\n\n\n Your account has been deactivated by E-Gas Sewa.\n Please visit your nearest E-gas sewa office.\n\n\n Thank You,\n E-gas Sewa.");
        } catch (Exception e) {
            e.printStackTrace();
        }
  */
        return "distributors";
    }

    
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }


    
    
}
