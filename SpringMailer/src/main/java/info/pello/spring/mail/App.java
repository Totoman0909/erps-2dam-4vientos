package info.pello.spring.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main App, gets an instance from Spring context and sends an email.
 * @author Pello Xabier Altadill Izura
 * @greetz those who receive an email using this emailer. 
 */
public class App {

    public static void main (String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springmailer.xml");
		
		Emailer emailer = (Emailer) context.getBean("emailer");
                
        System.out.println("Preparing email: ");
        emailer.setFrom("pello_altadill@cuatrovientos.org");
        emailer.setTo("pello_altadill@cuatrovientos.org");
        emailer.setSubject("testing Spring email");
        emailer.setText("Hola. Correo en castellano.");
        emailer.addAttachment(context.getResource("ultrakwel.jpg"));
       
        if (emailer.send()) {
        	System.out.println("OK Email Sended! " + emailer.toString());
        }
    }
}
