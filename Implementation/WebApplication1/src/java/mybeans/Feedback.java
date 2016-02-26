/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

/**
 *
 * @author shashi
 */
public class Feedback {
    
//9 
    private String fbID;
    private String distID;
    private String custID;
    private String type;
    private String category;
    private String description;
    private String email;
    private String referenceNo;
    private String reply;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistID() {
        return distID;
    }

    public void setDistID(String distID) {
        this.distID = distID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFbID() {
        return fbID;
    }

    public void setFbID(String fbID) {
        this.fbID = fbID;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   
   
}
