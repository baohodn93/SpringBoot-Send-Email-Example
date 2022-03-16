package com.blogjava.SpringEmailSend;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String toEmail, String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("springbootemail.send@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		javaMailSender.send(message);
		
		System.out.println("Mail Send....");
	}
	
	public void sendEmailWithAttrachment(String toEmail, 
			String body, 
			String subject,
			String attrachment) throws MessagingException {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		
		mimeMessageHelper.setFrom("springbootemail.send@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attrachment));
	
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		javaMailSender.send(mimeMessage);
		System.out.println("Mail Send...");
				
	}
}
