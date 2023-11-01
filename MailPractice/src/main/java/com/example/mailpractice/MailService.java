package com.example.mailpractice;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

	private final JavaMailSender javaMailSender;
	private final TemplateEngine templateEngine;

	public void sendSimpleMail( String destination, String subject, String text ) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo( destination );
		simpleMailMessage.setSubject( subject );
		simpleMailMessage.setText( text );
		javaMailSender.send( simpleMailMessage );
		log.info( "sendSimpleMail done" );
	}

	@Async
	public void sendHtmlMail( String destination, String subject, String text ) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		mimeMessage.addRecipients( Message.RecipientType.TO, destination );
		mimeMessage.setSubject( subject );
		mimeMessage.setText( setContext( text ), "utf-8", "html" );
		javaMailSender.send( mimeMessage );
		log.info( "sendHtmlMail done - service" );
	}

	private String setContext( String text ) {
		Context context = new Context();
		context.setVariable( "text", text );
		return templateEngine.process( "index", context );
	}
}
