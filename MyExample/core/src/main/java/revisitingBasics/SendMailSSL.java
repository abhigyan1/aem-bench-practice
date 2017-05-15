package revisitingBasics;
import revisitingBasics.Mailer;
public class SendMailSSL{    
	 public static void main(String[] args) {   
		 Mailer mailer = new Mailer();
	     //from,password,to,subject,message  
	     mailer.send() ;  
	     //change from, password and to  
	 }    
	}    