package com.example.stompchatting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ChatController {

	@MessageMapping( "/chat/send" )
	@SendTo( "/topic/public" )
	public ChatMessage receiveAndSendMessage( @Payload ChatMessage chatMessage ) {

		log.info( chatMessage.toString() );
		return chatMessage;
	}

	@GetMapping( "/" )
	public String index() {
		return "chat.html";
	}
}
