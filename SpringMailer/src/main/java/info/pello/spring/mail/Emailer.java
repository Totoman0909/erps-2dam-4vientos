package info.pello.spring.mail;

import java.util.Vector;

import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Sends emails using Spring framework facilities
 * mail server config resides in context + properties files
 * @author Pello Xabier Altadill Izura
 * @greetz For those who prefer c# rather than vb
 */
public class Emailer {
	
	private JavaMailSender mailSender;
	
	private Vector<Resource> attachments = new Vector<Resource>();
	private String from;
	private String to;
	private String subject;
	private String text;
	
	/**
	 * default constructor
	 */
	public Emailer () {
		
	}
	
	/**
	 * @param from
	 * @param to
	 * @param subject
	 * @param text
	 */
	public Emailer(String from, String to, String subject, String text) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	/**
	 * sends email with attachments if any
	 * @return
	 */
	public boolean send () {
		boolean result = false;
		 MimeMessage message = mailSender.createMimeMessage();
		    MimeMessageHelper helper;
		try {
				helper = new MimeMessageHelper(message, true);
		
		    helper.setFrom(from);
		    helper.setTo(to);
		    helper.setSubject(subject);
		    helper.setText(text);

		    // For each filename in attachment Vector
		    // we add an attachment
		    for (int i =0;i< attachments.size();i++)
		    	helper.addAttachment(attachments.get(i).getFilename(), attachments.get(i));
		    
		    mailSender.send(message);   
		    attachments.clear();
		    result = true;
		} catch (MessagingException e) {
			System.err.println("MessagingException :" + e.getMessage());
		} catch (Exception e) {
			System.err.println("General Exception :" + e.getMessage());				
		}
		return result;
	}
	
	/**
	 * adds an attachment to our email
	 * @param fileName
	 */
	public void addAttachment(Resource fileName) {
		attachments.add(fileName);
	}

	/**
	 * @return the mailSender
	 */
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	/**
	 * @param mailSender the mailSender to set
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Emailer [from=" + from + ", to=" + to + ", subject=" + subject
				+ "]";
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the message to set
	 */
	public void setText(String text) {
		this.text = text;
	}
}
