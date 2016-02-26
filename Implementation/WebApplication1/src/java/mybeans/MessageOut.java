/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

/**
 *
 * @author Somesh Mishra
 */
public class MessageOut {
    String id;
    String receiver;
    String sendtime;
    String msg;
    String status;

    public void setId(String id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSendtime() {
        return sendtime;
    }

    public String getStatus() {
        return status;
    }
    
}
