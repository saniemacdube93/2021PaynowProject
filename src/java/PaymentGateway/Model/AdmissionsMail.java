/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentGateway.Model;
//import StudentApplicationReg.Controllers.PersonalDetails;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Owen
 */
public class AdmissionsMail  {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
        public String b;
 
	/*public static void main(String args[]) throws AddressException, MessagingException, SQLException {
            
            //String a = "";
            //String b = "appId";
                AdmissionsMail ms = new AdmissionsMail();
		ms.sendreceipt();
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}*/
 

        
        public void senderror(String email, Double amount, String mobilenumber, String stud_id){
            try{
                
                
            	// Step1
            Properties mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "9222");
            mailServerProperties.put("mail.smtp.host", "196.220.96.9");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            // Step2
            Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            MimeMessage generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("software@nust.ac.zw"));
         //generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("thobekani.ncube@nust.ac.zw"));
            generateMailMessage.setSubject("NOTICE ::ERROR DURING TRANSACTION");
            String emailBody = "The student number'"+stud_id+"' has just returned a null. Please check what has occured. Mobile number is '"+mobilenumber+"'";
            generateMailMessage.setContent(emailBody, "text/html");
       
            System.out.println("Mail Session has been created successfully******************");
            // Step3
      
            Transport transport = null;
            transport = getMailSession.getTransport("smtp");
            // Enter your correct gmail UserID and Password
            // if you have 2FA enabled then provide App Specific Password
            transport.connect("196.220.96.9", "no-reply@nust.ac.zw", "icts1@nust.ac.zw");//relay.nust.ac.zw
       
            System.out.println(":Transport connection established****************Attempting to send email*******");
      
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());

            }catch(Exception ex){
                Logger.getLogger(AdmissionsMail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         public void sendreceipt(String email, String amount, String reference, String stud_id){
            try{
            	// Step1
            Properties mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "9222");
            mailServerProperties.put("mail.smtp.host", "196.220.96.9");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            // Step2
            Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            MimeMessage generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
         //generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("thobekani.ncube@nust.ac.zw"));
            generateMailMessage.setSubject("NOTICE ::RECEIPT OF PAYMENT");
            String emailBody = "The student number'"+stud_id+"' has just returned an amount of '"+amount+"'. This email is to confirm payment. Your reference number is '"+reference+"'. Thank you";
            generateMailMessage.setContent(emailBody, "text/html");
       
            System.out.println("Mail Session has been created successfully******************");
            // Step3
      
            Transport transport = null;
            transport = getMailSession.getTransport("smtp");
            // Enter your correct gmail UserID and Password
            // if you have 2FA enabled then provide App Specific Password
            transport.connect("196.220.96.9", "no-reply@nust.ac.zw", "icts1@nust.ac.zw");//relay.nust.ac.zw
       
            System.out.println(":Transport connection established****************Attempting to send email*******");
      
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());

            }catch(Exception ex){
                Logger.getLogger(AdmissionsMail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
