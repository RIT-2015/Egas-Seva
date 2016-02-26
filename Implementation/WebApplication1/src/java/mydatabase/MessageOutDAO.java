
package mydatabase;
import java.sql.*;
import mybeans.MessageOut;
import java.net.*;
import java.io.*;
/**
 *
 * @author Somesh Mishra
 */
public class MessageOutDAO extends MessageBaseDAO {
    
    public String sendLoginMeassage (String m_no) {
        String msg="";
        int rand=(int)(Math.random()*1000000);
        msg="Your Random pin is: "+rand+".";
        
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        
			//int x=stmt.executeUpdate("insert into message.messageout (receiver,msg,status) values ('"+m_no+"','"+msg+"','new')");
                       
                  msg="Your%20Random%20pin%20is:%20"+rand+".";      
                   
                        // setup the request
// REQUEST URL should be replaced by the URL you need to request
// For example: http://USERNAME.websitetoolbox.com/register/create_account
// (Replace USERNAME with your Website Toolbox username. If you are using a managed domain or a subdomain, use that instead of USERNAME.websitetoolbox.com.)
URL u = new URL("http://www.smsmaza.tk/way2api/sms.php?txt_username=8898931137&txt_password=skm971990&txt_mobno="+m_no+"&ta_msg="+msg+"&btn_submit=send+sms");
URLConnection uc = u.openConnection();
uc.setDoOutput(true);
uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

// add the query string
// For example: String query = "apikey=APIKEY&member=joe&pw=secret";
String query = "";
PrintWriter pw = new PrintWriter(uc.getOutputStream());
pw.println(query);
pw.close();

// get the input from the request
BufferedReader in = new BufferedReader(
new InputStreamReader(uc.getInputStream()));
String res = in.readLine();
in.close();


		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
                msg="Your Random pin is: "+rand+".";
                return msg;
                
    }
    
    public void sendForgotPassword (String name, String password, String m_no){
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        String msg="Your UserName is:"+name+"and password is:"+password+".";
			int x=stmt.executeUpdate("insert into message.messageout (receiver,msg,status) values ('"+m_no+"','"+msg+"','new')");
                        
                        msg="Your%20UserName%20is:%20"+name+"%20and%20password%20is:%20"+password+".";
                               
                        
                        // setup the request
// REQUEST URL should be replaced by the URL you need to request
// For example: http://USERNAME.websitetoolbox.com/register/create_account
// (Replace USERNAME with your Website Toolbox username. If you are using a managed domain or a subdomain, use that instead of USERNAME.websitetoolbox.com.)
URL u = new URL("http://www.smsmaza.tk/way2api/sms.php?txt_username=8898931137&txt_password=skm971990&txt_mobno="+m_no+"&ta_msg="+msg+"&btn_submit=send+sms");
URLConnection uc = u.openConnection();
uc.setDoOutput(true);
uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

// add the query string
// For example: String query = "apikey=APIKEY&member=joe&pw=secret";
String query = "";
PrintWriter pw = new PrintWriter(uc.getOutputStream());
pw.println(query);
pw.close();

// get the input from the request
BufferedReader in = new BufferedReader(
new InputStreamReader(uc.getInputStream()));
String res = in.readLine();
in.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
    }
    
    public void sendMessage (String msg, String m_no){
        try
		{
			Connection con = getConnection();
			Statement stmt = con.createStatement();
                        int x=stmt.executeUpdate("insert into message.messageout (receiver,msg,status) values ('"+m_no+"','"+msg+"','new')");
                
                       String m []=msg.split(" ");
                       String mess="";
                       for (int i=0; i<m.length; i++){
                           mess+=m[i]+"%20";
                       }
         /*               
                        // setup the request
// REQUEST URL should be replaced by the URL you need to request
// For example: http://USERNAME.websitetoolbox.com/register/create_account
// (Replace USERNAME with your Website Toolbox username. If you are using a managed domain or a subdomain, use that instead of USERNAME.websitetoolbox.com.)
URL u = new URL("http://www.smsmaza.tk/way2api/sms.php?txt_username=8898931137&txt_password=skm971990&txt_mobno="+m_no+"&ta_msg="+mess+"&btn_submit=send+sms");
URLConnection uc = u.openConnection();
uc.setDoOutput(true);
uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

// add the query string
// For example: String query = "apikey=APIKEY&member=joe&pw=secret";
String query = "";
PrintWriter pw = new PrintWriter(uc.getOutputStream());
pw.println(query);
pw.close();

// get the input from the request
BufferedReader in = new BufferedReader(
new InputStreamReader(uc.getInputStream()));
String res = in.readLine();
in.close();
           */     
                
                }
        catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
    }
  
}
