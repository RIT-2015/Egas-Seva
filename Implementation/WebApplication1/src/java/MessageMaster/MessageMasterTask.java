/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageMaster;

/**
 *
 * @author Somesh Mishra
 */
import java.util.*;
import mydatabase.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import mybeans.*;

public class MessageMasterTask extends TimerTask{
    private static MessageMasterTask m;
            
    private MessageMasterTask (){
        
    }

    public static MessageMasterTask getM() {
        if (m==null){
            setM(new MessageMasterTask());
        }
        return m;
    }

    public static void setM(MessageMasterTask m) {
        MessageMasterTask.m = m;
    }
    
    
    @Override
    public void run() {
        MessageBaseDAO mbase = new MessageBaseDAO();
        try{
        Connection con=mbase.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(" select * from  message.messagein where status='new'"); 
        while (rs.next()){
            MessageIN min=new MessageIN();
            min.setSender(rs.getString(2));
            min.setMsg(rs.getString(4));
            min.setId(rs.getString(1));
            MessageOutDAO moutdao = new MessageOutDAO();
            moutdao.sendMessage("Your Request has been received successfully.",min.getSender());
            int x=stmt.executeUpdate("update message.messagein set status='processed' where id="+min.getId());
            String m[]=min.getMsg().split(" ");
            if (m.length<3 || m.length>3){
                moutdao.sendMessage("Sorry Invalid Request", min.getSender());
            }
            else if (!m[0].equalsIgnoreCase("book")){
                moutdao.sendMessage("Sorry Invalid Request", min.getSender());
            }
            else if (!m[1].equalsIgnoreCase("LPG")){
                moutdao.sendMessage("Sorry Invalid Request", min.getSender());
            }
            else{
                int cid=Integer.parseInt(m[2]);
                MasterMessageHelper mh = new MasterMessageHelper(); 
                if (mh.checkCID(cid)){
                    if (!mh.checkPendingOrder(cid)){
                    int did=mh.getDID(cid);
                    Calendar c= Calendar.getInstance();
                    SimpleDateFormat ss=new SimpleDateFormat("dd/MM/yyyy");
                    String da=ss.format(c.getTime());
                    String order="insert into crce.ordertable (c_id,d_id,o_date,no_of_cylinders,status) values ("+cid+","+did+","+da+",1,'undelivered')";
                    mh.insertOrder(order);
                    moutdao.sendMessage("Your order placed successfully", min.getSender());
                    }
                    else{
                        moutdao.sendMessage("You have a pending Order. Another order can be placed only after delivery of current order", min.getSender());
                    }
                }
                else {
                    moutdao.sendMessage("Sorry Invalid Request", min.getSender());
                    
                }
            }
        }
                mbase.closeConnection();
        }
        catch(Exception e)
		{
			System.out.println(e);
		}
    }
}
