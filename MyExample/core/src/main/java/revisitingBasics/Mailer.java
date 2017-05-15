package revisitingBasics;
import java.io.UnsupportedEncodingException;
import java.util.Properties;    

import javax.mail.*;    
import javax.mail.internet.*;    
class Mailer{  
    public  void send(){  
          //Get properties object    
          Properties props = new Properties();    
          String host = "smtp.gmail.com";

        //  props.put("mail.smtp.starttls.enable", "true");

         // props.put("mail.smtp.ssl.trust", host);
          props.put("mail.smtp.user", "abhigyandzapper@gmail.com");
          props.put("mail.smtp.password", "pontiacenzoq33nyme");
          props.put("mail.smtp.port", "587");
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication("abhigyandzapper@gmail.com","pontiacenzoq33nyme");  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session); 
           message.setFrom(new InternetAddress("abhigyandzapper@gmail.com", "NoReply"));
           message.addRecipient(Message.RecipientType.TO,
                            new InternetAddress("abhigyan.chatterjee.ac@gmail.com", "Mr. Recipient"));
           
           message.setSubject("sub-test");    
           message.setText("hey testy");    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {
        	  System.out.println(e.getMessage());
        	  
        	  
          } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
             
    }  
}  
