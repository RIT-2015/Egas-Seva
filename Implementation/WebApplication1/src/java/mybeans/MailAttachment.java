/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

/**
 *
 * @author shashi
 */  
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

/*
 * @author shashi
 */
public class MailAttachment {
 
    private String to;
    private String from;
    private String message;
    private String subject;
    private String smtpServ;

     public int sendMail(String to1,String message1)
     {
        try
        {
            Properties props = System.getProperties();
                    // Attaching to default Session, or we could start a new one
            props.put("mail.transport.protocol", "smtp" );
            props.put("mail.smtp.starttls.enable","true" );
            props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.auth", "true" );

            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
                                                         // Create a new message
            Message msg = new MimeMessage(session);
                                                    //Set the FROM and TO fields
            msg.setFrom(new InternetAddress("egas.sewa2012@gmail.com"));
            
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to1, false));
            msg.setSubject(message1);
            msg.setText(message1);
                                             //Set some other header information
            msg.setHeader("MyMail", "Mr. XYZ" );
            msg.setSentDate(new Date());


// Attaching a file

                                                      // Create the message part
         BodyPart msgBodyPart = new MimeBodyPart();
                                                             // Fill the message
         msgBodyPart.setText("hello");

         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(msgBodyPart);

                                                       // Part two is attachment
         msgBodyPart = new MimeBodyPart();
         String filename = "E:/CreatingProjects/E_Gas/web/file.txt";
         DataSource source = new FileDataSource(filename);
         msgBodyPart.setDataHandler(new DataHandler(source));
         msgBodyPart.setFileName(filename);
         multipart.addBodyPart(msgBodyPart);

         // Put parts in message
         msg.setContent(multipart);
//

                                                     // -- Send the message --
              Transport.send(msg);

              System.out.println("Message sent to"+to1+" OK." );
              return 0;
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
          System.out.println("Exception "+ex);
          return -1;
        }
  }

        // Also include an inner class that is used for authentication purposes

private class SMTPAuthenticator extends javax.mail.Authenticator
{
     @Override
     public PasswordAuthentication getPasswordAuthentication()
     {
        String username =  "egas.sewa2012@gmail.com";  // specify sender's email id
        String password = "egassewa";              // specify your password here
        return new PasswordAuthentication(username, password);
     }
}

//example
public static void main(String s[]){
        
    MailCall m=new MailCall();
    try{
	m.sendMail("shashi.sharma619@gmail.com", "subject","You have been successfully registered to e-gas sewa");
    } 
    catch (Exception e) {	            
		
         e.printStackTrace();
    }
}


    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }


    /**
     * @return the smtpServ
     */
    public String getSmtpServ() {
        return smtpServ;
    }

    /**
     * @param smtpServ the smtpServ to set
     */
    public void setSmtpServ(String smtpServ) {
        this.smtpServ = smtpServ;
    }
}
