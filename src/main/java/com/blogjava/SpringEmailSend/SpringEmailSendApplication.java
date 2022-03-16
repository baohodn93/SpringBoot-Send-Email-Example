package com.blogjava.SpringEmailSend;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailSendApplication {

	@Autowired
	private EmailSendService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEmailSendApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void  triggerMail() {
		service.sendEmail("springbootemail.send@gmail.com", 
				"This is the Email Body....", 
				"This is the Email Subject");
	}
	
	public void  triggerMailWithAttrachment() throws MessagingException {
		service.sendEmailWithAttrachment("springbootemail.send@gmail.com",
				"This is the Email Body with Attractment....", 
				"This is the Email Subject",
				"D:\\Hinh Nen\\hinhnen.jpg");
	}


}
