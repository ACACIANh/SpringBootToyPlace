package com.example.mailpractice;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MailController {

	private final MailService mailService;

	@GetMapping( "/v1/hello" )
	public ResponseEntity< ? > hello() {
		return ResponseEntity.ok().build();
	}

	@PostMapping( "/v1/mail/simple" )
	public ResponseEntity< ? > simpleMail( @RequestBody MailRequestBody requestBody ) {

		mailService.sendSimpleMail( requestBody.getDestination(), requestBody.getSubject(), requestBody.getText() );
		return ResponseEntity.ok( requestBody );
	}

	@PostMapping( "/v1/mail/html" )
	public ResponseEntity< ? > htmlMail( @RequestBody MailRequestBody requestBody ) throws MessagingException {

		mailService.sendHtmlMail( requestBody.getDestination(), requestBody.getSubject(), requestBody.getText() );
		log.info( "sendHtmlMail done - controller" );
		return ResponseEntity.ok( requestBody );
	}
}
